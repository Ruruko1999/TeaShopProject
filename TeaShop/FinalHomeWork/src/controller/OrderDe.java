package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.OrderServiceImpl;
import util.Cal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class OrderDe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField orderno;
	private static OrderServiceImpl osi=new OrderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDe frame = new OrderDe();
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
	public OrderDe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(143, 93, 156, 79);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("訂單刪除");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(30, 23, 105, 33);
		panel.add(lblNewLabel);
		
		 JLabel show = new JLabel("New label");
		 show.setBounds(3, 1, 186, 56);
			show.setFont(new Font("微軟正黑體", Font.BOLD, 20));
			contentPane.add(show);
			
			Member m=(Member)Cal.ReadObject("Member.txt");
			show.setForeground(new Color(64, 0, 0));
			show.setText(m.getName()+"\t登入中");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBounds(319, 0, 123, 56);
		contentPane.add(panel_2);
		
		JLabel dateTimeLabel = new JLabel("");
		dateTimeLabel.setFont(new Font("Serif", Font.BOLD, 16));
		dateTimeLabel.setBackground(Color.WHITE);
		panel_2.add(dateTimeLabel);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginUI i=new LoginUI();
        		i.setVisible(true);
        		dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_2.setBounds(13, 48, 85, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("訂單編號");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(69, 251, 123, 34);
		contentPane.add(lblNewLabel_1_2);
		
		orderno = new JTextField();
		orderno.setColumns(10);
		orderno.setBounds(246, 251, 108, 34);
		contentPane.add(orderno);
		
		JButton btnNewButton_1_1_1 = new JButton("刪除訂單");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				try {
                    int Orderno = Integer.parseInt(orderno.getText());
                    osi.deleteOrder(Orderno);
                    JOptionPane.showMessageDialog(OrderDe.this, "刪除訂單成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(OrderDe.this, "請輸入有效的訂單編號", "錯誤", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1_1_1.setBounds(248, 369, 121, 34);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1 = new JButton("重新輸入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderno.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBounds(69, 369, 121, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("回上一頁");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderSu o=new OrderSu();
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(161, 451, 121, 34);
		contentPane.add(btnNewButton_1_2);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");



        // 每秒更新一次日期和時間

        Timer timer = new Timer(1000, new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                // 目前時間

                Date now = new Date();

                // 時間的格式

                String dateString = dateFormat.format(now);

                String timeString = timeFormat.format(now);

                // 更新 JLabel

                dateTimeLabel.setText("<html>" + dateString + "<br>" + timeString + "</html>");

            }

        });
        
        timer.start();
        
        contentPane.setVisible(true);
        

	}
	

}
