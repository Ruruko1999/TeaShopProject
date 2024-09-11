package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Order;
import util.Cal;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class OrderSu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                OrderSu frame = new OrderSu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public OrderSu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 674);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 128));
        panel.setBounds(65, 39, 302, 104);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("訂單明細");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        lblNewLabel.setBounds(97, 32, 109, 39);
        panel.add(lblNewLabel);

        Order o = null;
        try {
            o = (Order) Cal.ReadObject("Order.txt");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception (e.g., show an error message or set default values)
        }

        JButton btnNewButton = new JButton("修改訂單");
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 23));
        btnNewButton.setBounds(158, 559, 130, 34);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderCh orderCh = new OrderCh();
                orderCh.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("離開");
        btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        btnNewButton_1.setBounds(315, 559, 99, 34);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(54, 179, 313, 363);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel show = new JLabel("New label");
        show.setBounds(0, 0, 303, 222);
        panel_1.add(show);
        show.setFont(new Font("微軟正黑體", Font.BOLD, 25));
        

        if (o != null) {
            show.setText("<html>" + "您的餐點為:" + "<br>" +
                    "紅茶:" + o.getBlack() + "杯" + "<br>" +
                    "綠茶:" + o.getGreen() + "杯" + "<br>" +
                    "咖啡:" + o.getCoffee() + "杯" + "<br>" +
                    "總金額:" + o.getSum() + "元" + "<html>");
        } else {
            show.setText("<html>" + "訂單資料無法顯示" + "<html>");
        }

        JButton btnNewButton_2 = new JButton("刪除訂單");
        btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 23));
        btnNewButton_2.setBounds(18, 559, 130, 34);
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderDe orderDe = new OrderDe();
                orderDe.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnNewButton_2);

        // Load and add the counter image
        ImageIcon counterIcon = new ImageIcon(getClass().getResource("/image/counter.png"));
        
        JLabel counter = new JLabel(counterIcon);
        counter.setBounds(140, 219, 163, 134);
        panel_1.add(counter);
    }
}
