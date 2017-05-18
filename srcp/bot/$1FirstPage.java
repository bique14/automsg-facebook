package bot;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class $1FirstPage extends JFrame {
	testBotFaceBook tb;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					$1FirstPage frame = new $1FirstPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public $1FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGo = new JButton("Go to Login");
		btnGo.setBounds(53, 24, 140, 23);
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tb = new testBotFaceBook();
				tb.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnGo);

		JButton btnChkVersion = new JButton("Check version");
		btnChkVersion.setBounds(53, 66, 140, 23);
		btnChkVersion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","start","chkversion.bat"});
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnChkVersion);

		JButton btnDownload = new JButton("Download");
		btnDownload.setBounds(53, 107, 140, 23);
		btnDownload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://nodejs.org/dist/v4.4.1/node-v4.4.1-x86.msi";
					Desktop dt = Desktop.getDesktop();
					URI uri = new URI(url);
					dt.browse(uri.resolve(uri));
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		contentPane.add(btnDownload);

		JButton btnHelp = new JButton("Get Started");
		btnHelp.setBounds(53, 151, 140, 23);
		btnHelp.setEnabled(false);
		contentPane.add(btnHelp);

		setTitle("First");
		setResizable(false);
		this.setLocationRelativeTo(null);
	}

}
