package com.gring12.guibasic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuthorInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtAuthorName;
	private JTextField txtAuthorAddr;
	private JTextField txtAuthorPhone;
	private JTable table;
	private JTable tblAuthor;
	private JTable tblAuthor_1;
	private JTextField txtEmployee;
	private JTextField txtEmployeeName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorInfo frame = new AuthorInfo();
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
	public AuthorInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				LoadTbl();
			}
		});
		
		setTitle("Author Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("작가 정보 관리 시스템");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 10, 255, 56);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 86, 217, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(5, 46, 60, 20);
		panel.add(lblNewLabel_1);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(77, 46, 120, 20);
		panel.add(txtAuthorName);
		
		JLabel lblNewLabel_2 = new JLabel("주소");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(5, 88, 60, 20);
		panel.add(lblNewLabel_2);
		
		txtAuthorAddr = new JTextField();
		txtAuthorAddr.setColumns(10);
		txtAuthorAddr.setBounds(77, 88, 120, 20);
		panel.add(txtAuthorAddr);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(5, 130, 60, 20);
		panel.add(lblNewLabel_3);
		
		txtAuthorPhone = new JTextField();
		txtAuthorPhone.setColumns(10);
		txtAuthorPhone.setBounds(77, 130, 120, 20);
		panel.add(txtAuthorPhone);
		
		JLabel lblNewLabel_4 = new JLabel("담당자");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(5, 172, 60, 20);
		panel.add(lblNewLabel_4);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setBounds(77, 172, 120, 20);
		panel.add(txtEmployeeName);
		txtEmployeeName.setColumns(10);
		txtEmployeeName.setColumns(10);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE tblauthor SET name=?, address=?, phone=? WHERE authorid=?";
				String name = txtAuthorName.getText();
				String address = txtAuthorAddr.getText();
				String phone = txtAuthorPhone.getText();
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, address);
					pstmt.setString(3, phone);
					
					pstmt.execute();
					
				}catch (SQLException eupdate){
					eupdate.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(157, 383, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO tblauthor(name, address, phone) VALUES (?,?,?)";
				String name = txtAuthorName.getText();
				String address = txtAuthorAddr.getText();
				String phone = txtAuthorPhone.getText();
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, address);
					pstmt.setString(3, phone);
					
					pstmt.execute();
				} catch (SQLException esave) {
					esave.printStackTrace();
				}
			}
		});
		btnSave.setBounds(411, 382, 95, 25);
		contentPane.add(btnSave);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAuthorName.setText("");
				txtAuthorAddr.setText("");
				txtAuthorPhone.setText("");
			}
		});
		btnNew.setBounds(31, 382, 95, 25);
		contentPane.add(btnNew);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setBounds(285, 382, 95, 25);
		contentPane.add(btnReload);
		
		tblAuthor = new JTable();
		tblAuthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblAuthor.getSelectedRow();
				authorupdate = Integer.parseInt(tblAuthor.getModel().getValueAt(row,0).toString());
				
				setTxtField(authorupdate);
			}
		});
		
		tblAuthor.setBounds(241, 86, 286, 264);
		contentPane.add(tblAuthor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		contentPane.add(scrollPane);
		
	}//AuthorInfo() end
		
		
		private void LoadTbl() {
			model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("이름");
			model.addColumn("주소");
			model.addColumn("전화번호");
			model.addColumn("담당자");
		
			if(DBUtil.dbconn == null) DBUtil.DBConnect();
			String sql = "SELECT a.name, a.address, a.phone, e.name FROM tblauthor as a INNER JOIN tblemployee as e ON a.employeeid = e.employeeid";
			
			try {
				PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString(1),    // authorname
							rs.getString(2), // authoraddr
							rs.getString(3), // authorphone
							rs.getString(4), // employeename
					});
				}//end of while
				rs.close();
				pstmt.close();
				
				tblAuthor.setModel(model);
				tblAuthor.setAutoResizeMode(0);
				tblAuthor.getColumnModel().getColumn(0).setPreferredWidth(80); //a.name
				tblAuthor.getColumnModel().getColumn(1).setPreferredWidth(100);//a.addr
				tblAuthor.getColumnModel().getColumn(2).setPreferredWidth(100); //a.phone
				tblAuthor.getColumnModel().getColumn(3).setPreferredWidth(80); //e.name
				
				}catch(SQLException eload) {
					eload.printStackTrace();
				}
			
		}// end of LoadTbl()
			private void setTxtField(int id) {
				String sql = "SELECT a.authorid, a.name, a.address, a.phone, e.name FROM tblauthor as a INNER JOIN tblemployee as e ON a.employeeid = e.employeeid WHERE authorid = ?";
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setInt(1,id);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						txtAuthorName.setText(rs.getString(2));
						txtAuthorAddr.setText(rs.getString(3));
						txtAuthorPhone.setText(rs.getString(4));
						txtEmployeeName.setText(rs.getString(5));
					}
				} catch (SQLException eset) {
					eset.printStackTrace();
				}
			}

}// end of class
