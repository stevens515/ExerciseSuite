package gobang;


import java.awt.*;

@SuppressWarnings("serial")
class userPad extends Panel {
	List userList = new List(10);

	userPad() {
		setLayout(new BorderLayout());

		for (int i = 1; i <= 50; i++) {
			userList.add(i + "." + "û���û�");
		}
		add(userList, BorderLayout.CENTER);
	}

}

@SuppressWarnings("serial")
class chatPad extends Panel {
	TextArea chatLineArea = new TextArea("", 18, 30,
			TextArea.SCROLLBARS_VERTICAL_ONLY);

	chatPad() {
		setLayout(new BorderLayout());

		add(chatLineArea, BorderLayout.CENTER);
	}

}

@SuppressWarnings("serial")
class controlPad extends Panel {
	Label IPlabel = new Label("IP", Label.LEFT);
	TextField inputIP = new TextField("172.16.12.146", 10);
	Button connectButton = new Button("��������");
	Button creatGameButton = new Button("������Ϸ");
	Button joinGameButton = new Button("������Ϸ");
	Button cancelGameButton = new Button("������Ϸ");
	Button exitGameButton = new Button("�رճ���");

	controlPad() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.cyan);

		add(IPlabel);
		add(inputIP);
		add(connectButton);
		add(creatGameButton);
		add(joinGameButton);
		add(cancelGameButton);
		add(exitGameButton);
	}

}

@SuppressWarnings("serial")
class inputPad extends Panel {
	TextField inputWords = new TextField("", 40);
	Choice userChoice = new Choice();

	inputPad() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		for (int i = 1; i <= 50; i++) {
			userChoice.addItem(i + "." + "û���û�");
		}
		userChoice.setSize(60, 24);
		add(userChoice);
		add(inputWords);
	}
}