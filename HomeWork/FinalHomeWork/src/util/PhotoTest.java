package util;
import javax.swing.*;
import java.awt.*;

public class PhotoTest {
    public static void main(String[] args) {
        // 創建 JFrame 實例
        JFrame frame = new JFrame("Image in JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // 設置窗口大小
        frame.setLayout(new BorderLayout());

        // 載入圖片，這里使用相對路徑
        ImageIcon imageIcon = new ImageIcon("src/image/coffee.png"); // 根據實際圖片位置修改路徑
        JLabel imageLabel = new JLabel(imageIcon);

        // 將 JLabel 添加到 JFrame
        frame.add(imageLabel, BorderLayout.CENTER);

        // 設置窗口可見
        frame.setVisible(true);
    }
}
