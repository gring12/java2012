package com.gring12.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JPasswordField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 데이터베이스 연결
					if(DBUtil.dbconn == null)DBUtil.DBConnect();
					
					Login frame = new Login();
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
	public Login() {
		setTitle("Login Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple Login Demo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(106, 10, 221, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER ID");
		lblNewLabel_1.setBounds(59, 92, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(59, 139, 72, 15);
		contentPane.add(lblNewLabel_2);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(163, 89, 164, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(20);
		
		txtUserPWD = new JPasswordField();
		txtUserPWD.setColumns(45);
		txtUserPWD.setBounds(163, 136, 164, 21);
		contentPane.add(txtUserPWD);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 데이터베이스 연결
				if(DBUtil.dbconn == null)DBUtil.DBConnect();
				// 입력된 유저 아이디와 비밀번호를 가져온다.
				String userid = txtUserID.getText();
				String userpwd = txtUserPWD.getText();
				// 유저 아이디와 비밀번호를 사용하여 이 유저 아이디와 비밀번호로 DB 연결 시도
				System.out.println(userid);
				System.out.println(userpwd);
			}
		});
		btnLogin.setBounds(168, 195, 97, 23);
		contentPane.add(btnLogin);
	}
}
