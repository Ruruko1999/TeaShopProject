package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Order;
import service.impl.OrderServiceImpl;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class BackendUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField orderno;
    private static OrderServiceImpl osi = new OrderServiceImpl();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BackendUI frame = new BackendUI();
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
    public BackendUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 767, 589);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("訂單管理系統");
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
        lblNewLabel.setBounds(301, 37, 191, 41);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(31, 151, 356, 341);
        contentPane.add(scrollPane);

        JTextArea output = new JTextArea();
        scrollPane.setViewportView(output);

        JButton btnNewButton = new JButton("查詢");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Order> l = osi.findAll();
                StringBuilder show = new StringBuilder();
                for (Order o : l) {
                    show.append("id:").append(o.getOrderno())
                        .append("\t紅茶:").append(o.getBlack()).append("杯")
                        .append("\t綠茶:").append(o.getGreen()).append("杯")
                        .append("\t咖啡:").append(o.getCoffee()).append("杯")
                        .append("\t總金額:").append(o.getSum()).append("元").append("\n");
                }
                output.setText(show.toString());
            }
        });
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        btnNewButton.setBounds(151, 502, 98, 40);
        contentPane.add(btnNewButton);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        panel.setBounds(139, 87, 127, 54);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("訂單查詢");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(23, 10, 80, 28);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.GRAY);
        panel_1.setBounds(521, 159, 127, 54);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1_1 = new JLabel("訂單刪除");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(23, 10, 80, 28);
        panel_1.add(lblNewLabel_1_1);

        orderno = new JTextField();
        orderno.setBounds(480, 263, 207, 41);
        contentPane.add(orderno);
        orderno.setColumns(10);

        JButton btnNewButton_1 = new JButton("刪除");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int Orderno = Integer.parseInt(orderno.getText());
                    osi.deleteOrder(Orderno);
                    JOptionPane.showMessageDialog(BackendUI.this, "刪除訂單成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BackendUI.this, "請輸入有效的訂單編號", "錯誤", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btnNewButton_1.setBounds(601, 344, 100, 41);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("重新輸入");
        btnNewButton_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                orderno.setText(null);
            }
        });
        btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btnNewButton_1_1.setBounds(463, 344, 100, 41);
        contentPane.add(btnNewButton_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(630, 10, 123, 56);
        panel_2.setBackground(new Color(240, 240, 240));
        contentPane.add(panel_2);

        JLabel dateTimeLabel = new JLabel("");
        dateTimeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel_2.add(dateTimeLabel);
        
        JButton btnNewButton_1_1_1 = new JButton("訂單修改");
        btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		BackCh b=new BackCh();
        		b.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btnNewButton_1_1_1.setBounds(521, 418, 142, 41);
        contentPane.add(btnNewButton_1_1_1);
        
        JButton btnNewButton_1_2 = new JButton("登出");
        btnNewButton_1_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		LoginUI loginUI = new LoginUI();
                loginUI.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        btnNewButton_1_2.setBounds(521, 21, 100, 41);
        contentPane.add(btnNewButton_1_2);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        // 每秒更新一次日期和時間
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                String dateString = dateFormat.format(now);
                String timeString = timeFormat.format(now);
                dateTimeLabel.setText("<html>" + dateString + "<br>" + timeString + "</html>");
            }
        });
        timer.start();

        contentPane.setVisible(true);
    }
}
