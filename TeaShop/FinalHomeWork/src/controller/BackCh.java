package controller;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.Order;
import service.impl.OrderServiceImpl;
import util.PhotoTest;

public class BackCh extends JFrame {

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
                    BackCh frame = new BackCh();
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
    public BackCh() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 843, 633);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(133, 37, 156, 79);
        panel.setBackground(new Color(128, 128, 128));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("訂單修改");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        lblNewLabel.setBounds(30, 23, 105, 33);
        panel.add(lblNewLabel);

        JLabel lblBlackTea = new JLabel("紅茶 20元");
        lblBlackTea.setBounds(108, 229, 123, 34);
        lblBlackTea.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        contentPane.add(lblBlackTea);

        JLabel lblGreenTea = new JLabel("綠茶 25元");
        lblGreenTea.setBounds(108, 305, 123, 34);
        lblGreenTea.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        contentPane.add(lblGreenTea);

        JLabel lblCoffee = new JLabel("咖啡 30元");
        lblCoffee.setBounds(108, 381, 123, 34);
        lblCoffee.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        contentPane.add(lblCoffee);

        // Load images
        ImageIcon coffeeIcon = new ImageIcon(PhotoTest.class.getResource("/image/coffee1.png"));
        ImageIcon teaIcon = new ImageIcon(PhotoTest.class.getResource("/image/tea1.png"));
        ImageIcon greenIcon = new ImageIcon(PhotoTest.class.getResource("/image/green1.png"));

        JLabel coffeeLabel = new JLabel(coffeeIcon);
        coffeeLabel.setBounds(18, 362, 80, 89);
        contentPane.add(coffeeLabel);

        JLabel teaLabel = new JLabel(teaIcon);
        teaLabel.setBounds(13, 201, 85, 68);
        contentPane.add(teaLabel);

        JLabel greenLabel = new JLabel(greenIcon);
        greenLabel.setBounds(18, 279, 80, 68);
        contentPane.add(greenLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(696, 10, 123, 56);
        panel_2.setBackground(new Color(240, 240, 240));
        contentPane.add(panel_2);

        JLabel dateTimeLabel = new JLabel("");
        dateTimeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel_2.add(dateTimeLabel);

        JSpinner black = new JSpinner();
        black.setBounds(278, 227, 84, 42);
        black.setModel(new SpinnerNumberModel(0, 0, null, 1));
        black.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(black);

        JSpinner green = new JSpinner();
        green.setBounds(278, 305, 84, 42);
        green.setModel(new SpinnerNumberModel(0, 0, null, 1));
        green.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(green);

        JSpinner coffee = new JSpinner();
        coffee.setBounds(278, 381, 84, 42);
        coffee.setModel(new SpinnerNumberModel(0, 0, null, 1));
        coffee.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        contentPane.add(coffee);

        JLabel lblOrderNo = new JLabel("訂單編號");
        lblOrderNo.setBounds(108, 150, 123, 34);
        lblOrderNo.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        contentPane.add(lblOrderNo);

        orderno = new JTextField();
        orderno.setBounds(280, 150, 108, 34);
        contentPane.add(orderno);
        orderno.setColumns(10);

        JButton btnReset = new JButton("重新輸入");
        btnReset.setBounds(68, 461, 121, 34);
        btnReset.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderno.setText(null);
                black.setValue(0);
                green.setValue(0);
                coffee.setValue(0);
            }
        });
        contentPane.add(btnReset);

        JButton btnConfirm = new JButton("確認修改");
        btnConfirm.setBounds(251, 461, 121, 34);
        btnConfirm.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int orderNo = Integer.parseInt(orderno.getText());
                    int blackCount = (int) black.getValue();
                    int greenCount = (int) green.getValue();
                    int coffeeCount = (int) coffee.getValue();
                    osi.updateOrder(orderNo, blackCount, greenCount, coffeeCount);
                    JOptionPane.showMessageDialog(BackCh.this, "修改訂單成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BackCh.this, "請輸入有效的訂單編號", "錯誤", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnConfirm);

        JButton btnBack = new JButton("回上一頁");
        btnBack.setBounds(159, 519, 121, 34);
        btnBack.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackendUI o = new BackendUI();
                o.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBack);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(435, 129, 302, 342);
        contentPane.add(scrollPane);

        JTextArea output = new JTextArea();
        scrollPane.setViewportView(output);

        JButton btnQuery = new JButton("查詢");
        btnQuery.setBounds(541, 501, 98, 40);
        btnQuery.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        btnQuery.addActionListener(new ActionListener() {
            @Override
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
        contentPane.add(btnQuery);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(521, 80, 127, 54);
        panel_1.setLayout(null);
        panel_1.setBackground(Color.GRAY);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("訂單查詢");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1.setBounds(23, 10, 80, 28);
        panel_1.add(lblNewLabel_1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

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
