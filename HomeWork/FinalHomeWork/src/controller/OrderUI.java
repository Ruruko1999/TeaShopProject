package controller;

import java.awt.EventQueue;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;


import model.Member;
import model.Order;
import service.impl.OrderServiceImpl;
import util.Cal;
import util.PhotoTest;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.Timer;

import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OrderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static OrderServiceImpl osi=new OrderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUI frame = new OrderUI();
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
	public OrderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 103, 163, 56);
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("點餐系統");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(32, 10, 111, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("紅茶 20元");
		lblNewLabel_1.setBounds(102, 184, 123, 34);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("綠茶 25元");
		lblNewLabel_1_1.setBounds(102, 266, 123, 34);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("咖啡 30元");
		lblNewLabel_1_1_1.setBounds(102, 344, 123, 34);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1_1);

        // Load images
        ImageIcon coffeeIcon = new ImageIcon(PhotoTest.class.getResource("/image/coffee1.png"));
        ImageIcon teaIcon = new ImageIcon(PhotoTest.class.getResource("/image/tea1.png"));
        ImageIcon greenIcon = new ImageIcon(PhotoTest.class.getResource("/image/green1.png"));

        // Additional components setup...
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(313, 0, 123, 56);
        panel_2.setBackground(new Color(240, 240, 240));
        contentPane.add(panel_2);
        
        JLabel show = new JLabel("New label");
        show.setBounds(10, 0, 215, 49);
		show.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		contentPane.add(show);
		
		Member m=(Member)Cal.ReadObject("Member.txt");
		show.setForeground(new Color(64, 0, 0));
		show.setText(m.getName()+"\t登入中");
		
        JLabel dateTimeLabel = new JLabel("");

        panel_2.add(dateTimeLabel);

        dateTimeLabel.setBackground(new Color(255, 255, 255));

        dateTimeLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
   
        JSpinner black = new JSpinner();
        black.setBounds(250, 182, 84, 42);
        black.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        black.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(black);
        
        JSpinner green = new JSpinner();
        green.setBounds(250, 264, 84, 42);
        green.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        green.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(green);
        
        JSpinner coffee = new JSpinner();
        coffee.setBounds(250, 342, 84, 42);
        coffee.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        coffee.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(coffee);
        
        JButton btnNewButton = new JButton("確認點餐");
        btnNewButton.setBounds(264, 462, 121, 34);
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		int Black=(int) black.getValue();
        		int Green=(int) green.getValue();
        		int Coffee=(int) coffee.getValue();
        		
        		osi.addOrder(new Order(Black,Green,Coffee));
        		
        		Order o=new Order(Black,Green,Coffee);
        		try {
					FileOutputStream fos=new FileOutputStream("Order.txt");
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					oos.writeObject(o);
				} catch (Exception q) {
					// TODO Auto-generated catch block
					q.printStackTrace();
				}
        		
  
        		OrderSu  w=new OrderSu();
        		w.setVisible(true);
        		dispose();
        		
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("重新點餐");
        btnNewButton_1.setBounds(74, 462, 121, 34);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        			
        			black.setValue(0);
        			green.setValue(0);
        			coffee.setValue(0);
        	}
        });
        btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);
        
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
        btnNewButton_2.setBounds(20, 46, 85, 34);
        contentPane.add(btnNewButton_2);
        
                // Create JLabels and set images
                JLabel coffeeLabel = new JLabel(coffeeIcon);
                coffeeLabel.setBounds(10, 308, 82, 82);
                contentPane.add(coffeeLabel);
                JLabel teaLabel = new JLabel(teaIcon);
                teaLabel.setBounds(8, 168, 84, 62);
                contentPane.add(teaLabel);
                JLabel greenLabel = new JLabel(greenIcon);
                greenLabel.setBounds(15, 238, 77, 68);
                contentPane.add(greenLabel);

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
