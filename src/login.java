
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
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

public class login extends JFrame implements ActionListener
{
	JLabel l_tubiao, l_name, l_password;
	JTextField t_name, t_password;
	JButton b_login, b_cancel;
	login() {
		init();
		setSize(200,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		setLayout(new FlowLayout());
		l_tubiao = new JLabel("            ��¼                                    ");
		l_name = new JLabel("�û���:");
		l_password = new JLabel("��    ��:");
		t_name = new JTextField(10);
		t_name.setText("�û�1");
		t_password = new JTextField(10);
		t_password.setText("111");
		b_login = new JButton("ȷ��");
		b_cancel = new JButton("ȡ��");
		b_login.addActionListener(this);
		b_cancel.addActionListener(this);
		add(l_tubiao);
		add(l_name);
		add(t_name);
		add(l_password);
		add(t_password);
		add(b_login);
		add(b_cancel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_login) {
			String name = t_name.getText();
			String password = t_password.getText();
			FileReader fileReader;
			
			boolean b = false;
			try {
				fileReader = new FileReader("user.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					StringTokenizer fenxi = new StringTokenizer(str, ",");
					String file_name = fenxi.nextToken();
					String file_password = fenxi.nextToken();
					
					if ((file_name.equals(name))
							&& (file_password.equals(password))==true) {
						System.out.println(file_name + " " + file_password
								+ "��½�ɹ�");
						b = true;
						break;
					} else {
						b = false;
					}
				}
				if (b == true) {
					new login_succeed();
				} else {
					System.out.println("��¼ʧ��");
					new login_failed();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.dispose();
		} else if (e.getSource() == b_cancel) {
			t_name.setText("");
			t_password.setText("");
		}
	}
}
