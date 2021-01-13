package com.gring12.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPWD;
	private JPasswordField txtConfirm;
	private JTextField txtAddr;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	// UI에서 입력된 값을 취하기 위한 임시 변수
	private String username;
	private String userpwd;
	private String confirm;
	private String gender;
	private String addr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (DBUtil.dbconn == null)
						DBUtil.DBConnect();
					
					Join frame = new Join();
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
	public Join() {
		setTitle("Join Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Join as New Member");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(69, 22, 246, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(68, 89, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(69, 137, 70, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm");
		lblNewLabel_1_2.setBounds(69, 186, 70, 15);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setBounds(69, 229, 70, 15);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setBounds(69, 273, 70, 15);
		contentPane.add(lblNewLabel_1_4);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "M";
			}
		});
		buttonGroup.add(rdoMale);
		rdoMale.setBounds(166, 225, 64, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "F";
			}
		});
		buttonGroup.add(rdoFemale);
		rdoFemale.setBounds(246, 225, 83, 23);
		contentPane.add(rdoFemale);
		
		txtUserName = new JTextField();
		txtUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(txtUserName);
			}
		});
		txtUserName.setBounds(165, 86, 150, 21);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPWD = new JPasswordField();
		txtPWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(txtPWD);
			}
		});
		txtPWD.setBounds(165, 134, 150, 21);
		contentPane.add(txtPWD);
		
		txtConfirm = new JPasswordField();
		txtConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(txtConfirm);
			}
		});
		txtConfirm.setBounds(166, 183, 150, 21);
		contentPane.add(txtConfirm);
		
		txtAddr = new JTextField();
		txtAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			add(txtAddr);
			}
		});
		txtAddr.setBounds(166, 270, 150, 21);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// UI의 입력 요소들을 Reset
				txtUserName.setText("");
				txtPWD.setText("");
				txtConfirm.setText("");
//				rdoMale.setSeleted(false);				
//				rdoFemale.setSeleted(false);				
				buttonGroup.clearSelection();
				txtAddr.setText("");
			}
		});
		btnReset.setBounds(69, 336, 97, 23);
		contentPane.add(btnReset);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 입력된 데이터값을 DB에 저장
				if (DBUtil.dbconn == null)
					DBUtil.DBConnect();
				
				String username = txtUserName.getText();
				String userpwd = new String(txtPWD.getPassword());
				String addr = txtAddr.getText();
				
				String sql = "SELECT * FROM tbluser WHERE username=? AND userpwd=? AND gender=? AND addr=?";
			}
		});
		btnSave.setBounds(200, 336, 97, 23);
		contentPane.add(btnSave);
	}
}
