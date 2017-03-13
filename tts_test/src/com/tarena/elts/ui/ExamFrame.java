package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;

public class ExamFrame extends JFrame{

	private static final long serialVersionUID = -5355432125621015300L;
	// ѡ���, ����𰸶�ȡ�Ĵ���
	private Option[] options = new Option[4];

	public ExamFrame() {
		init();
	}

	private void init() {
		setTitle("�������߲���ϵͳ");
		setSize(600, 380);
		setContentPane(createContentPane());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				clientContext.send();
			}
		});
	}
	private JPanel createContentPane(){
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(getClass().getResource("exam_title.png"));
		pane.setBorder(new EmptyBorder(6,6,6,6));
		pane.add(BorderLayout.NORTH,new JLabel(icon));
		pane.add(BorderLayout.CENTER,createCenterPane());
		pane.add(BorderLayout.SOUTH,createToolsPane());
		return pane;
	}
	
	private JPanel createCenterPane(){
		JPanel pane = new JPanel(new BorderLayout());
		JLabel examInfo = new JLabel("�������ֶ���  ��ţ�1001"+
				"����ʱ��:1���� ���Կ�Ŀ��Javase�׶β��� 	��Ŀ������20",JLabel.CENTER);
		pane.add(BorderLayout.NORTH,examInfo);
		pane.add(BorderLayout.CENTER,createQuestionPane());
		pane.add(BorderLayout.SOUTH,createOptionsPane());
		return pane;
	}
	private JPanel createOptionsPane(){
		JPanel pane = new JPanel();
		Option a = new Option(0,"A");
		Option b = new Option(1,"B");
		Option c = new Option(2,"C");
		Option d = new Option(3,"D");
		options[0] = a;
		options[1] = b;
		options[2] = c;
		options[3] = d;
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		return pane;
	}
	//�ṩ����������� scrollable ��ͼ��JScrollPane �����ӿڡ���ѡ�Ĵ�ֱ��ˮƽ�������Լ���ѡ���к��б����ӿڡ�
	 //���˹��������ӿ�֮�⣬JScrollPane Ҳ������һ���б����һ���б��⡣
	private JScrollPane createQuestionPane(){
		JScrollPane pane = new JScrollPane();
		pane.setBorder(new TitledBorder("��Ŀ"));//�����
		//JTextArea��һ����ʾ���ı��Ķ�������
		JTextArea questionArea = new JTextArea();
		questionArea.setText("����\nA.\nB.\nC.\nD");
		questionArea.setLineWrap(true);//����������ʾ
		questionArea.setEditable(false);//���ܹ��༭����
		//JTextArea ����ŵ� JScrollPane ����ͼ������(Viewport)
		pane.getViewport().add(questionArea);
		return pane;
	}
	private JPanel createToolsPane(){
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(0,10,0,10));
		//ע�⣺
		JLabel questionCount = new JLabel("��Ŀ��20�ĵ�1��");
		JLabel timer = new JLabel("ʣ��60��");
		
		pane.add(BorderLayout.WEST,questionCount);
		pane.add(BorderLayout.EAST,timer);
		pane.add(BorderLayout.CENTER,createBtnPane());
		return pane;
	}
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext){
		this.clientContext = clientContext;
	}
	private JPanel createBtnPane(){
		JPanel pane = new JPanel(new FlowLayout());
		JButton prev = new JButton("��һ��");
		JButton next = new JButton("��һ��");
		JButton send = new JButton("����");
		pane.add(prev);
		pane.add(next);
		pane.add(send);
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.prev();
			}
		});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.next();
			}
		});
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clientContext.send();
			}
		});
		return pane;
	}
	
	class Option extends JCheckBox {// ��ѡ��

		private static final long serialVersionUID = -5357210068923979044L;
		int value;
		
		public Option(int value, String txt) {//(0,A),(1,B),(2,C)
			super(txt);//��������
			this.value = value;//��������
		}
	}
	private JLabel info;
	private JLabel questionCount;
	private JTextArea questionArea;
	public void updateView(ExamInfo examInfo,QuestionInfo questionInfo){
		info.setText(examInfo.toString());
		questionCount.setText("��Ŀ��"+
				examInfo.getQuestionCount()+"��"+
				(questionInfo.getQuestionIndex()+1)+"��");
		questionArea.setText(questionInfo.toString());
//		 ������ͼΪ��/��һ��(���� �û��Ĵ�)
		updateOptions(questionInfo.getUserAnswers());
	}
	private void updateOptions(List<Integer> userAnswers){
		for(Option o : options){
			o.setSelected(false);
			if(userAnswers.contains(o.value)){
				o.setSelected(true);
			}
		}
	}
	public List<Integer> getUserAnswers(){
		List<Integer> ans = new ArrayList<Integer>();
		for(Option o : options){
			if(o.isSelected()){
				ans.add(o.value);
			}
		}
		return ans;
	}
	private JLabel timer;
	public void updateTime(long h,long m,long s){
		String time = h+":"+m+":"+s;
		if(h==0&&m<5){
			timer.setForeground(Color.blue);
		}
		timer.setText(time);
	}
}
