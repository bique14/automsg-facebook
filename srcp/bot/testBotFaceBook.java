package bot;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class testBotFaceBook extends JFrame implements ActionListener {
	JTextField txtID;
	JLabel lblEmail, lblPWD;
	JPasswordField txtPWD;
	JButton btnLOGIN, btnLOGOUT;
	JPanel contentPane;
	JProgressBar progressBar;
	BufferedReader br;
	String regexEmail = "(.*@((hotmail)|(gmail)).com)|([0-9]{10})";

	public testBotFaceBook() {
		this.setLayout(new FlowLayout());
		setBounds(100, 100, 341, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 31, 46, 14);
		contentPane.add(lblEmail);

		lblPWD = new JLabel("Password");
		lblPWD.setBounds(36, 67, 65, 14);
		contentPane.add(lblPWD);

		txtID = new JTextField();
		txtID.setBounds(110, 28, 176, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtPWD = new JPasswordField();
		txtPWD.setBounds(110, 64, 176, 20);
		contentPane.add(txtPWD);

		btnLOGIN = new JButton("Login");
		btnLOGIN.setBounds(66, 102, 89, 23);
		contentPane.add(btnLOGIN);

		btnLOGOUT = new JButton("Logout");
		btnLOGOUT.setBounds(176, 102, 89, 23);
		btnLOGOUT.setEnabled(false);
		btnLOGOUT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(txtPWD.getPassword());
				try {
					File file = new File("index.js");
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = "", oldtext = "";
					while ((line = reader.readLine()) != null) {
						oldtext += line + "\n";
					}
					reader.close();

					String email = oldtext.replaceAll(txtID.getText(), "KUAY1");
					String pwd = email.replaceAll(password, "KUAY2");
					FileWriter writer = new FileWriter("index.js");
					writer.append(pwd);
					writer.close();
					txtID.setEditable(true);
					txtPWD.setEditable(true);
					txtID.setText("");
					txtPWD.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnLOGOUT);

		progressBar = new JProgressBar();
		progressBar.setBounds(15, 155, 305, 14);
		progressBar.setStringPainted(true);

		contentPane.add(progressBar);

		btnLOGIN.addActionListener(this);
		txtPWD.addActionListener(this);

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Bot facebook 2017 by xBique");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void accessLogin() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				txtID.setEditable(false);
				txtPWD.setEditable(false);
				for (int i = 0; i <= 100; i++) {
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					progressBar.setValue(i);
					if (i >= 0 && i < 33)
						progressBar.setForeground(Color.red);
					else if (i >= 33 && i < 66)
						progressBar.setForeground(Color.yellow);
					else if (i > 66)
						progressBar.setForeground(Color.green);
				}
				runBot();
			}
		};
		new Thread(runnable).start();
	}

	public void runBot() {
		btnLOGOUT.setEnabled(true);
		try {
			Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", "start", "runBot.bat" });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new testBotFaceBook().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String password = String.valueOf(txtPWD.getPassword());
		try {
			File file = new File("index.js");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "", oldtext = "";
			while ((line = reader.readLine()) != null) {
				oldtext += line + "\n";
			}
			reader.close();
			if (txtID.getText().matches(regexEmail)) {
				String email = oldtext.replaceAll("KUAY1", txtID.getText());
				String pwd = email.replaceAll("KUAY2", password);
				FileWriter writer = new FileWriter("index.js");
				writer.append(pwd);
				writer.close();
				accessLogin();
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Email");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
