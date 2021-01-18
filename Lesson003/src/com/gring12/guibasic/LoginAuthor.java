package com.gring12.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginAuthor extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DBUtil.dbconn == null)
						DBUtil.DBConnect();

					LoginAuthor frame = new LoginAuthor();
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
	public LoginAuthor() {
		setTitle("Author Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Author Management System");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 23, 249, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 103, 95, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(71, 158, 95, 25);
		contentPane.add(lblNewLabel_1_1);

		txtUserName = new JTextField();
		txtUserName.setBounds(178, 103, 175, 25);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(178, 158, 175, 25);
		contentPane.add(txtUserPWD);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DBUtil.dbconn == null)
					DBUtil.DBConnect();

				String username = txtUserName.getText();
				String userpwd = txtUserPWD.getText();

				String sql = "SELECT * FROM tblmanagement WHERE username=? AND userpwd=?";

				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, userpwd);

					ResultSet rs = pstmt.executeQuery();

					if (rs.next()) {
						rs.close();
						pstmt.close();

						dispose();
						if (username.equals("admin")) {
							AuthorInfo authorinfo = new AuthorInfo();
							authorinfo.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "관리자 계정이 아님");
						}
					} else {
						System.out.println("아이디와 비번을 다시 확인해주세요.");
					}
				} catch (SQLException elogin) { // 오류,에러 등의 예외 발생 시 처리
					System.out.println("Error : " + elogin.getMessage());
					elogin.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(302, 214, 97, 23);
		contentPane.add(btnLogin);
	}
}
