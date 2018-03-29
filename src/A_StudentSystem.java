
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class A_StudentSystem extends Frame implements ActionListener {
	File f = new File("c:\\chenheng.txt");
	Label l1, l2;
	TextField t1, t2;
	Button b1, b2;
	TextArea text;

	A_StudentSystem() {
		l1 = new Label("ѧ��");
		l2 = new Label("����");
		t1 = new TextField(5);
		t2 = new TextField(5);
		b1 = new Button("¼��");
		b2 = new Button("��ѯ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		text = new TextArea(40, 50);
		setLayout(new FlowLayout());
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
		add(text);
		setVisible(true);
		setSize(400, 300);
		validate();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent arg0) {
		text.setText(null);
		if (arg0.getSource() == b1) {
			String sno = t1.getText();
			String sname = t2.getText();
			try {
				RandomAccessFile out = new RandomAccessFile(f, "rw");
				if (f.exists()) {
					out.seek(out.length());
				}
				out.writeUTF(sno);
				out.writeUTF(sname);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == b2) {
			try {
				if (f.exists()) {
					RandomAccessFile in = new RandomAccessFile(f, "r");
					long i = 0;
					while (i < in.length()) {
						text.append("\nѧ�ţ�" + in.readUTF());
						text.append("\n������" + in.readUTF());
						i = in.getFilePointer();
						text.append("\n---------------");
					}
					in.close();
				} else {
					text.append("������¼��");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
