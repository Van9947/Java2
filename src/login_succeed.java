
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class login_succeed extends JFrame implements ActionListener {

	JLabel l_tubiao;
	JButton b_enter;

	login_succeed() {
		init();
		setSize(200,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		setLayout(new FlowLayout());
		l_tubiao = new JLabel("     欢迎         ");
		b_enter = new JButton("进入系统");
		b_enter.addActionListener(this);
		add(l_tubiao);
		add(b_enter);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_enter) {
			this.dispose();
			Thread_A a = new Thread_A();
			a.start();
			Thread_B b = new Thread_B();
			b.start();
		}
	}
}
