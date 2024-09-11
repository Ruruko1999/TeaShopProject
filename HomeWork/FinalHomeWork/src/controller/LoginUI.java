package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private static MemberServiceImpl msi=new MemberServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(105, 72, 46, 29);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(105, 133, 46, 18);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(207, 80, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(207, 133, 96, 21);
		password.setColumns(10);
		contentPane.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("會員登入");
		lblNewLabel_2.setBounds(174, 10, 87, 36);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 21));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("加入會員");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI a=new AddMemberUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(80, 199, 120, 36);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 19));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				Member m=msi.Login(Username, Password);
				
				if(m!=null)
				{
					Cal.SaveObject(m, "Member.txt");
					LoginSu l=new LoginSu();
					l.setVisible(true);
					dispose();
				}
				else
				{
					LoginEr l=new LoginEr();
					l.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_1.setBounds(263, 199, 101, 36);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 19));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("管理員登入");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerUI m=new ManagerUI();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(325, 10, 101, 36);
		contentPane.add(btnNewButton_1_1);
	}
}
