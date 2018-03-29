
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.*;

public class B_StudentSystem_Search extends JFrame implements ActionListener {

	JLabel l_1, l_2;
	JTextArea t_1, t_2;
	JButton b_1, b_2;
	JTextField TF_1;
	JComboBox c_2;
	TreeSet<Student> mytree;

	B_StudentSystem_Search(TreeSet<Student> tree) 
	{
		init();
		mytree= tree;
		setBounds(600, 0, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {

		setLayout(new FlowLayout());

		l_1 = new JLabel("����ѧ��:");
		l_2 = new JLabel("���ճɼ�:");
		TF_1 = new JTextField(10);
		c_2 = new JComboBox();
		c_2.addItem("����");
		c_2.addItem("������");
		b_1 = new JButton("����");
		b_2 = new JButton("����");
		b_1.addActionListener(this);
		b_2.addActionListener(this);
		t_1 = new JTextArea(10, 40);
		t_2 = new JTextArea(10, 40);

		add(l_1);
		add(TF_1);
		add(b_1);
		add(new JScrollPane(t_1));
		add(l_2);
		add(c_2);
		add(b_2);
		add(new JScrollPane(t_2));

	}
	public void actionPerformed(ActionEvent e) {
		int count = 0;
		
		if (e.getSource() == b_1) {
			int i;
			String number = TF_1.getText();
			Iterator<Student> myiterator=mytree.iterator();
			while(myiterator.hasNext())
			{
				Student student=myiterator.next();
				if(student.s_number.equals(number))
				{
					count++;
					t_1.append(student.s_number+" "+student.s_name+" "+student.s_sex+" "+student.s_grade+"\n");
				}
				
				
			}
			
			t_1.append("һ���ҵ�" + count + "������" + "\n");
			t_1.append("------------------------------------------------------------"+ "\n");
			count = 0;

		} else if (e.getSource() == b_2) {
			String s = (String) c_2.getSelectedItem();
			if (s.equals("����") == true) {
				Iterator<Student> myiterator=mytree.iterator();
				while(myiterator.hasNext())
				{
					Student student=myiterator.next();
					if(student.s_grade>=60&&student.s_grade<=100)
					{
						count++;
						t_2.append(student.s_number+" "+student.s_name+" "+student.s_sex+" "+student.s_grade+"\n");
					}
					
					
				}
				
				t_2.append("һ���ҵ�" + count + "������" + "\n");
				t_2.append("------------------------------------------------------------"+ "\n");
				count = 0;
			} else if (s.equals("������") == true) {
				Iterator<Student> myiterator=mytree.iterator();
				while(myiterator.hasNext())
				{
					Student student=myiterator.next();
					if(student.s_grade>=0&&student.s_grade<=60)
					{
						count++;
						t_2.append(student.s_number+" "+student.s_name+" "+student.s_sex+" "+student.s_grade+"\n");
					}
					
					
				}
				t_2.append("һ���ҵ�" + count + "������" + "\n");
				t_2.append("------------------------------------------------------------"+ "\n");
				count = 0;
			}
		}

	}

}
