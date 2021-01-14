package com.gring12.guibasic;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookInfo extends JFrame {

	// 클래스 변수 (전역 변수)
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTable tblBook;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPublisherID;
	private JTextField txtPrice;
	private JButton btnExit;
	private JButton btnReset;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnReload;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private int bookid4update;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfo frame = new BookInfo();
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
	public BookInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// 프레임이 뜰 때 테이블을 로드한다.
				LoadTbl();
			}
		});
		setTitle("Book Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB가 연결되어진 상태라면, 연결을 종료
				if(DBUtil.dbconn != null) DBUtil.DBClose();
				dispose(); // 윈도우 창을 닫는 메서드
				System.exit(0); // 전체 프로그램을 정상적으로 종료
			}
		});
		btnExit.setBounds(497, 436, 85, 25);
		contentPane.add(btnExit);
		
		lblNewLabel = new JLabel("도서정보관리시스템");
		lblNewLabel.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel.setBounds(185, 21, 225, 33);
		contentPane.add(lblNewLabel);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(12, 436, 85, 25);
		contentPane.add(btnReset);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(109, 436, 85, 25);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update 버튼을 클릭했을 때
				String sql = "UPDATE tblbook SET title=?, author=?, publisherID =?, price=? WHERE bookid=?";
				String title = txtTitle.getText();
				String author = txtAuthor.getText();
				String publisherID = txtPublisherID.getText();
				String price = txtPrice.getText();
				
				try {
					PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
					pstmt.setString(1, title);
					pstmt.setString(2, author);
					pstmt.setInt(3, Integer.parseInt(publisherID));
					pstmt.setInt(4, Integer.parseInt(price));
					pstmt.setInt(5, bookid4update);
					
					pstmt.execute();
					LoadTbl();
				} catch(SQLException eupdate){
					JOptionPane.showMessageDialog(null, "해당 레코드 업데이트 오류");
					eupdate.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(206, 436, 85, 25);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(303, 436, 85, 25);
		contentPane.add(btnDelete);
		
		btnReload = new JButton("Reload");
		btnReload.setBounds(400, 436, 85, 25);
		contentPane.add(btnReload);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 85, 282, 326);
		contentPane.add(scrollPane);
		
		tblBook = new JTable();
		tblBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블의 특정 행을 마우스로 클릭했을 때
				int row = tblBook.getSelectedRow(); //선택한 행을 불러오기
				bookid4update = Integer.parseInt(tblBook.getModel().getValueAt(row, 0).toString()); // string으로 나오는 결과값을 int로 변환 Integer.parseInt();
				// reset 버튼과 save 버튼, reload 버튼을 disable하게 한다.
				btnReset.setEnabled(false);
				btnSave.setEnabled(false);
				btnReload.setEnabled(false);
				// 해당 레코드의 id를 이용하여 필드값을 채우는 메서드를 호출
				setTxtField(bookid4update);
			}
		});
		tblBook.setModel(new DefaultTableModel(
			
		));
		scrollPane.setViewportView(tblBook);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 85, 276, 326);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("도서명");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(22, 57, 57, 15);
		panel.add(lblNewLabel_1);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(78, 54, 172, 21);
		panel.add(txtTitle);
		
		JLabel lblNewLabel_1_1 = new JLabel("저  자");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(22, 119, 57, 15);
		panel.add(lblNewLabel_1_1);
		
		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(78, 116, 172, 21);
		panel.add(txtAuthor);
		
		JLabel lblNewLabel_1_2 = new JLabel("출판사");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(22, 181, 57, 15);
		panel.add(lblNewLabel_1_2);
		
		txtPublisherID = new JTextField();
		txtPublisherID.setColumns(10);
		txtPublisherID.setBounds(78, 178, 172, 21);
		panel.add(txtPublisherID);
		
		JLabel lblNewLabel_1_3 = new JLabel("정  가");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setBounds(22, 243, 57, 15);
		panel.add(lblNewLabel_1_3);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(78, 240, 172, 21);
		panel.add(txtPrice);
	}// end of BookInfo()
	
	private void LoadTbl() {
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("도서명");
		model.addColumn("저  자");
		model.addColumn("출판사");
		model.addColumn("정  가");
		
		//데이터베이스 연결이 안되어 있으면 연결
		if(DBUtil.dbconn == null) DBUtil.DBConnect();
		String sql = "SELECT * FROM tblbook";
		
		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getInt(1),    // bookid
						rs.getString(2), // title
						rs.getString(3), // author
						rs.getString(4), // publisher
						rs.getInt(5)     // price
				});
			}//end of while
			rs.close();
			pstmt.close();
			
			tblBook.setModel(model);
			tblBook.setAutoResizeMode(0);
			tblBook.getColumnModel().getColumn(0).setPreferredWidth(30); //bookid
			tblBook.getColumnModel().getColumn(1).setPreferredWidth(150);//title
			tblBook.getColumnModel().getColumn(2).setPreferredWidth(80); //author
			tblBook.getColumnModel().getColumn(3).setPreferredWidth(50); //publisher
			tblBook.getColumnModel().getColumn(4).setPreferredWidth(50); //price
			
			JOptionPane.showMessageDialog(null, "테이블을 로딩하였습니다.");
			
		}catch(SQLException eload) {
			JOptionPane.showMessageDialog(null, "테이블 로딩 오류");
			eload.printStackTrace();
		}
		
		
	}// end of LoadTbl()
	
	private void setTxtField(int id) {
		String sql= "SELECT * FROM tblBook WHERE bookid=?";
		
		try {
			PreparedStatement pstmt = DBUtil.dbconn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					txtTitle.setText(rs.getString(2));    // title
					txtAuthor.setText(rs.getString(3)); // author
					txtPublisherID.setText(String.valueOf(rs.getInt(4))); // publisher,  int로 불러온 값을 String 타입으로 변환해서 불러오기
					txtPrice.setText(String.valueOf(rs.getInt(5)));     // price
		}//end of while
			
		} catch (SQLException eset) {
			JOptionPane.showMessageDialog(null, "해당 레코드 조회 오류");
			eset.printStackTrace();
		}
	}
	
}// end of class
