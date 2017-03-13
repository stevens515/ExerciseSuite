package com.tarena.elts.ui;//��ͼ��

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
	//ѡ��ϣ�����𰸶�ȡ�Ĵ���
	private Option[] options = new Option[4];
	
	private ClientContext clientContext;
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	
	public ExamFrame(){
		init();
		//this.setVisible(true);
	}
	private void init(){
		this.setTitle("���ڿƼ���������");
		this.setSize(600, 380);
		this.setLocationRelativeTo(null);
		setContentPane(createContentPane());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				clientContext.send();
			}
		});
	}
	private JPanel createContentPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(6,6,6,6));
		ImageIcon icon = new ImageIcon(
				getClass().getResource("exam_title.png"));
		
		p.add(BorderLayout.NORTH,new JLabel(icon));
		p.add(BorderLayout.CENTER,createCenterPane());
		p.add(BorderLayout.SOUTH,createSouthPane());
		return p;
	}
	private JPanel createCenterPane(){
		JPanel p = new JPanel(new BorderLayout());
		//ע��
		JLabel info = new JLabel(
				"������XXX  ���ԣ�XXX  ����ʱ�䣺XXX  ���Կ�Ŀ��XXX  ��Ŀ������XX",
				JLabel.CENTER);
		this.examInfo = info; 
		
		p.add(BorderLayout.NORTH,info);
		p.add(BorderLayout.CENTER,createQuestionPane());//�������
		p.add(BorderLayout.SOUTH,createOptionsPane());//ѡ�����
		return p;
	}
	private JScrollPane createQuestionPane(){
		JScrollPane p = new JScrollPane();
		p.setBorder(new TitledBorder("��Ŀ"));//�����
		//ע��
		/*JTextArea*/ questionArea = new JTextArea();
		
		questionArea.setText("����\nA.\nB.");
		questionArea.setLineWrap(true);//����������ʾ
		questionArea.setEditable(false);//���ܹ��༭����
		//JTextArea ����ŵ� JScrollPane ����ͼ������(Viewport)
		p.getViewport().add(questionArea);		
		return p;
	}
	private JPanel createOptionsPane(){
		JPanel p = new JPanel();
		
		Option a = new Option(0,"A");
		Option b = new Option(1,"B");
		Option c = new Option(2,"C");
		Option d = new Option(3,"D");
		
		options[0] = a;
		options[1] = b;
		options[2] = c;
		options[3] = d;
		
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		return p;
	}
	
	private JPanel createSouthPane(){
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(0,10,0,10));
		//ע��
		questionCount = new JLabel("��Ŀ:20 �� 1��");
		timer = new JLabel("ʣ��ʱ�䣺222��");
		
		p.add(BorderLayout.WEST,questionCount);
		p.add(BorderLayout.EAST,timer);
		p.add(BorderLayout.CENTER,createBtnPane());
		return p;
	}
	private JPanel createBtnPane(){
		JPanel p = new JPanel(new FlowLayout());
		
		 prev = new JButton("<<��һ��");
		 next = new JButton("��һ��>>");
		 JButton send = new JButton("����");
		
		 getRootPane().setDefaultButton(next);
		 
		p.add(prev);
		p.add(next);
		p.add(send);
		
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
		return p;
	}
	/** ʹ���ڲ�����չ�� JCheckBox ������val���� �������ֵ*/
	class Option extends JCheckBox{
		private static final long serialVersionUID = -5357210068923979044L;
		//javaԼ��  ����ʵ�����л��ӿ�  ���дһ�����к�
		//java API ���������������л��ӿ�
		int value;
		public Option(int val,String txt){
			super(txt);
			this.value = val;
		}
	}
	
	private JLabel examInfo;
	private JTextArea questionArea;
	public void updateView(ExamInfo examInfo, QuestionInfo questionInfo) {
		//���½���
		//System.out.println("mingzi");
		this.examInfo.setText(examInfo.toString());
		questionArea.setText(questionInfo.toString());
		
		updateButton(examInfo.getQuestionCount(),
				questionInfo.getQuestionIndex());
		updateQuestionCount(examInfo.getQuestionCount(),
				questionInfo.getQuestionIndex());
		updateOptions(questionInfo.getUserAnswers());
	}
	private JButton prev;
	private JButton next;
	private JLabel questionCount;
	
	private void updateOptions(List<Integer> userAnswers){
		for(Option option : options){
			option.setSelected(userAnswers.contains(option.value));
		}
	}
	
	private void updateQuestionCount(int questionCount,int questionIndex){
		String str = "��Ŀ:"+questionCount + " �ģ�"+(questionIndex+1)+"��.";
		this.questionCount.setText(str);
	}
	
	private void updateButton(int questionCount,int questionIndex){
		prev.setEnabled(questionIndex != 0);
		next.setEnabled((questionCount-1)!= questionIndex);
	}
	
	public List<Integer> getUserAnswers() {
		List<Integer> list = new ArrayList<Integer>();
		for(Option option:options){
			if(option.isSelected()){
				list.add(option.value);
			}
		}
		return list;
	}
	private JLabel timer;
	public void updateTime(long h,long m,long s){
		String time ="ʣ��ʱ�䣺"+ h+":"+m+":"+s;
		if(h==0 && m<5){
			timer.setForeground(new Color(0xc85848));
		}else{
			timer.setForeground(Color.BLUE);
		}
		timer.setText(time);
	}
	
}

