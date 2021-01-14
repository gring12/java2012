package com.gring12.guibasic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
					if (DBUtil.dbconn == null)
						DBUtil.DBConnect();

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

		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setBounds(81, 87, 72, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(81, 129, 72, 15);
		contentPane.add(lblNewLabel_2);

		txtUserID = new JTextField();
		txtUserID.setBounds(185, 84, 164, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(20);

		txtUserPWD = new JPasswordField();
		txtUserPWD.setColumns(45);
		txtUserPWD.setBounds(185, 126, 164, 21);
		contentPane.add(txtUserPWD);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 데이터베이스 연결
				if (DBUtil.dbconn == null)
					DBUtil.DBConnect();
				// 입력된 유저 아이디와 비밀번호를 가져온다.
				String username = txtUserID.getText();
				String userpwd = new String(txtUserPWD.getPassword());
				// 입력된 아이디와 비번 확인
//				System.out.println(username);
//				System.out.println(userpwd);

				// 유저아이디와 비밀번호를 사용하여 데이터베이스 조회
				/*
				 * SELECT 속성리스트[* all, 모든 속성] FROM 테이블이름 WHERE 조건
				 */
				// sql 구문 구성
				String sql = "SELECT * FROM tbluser WHERE username=? AND userpwd=?";

				try {
					// 유저 아이디와 비밀번호를 사용하여 이 유저 아이디와 비밀번호로 DB 연결 시도
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, username); // username 변수값으로 sql구문의 첫번째 ? 에 대입
					pstmt.setString(2, userpwd);// userpwd 변수값으로 sql구문의 두번째 ? 에 대입

					// 최종 완성된 질의구문을 실행하고 그 결과를 ResultSet으로 받아온다.
					ResultSet rs = pstmt.executeQuery();

					// resultset rs내에는 검색된 결과값들이 들어있는데...
					if (rs.next()) { // 해당 계정이 있으면, 정상 로그인
						rs.close();
						pstmt.close();
						// System.out.println("로그인성공");
						// 로그인 창을 닫고, 어플리케이션의 홈으로 이동
						dispose();
						if(username.equals("admin")) {
							UserManager usermanager = new UserManager();
							usermanager.setVisible(true);
						} else {
							BookInfo bookinfo = new BookInfo(); // 새 프레임 생성
							bookinfo.setVisible(true); // 프레임이 보이도록 한다.
						}
					} else {// 해당 계정이 없음
						System.out.println("아이디와 비번을 다시 확인해주세요.");
					}
				} catch (SQLException elogin) {
					System.out.println("[MyMSG]SQL Exception Error : " + elogin.getMessage());
					elogin.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(230, 195, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 창 닫고
				Join join = new Join(); // 새 창 객체 생성
				join.setVisible(true); // 새 창 객체 보이도록
			}
		});
		btnJoin.setBounds(106, 195, 97, 23);
		contentPane.add(btnJoin);
	}
}
