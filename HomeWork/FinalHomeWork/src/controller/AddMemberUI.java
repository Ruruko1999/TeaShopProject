package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private static MemberServiceImpl msi=new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("加入會員");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(202, 43, 134, 59);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setBounds(124, 138, 94, 34);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setBounds(124, 211, 94, 34);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setBounds(124, 291, 94, 34);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setBounds(124, 371, 94, 34);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("連絡電話:");
		lblNewLabel_1_4.setBounds(124, 444, 134, 34);
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(307, 138, 128, 35);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(307, 210, 128, 35);
		username.setColumns(10);
		contentPane.add(username);
		
		password = new JTextField();
		password.setBounds(307, 290, 128, 35);
		password.setColumns(10);
		contentPane.add(password);
		
		address = new JTextField();
		address.setBounds(307, 371, 128, 35);
		address.setColumns(10);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setBounds(307, 444, 128, 35);
		phone.setColumns(10);
		contentPane.add(phone);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(223, 535, 113, 46);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String UserName=username.getText();
				if(msi.findByUsername(UserName))
				{
					AddEr a=new AddEr();
					a.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					
					Member m=new Member(Name,UserName,Password,Address,Phone);
					msi.addMember(m);
					
					AddSu a=new AddSu();
					a.setVisible(true);
					dispose();
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(112, 28, 309, 85);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(443, 60, 104, 34);
		contentPane.add(btnNewButton_1);
	}
}
