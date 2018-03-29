
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

public class login_failed extends JFrame implements ActionListener {

	JLabel l_tubiao;
	JButton b_back;

	login_failed() {
		init();
		setSize(200, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void init() {
		setLayout(new FlowLayout());
		l_tubiao = new JLabel("用户名或密码填写错误");
		b_back = new JButton("返回");
		b_back.addActionListener(this);
		add(l_tubiao);
		add(b_back);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_back) {
			this.dispose();
			new login();
		}

	}

}
