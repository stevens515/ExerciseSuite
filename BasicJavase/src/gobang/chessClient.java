package gobang;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JFrame;

class clientThread extends Thread {
	chessClient chessclient;

	clientThread(chessClient chessclient) {
		this.chessclient = chessclient;
	}

	public void acceptMessage(String recMessage) {
		if (recMessage.startsWith("/userlist ")) {
			StringTokenizer userToken = new StringTokenizer(recMessage, " ");
			int userNumber = 0;

			chessclient.userpad.userList.removeAll();
			chessclient.inputpad.userChoice.removeAll();
			chessclient.inputpad.userChoice.addItem("������");
			while (userToken.hasMoreTokens()) {
				String user = (String) userToken.nextToken(" ");
				if (userNumber > 0 && !user.startsWith("[inchess]")) {
					chessclient.userpad.userList.add(user);
					chessclient.inputpad.userChoice.addItem(user);
				}

				userNumber++;
			}
			chessclient.inputpad.userChoice.select("������");
		} else if (recMessage.startsWith("/yourname ")) {
			chessclient.chessClientName = recMessage.substring(10);
			chessclient.setTitle("Java������ͻ��� " + "�û���:"
					+ chessclient.chessClientName);
		} else if (recMessage.equals("/reject")) {
			try {
				chessclient.chesspad.statusText.setText("���ܼ�����Ϸ");
				chessclient.controlpad.cancelGameButton.setEnabled(false);
				chessclient.controlpad.joinGameButton.setEnabled(true);
				chessclient.controlpad.creatGameButton.setEnabled(true);
			} catch (Exception ef) {
				chessclient.chatpad.chatLineArea
						.setText("chessclient.chesspad.chessSocket.close�޷��ر�");
			}
			chessclient.controlpad.joinGameButton.setEnabled(true);
		} else if (recMessage.startsWith("/peer ")) {
			chessclient.chesspad.chessPeerName = recMessage.substring(6);
			if (chessclient.isServer) {
				chessclient.chesspad.chessColor = 1;
				chessclient.chesspad.isMouseEnabled = true;
				chessclient.chesspad.statusText.setText("���������");
			} else if (chessclient.isClient) {
				chessclient.chesspad.chessColor = -1;
				chessclient.chesspad.statusText.setText("�Ѽ�����Ϸ���ȴ��Է�����...");
			}

		} else if (recMessage.equals("/youwin")) {
			chessclient.isOnChess = false;
			chessclient.chesspad.chessVictory(chessclient.chesspad.chessColor);
			chessclient.chesspad.statusText.setText("�Է��˳�����������Ϸ�˳�����");
			chessclient.chesspad.isMouseEnabled = false;
		} else if (recMessage.equals("/OK")) {
			chessclient.chesspad.statusText.setText("������Ϸ�ɹ����ȴ����˼���...");
		} else if (recMessage.equals("/error")) {
			chessclient.chatpad.chatLineArea.append("����������˳��������¼��� \n");
		} else {
			chessclient.chatpad.chatLineArea.append(recMessage + "\n");
			chessclient.chatpad.chatLineArea
					.setCaretPosition(chessclient.chatpad.chatLineArea
							.getText().length());
		}
	}

	public void run() {
		String message = "";
		try {
			while (true) {
				message = chessclient.in.readUTF();
				acceptMessage(message);
			}
		} catch (IOException es) {
		}
	}
}

@SuppressWarnings({ "serial" })
public class chessClient extends JFrame implements ActionListener, KeyListener {
	// ����Ϊ�������
	userPad userpad = new userPad();
	chatPad chatpad = new chatPad();
	controlPad controlpad = new controlPad();
	inputPad inputpad = new inputPad();
	chessPad chesspad = new chessPad();
	// �������
	Socket chatSocket;
	// IO������
	DataInputStream in;
	DataOutputStream out;

	String chessClientName = null;
	String host = null;

	int port = 4331;

	boolean isOnChat = false; // �����죿
	boolean isOnChess = false; // �����壿
	boolean isGameConnected = false; // ����Ŀͻ������ӣ�
	boolean isServer = false; // ��������������
	boolean isClient = false; // ���������Ŀͻ���

	Panel southPanel = new Panel();
	// Panel northPanel = new Panel();
	Panel centerPanel = new Panel();
	Panel westPanel = new Panel();

	// Panel eastPanel = new Panel();

	chessClient() {
		super("Java�����������ͻ���");
		// ���ñ�����ɫ
		setBackground(Color.cyan);

		setLayout(new BorderLayout());
		// ���IP��ַ
		host = controlpad.inputIP.getText();

		westPanel.setLayout(new BorderLayout());
		westPanel.add(userpad, BorderLayout.NORTH);
		westPanel.add(chatpad, BorderLayout.CENTER);
		westPanel.setBackground(Color.cyan);

		inputpad.inputWords.addKeyListener(this);
		chesspad.host = controlpad.inputIP.getText();

		centerPanel.add(chesspad, BorderLayout.CENTER);
		centerPanel.add(inputpad, BorderLayout.SOUTH);
		centerPanel.setBackground(Color.cyan);

		controlpad.connectButton.addActionListener(this);
		controlpad.creatGameButton.addActionListener(this);
		controlpad.joinGameButton.addActionListener(this);
		controlpad.cancelGameButton.addActionListener(this);
		controlpad.exitGameButton.addActionListener(this);

		controlpad.creatGameButton.setEnabled(false);
		controlpad.joinGameButton.setEnabled(false);
		controlpad.cancelGameButton.setEnabled(false);

		southPanel.add(controlpad, BorderLayout.CENTER);
		southPanel.setBackground(Color.cyan);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (isOnChat) {
					try {
						chatSocket.close();
					} catch (Exception ed) {
					}
				}
				if (isOnChess || isGameConnected) {
					try {
						chesspad.chessSocket.close();
					} catch (Exception ee) {
					}
				}
				System.exit(0);
			}

			public void windowActivated(WindowEvent ea) {

			}
		});

		// ������������ӵ���������
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		pack();
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		validate();
	}

	public boolean connectServer(String serverIP, int serverPort)
			throws Exception {
		try {
			chatSocket = new Socket(serverIP, serverPort);
			in = new DataInputStream(chatSocket.getInputStream());
			out = new DataOutputStream(chatSocket.getOutputStream());

			clientThread clientthread = new clientThread(this);
			clientthread.start();
			isOnChat = true;
			return true;
		} catch (IOException ex) {
			chatpad.chatLineArea
					.setText("chessClient:connectServer:�޷�����,���������������� \n");
		}
		return false;
	}

	// ���ӷ���������
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == controlpad.connectButton) {
			host = chesspad.host = controlpad.inputIP.getText();
			try {
				if (connectServer(host, port)) {
					chatpad.chatLineArea.setText("");
					controlpad.connectButton.setEnabled(false);
					controlpad.creatGameButton.setEnabled(true);
					controlpad.joinGameButton.setEnabled(true);
					chesspad.statusText.setText("���ӳɹ����봴����Ϸ�������Ϸ");
				}

			} catch (Exception ei) {
				chatpad.chatLineArea
						.setText("controlpad.connectButton:�޷�����,���������������� \n");
			}
		}
		if (e.getSource() == controlpad.exitGameButton) {
			if (isOnChat) {
				try {
					chatSocket.close();
				} catch (Exception ed) {
				}
			}
			if (isOnChess || isGameConnected) {
				try {
					chesspad.chessSocket.close();
				} catch (Exception ee) {
				}
			}
			System.exit(0);

		}
		if (e.getSource() == controlpad.joinGameButton) {
			String selectedUser = userpad.userList.getSelectedItem();
			if (selectedUser == null || selectedUser.startsWith("[inchess]")
					|| selectedUser.equals(chessClientName)) {
				chesspad.statusText.setText("������ѡ��һ����Ч�û�");
			} else {
				try {
					if (!isGameConnected) {
						if (chesspad
								.connectServer(chesspad.host, chesspad.port)) {
							isGameConnected = true;
							isOnChess = true;
							isClient = true;
							controlpad.creatGameButton.setEnabled(false);
							controlpad.joinGameButton.setEnabled(false);
							controlpad.cancelGameButton.setEnabled(true);
							chesspad.chessthread.sendMessage("/joingame "
									+ userpad.userList.getSelectedItem() + " "
									+ chessClientName);
						}
					} else {
						isOnChess = true;
						isClient = true;
						controlpad.creatGameButton.setEnabled(false);
						controlpad.joinGameButton.setEnabled(false);
						controlpad.cancelGameButton.setEnabled(true);
						chesspad.chessthread.sendMessage("/joingame "
								+ userpad.userList.getSelectedItem() + " "
								+ chessClientName);
					}

				} catch (Exception ee) {
					isGameConnected = false;
					isOnChess = false;
					isClient = false;
					controlpad.creatGameButton.setEnabled(true);
					controlpad.joinGameButton.setEnabled(true);
					controlpad.cancelGameButton.setEnabled(false);
					chatpad.chatLineArea
							.setText("chesspad.connectServer�޷����� \n" + ee);
				}

			}
		}
		if (e.getSource() == controlpad.creatGameButton) {
			try {
				if (!isGameConnected) {
					if (chesspad.connectServer(chesspad.host, chesspad.port)) {
						isGameConnected = true;
						isOnChess = true;
						isServer = true;
						controlpad.creatGameButton.setEnabled(false);
						controlpad.joinGameButton.setEnabled(false);
						controlpad.cancelGameButton.setEnabled(true);
						chesspad.chessthread.sendMessage("/creatgame "
								+ "[inchess]" + chessClientName);
					}
				} else {
					isOnChess = true;
					isServer = true;
					controlpad.creatGameButton.setEnabled(false);
					controlpad.joinGameButton.setEnabled(false);
					controlpad.cancelGameButton.setEnabled(true);
					chesspad.chessthread.sendMessage("/creatgame "
							+ "[inchess]" + chessClientName);
				}
			} catch (Exception ec) {

				isGameConnected = false;
				isOnChess = false;
				isServer = false;
				controlpad.creatGameButton.setEnabled(true);
				controlpad.joinGameButton.setEnabled(true);
				controlpad.cancelGameButton.setEnabled(false);
				ec.printStackTrace();
				chatpad.chatLineArea.setText("chesspad.connectServer�޷����� \n"
						+ ec);
			}

		}
		if (e.getSource() == controlpad.cancelGameButton) {
			if (isOnChess) {
				chesspad.chessthread.sendMessage("/giveup " + chessClientName);
				chesspad.chessVictory(-1 * chesspad.chessColor);
				controlpad.creatGameButton.setEnabled(true);
				controlpad.joinGameButton.setEnabled(true);
				controlpad.cancelGameButton.setEnabled(false);
				chesspad.statusText.setText("�뽨����Ϸ���߼�����Ϸ");
			}
			if (!isOnChess) {
				controlpad.creatGameButton.setEnabled(true);
				controlpad.joinGameButton.setEnabled(true);
				controlpad.cancelGameButton.setEnabled(false);
				chesspad.statusText.setText("�뽨����Ϸ���߼�����Ϸ");
			}
			isClient = isServer = false;
		}

	}

	public void keyPressed(KeyEvent e) {
		TextField inputWords = (TextField) e.getSource();

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (inputpad.userChoice.getSelectedItem().equals("������")) {
				try {
					out.writeUTF(inputWords.getText());
					inputWords.setText("");
				} catch (Exception ea) {
					chatpad.chatLineArea
							.setText("chessClient:KeyPressed�޷�����,������������ \n");
					userpad.userList.removeAll();
					inputpad.userChoice.removeAll();
					inputWords.setText("");
					controlpad.connectButton.setEnabled(true);
				}
			} else {
				try {
					out.writeUTF("/" + inputpad.userChoice.getSelectedItem()
							+ " " + inputWords.getText());
					inputWords.setText("");
				} catch (Exception ea) {
					chatpad.chatLineArea
							.setText("chessClient:KeyPressed�޷�����,������������ \n");
					userpad.userList.removeAll();
					inputpad.userChoice.removeAll();
					inputWords.setText("");
					controlpad.connectButton.setEnabled(true);
				}
			}
		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		chessClient chessClient = new chessClient();
	}
}
