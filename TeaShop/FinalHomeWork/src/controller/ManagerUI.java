package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JTextField password;

    /**
     * Create the frame.
     */
    public ManagerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 486, 417);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("帳號");
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        lblNewLabel.setBounds(102, 137, 68, 47);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("密碼");
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        lblNewLabel_1.setBounds(102, 235, 68, 47);
        contentPane.add(lblNewLabel_1);
        
        user = new JTextField();
        user.setBounds(265, 149, 141, 38);
        contentPane.add(user);
        user.setColumns(10);
        
        password = new JTextField();
        password.setColumns(10);
        password.setBounds(265, 244, 141, 38);
        contentPane.add(password);
        
        JButton btnNewButton = new JButton("登入");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String User = user.getText();
                String Password = password.getText();
                
                if(User.equals("user1") && Password.equals("1234")) {
                    BackendUI b = new BackendUI();
                    b.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(ManagerUI.this, "帳號或密碼錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 19));
        btnNewButton.setBounds(171, 314, 132, 47);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("管理員登入");
        lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        lblNewLabel_2.setBounds(152, 50, 166, 31);
        contentPane.add(lblNewLabel_2);
        
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
        btnNewButton_1.setBounds(346, 47, 104, 34);
        contentPane.add(btnNewButton_1);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerUI frame = new ManagerUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
