
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class B_StudentSystem extends JFrame implements ActionListener {
	JLabel l_tubiao, l_name, l_number, l_sex, l_grade;
	JTextField t_name, t_number, t_grade;
	JButton b_luru, b_search;
	JComboBox c_sex;
	TreeSet<Student> mytree= new TreeSet<Student>();	

	B_StudentSystem() {
		init();
		setBounds(400, 0, 200, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		setLayout(new FlowLayout());
		l_tubiao = new JLabel("                      ѧ��ϵͳ                 ");
		l_name = new JLabel("�û���:");
		l_number = new JLabel("ѧ    ��:");
		l_sex = new JLabel("��    ��:                        ");
		l_grade = new JLabel("��    ��:");
		t_name = new JTextField(10);
		t_number = new JTextField(10);
		t_grade = new JTextField(null,10);
		c_sex = new JComboBox();
		c_sex.addItem("��");
		c_sex.addItem("Ů");
		b_luru = new JButton("¼��");
		b_search = new JButton("����");
		b_luru.addActionListener(this);
		b_search.addActionListener(this);
		add(l_tubiao);
		add(l_name);
		add(t_name);
		add(l_number);
		add(t_number);
		add(l_sex);
		add(c_sex);
		add(l_grade);
		add(t_grade);
		add(b_luru);
		add(b_search);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_luru) {
			if(!(t_name.getText().trim().equals("")||t_number.getText().trim().equals("")||t_grade.getText().trim().equals("")))
			{
			String name = t_name.getText();
			String number = t_number.getText();
			String sex = (String) c_sex.getSelectedItem();
			int grade = Integer.parseInt(t_grade.getText());
			Student s = new Student(name, number, sex, grade);
			mytree.add(s);
			System.out.println("¼��ɹ�������ı�������");
			t_name.setText(null);
			t_number.setText(null);
			t_grade.setText(null);
			}
			else{
				System.out.println("�ַ�Ϊ��,����������");
			}
			Iterator<Student> myiterator=mytree.iterator();
			while(myiterator.hasNext())
			{
				Student student=myiterator.next();
				System.out.println(student.s_number+" "+student.s_name+" "+student.s_sex+" "+student.s_grade+" ");
				
			}
			
		} else if (e.getSource() == b_search) {
			new B_StudentSystem_Search(mytree);
		}

	}

}
