package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import util.Cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSu frame = new LoginSu();
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
	public LoginSu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(59, 10, 320, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setBounds(107, 39, 99, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		
		JLabel show = new JLabel("New label");
		show.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		show.setBounds(106, 83, 229, 53);
		panel.add(show);
		
		
		Member m=(Member)Cal.ReadObject("Member.txt");
		show.setForeground(new Color(255, 255, 255));
		show.setText(m.getName()+"\t歡迎你~");
		
		JButton btnNewButton = new JButton("開始點餐");
		btnNewButton.setBounds(163, 196, 113, 42);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderUI o=new OrderUI();
				o.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 19));
		contentPane.add(btnNewButton);
		
	}
}
