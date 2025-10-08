import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TinhTong extends JFrame {
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField nTextField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 100;

    public TinhTong() {
        setTitle("Tính tổng các số từ 1 đến n");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);
    }

    private void buildPanel() {
        messageLabel = new JLabel("Nhập số n vào đây, n là số nguyên dương");
        nTextField = new JTextField(10);
        calcButton = new JButton("Tính toán");
        calcButton.addActionListener(new CalcButtonListener());

        // Tạo màu nền cho panel
        panel = new JPanel();
        panel.setBackground(Color.lightGray); // Màu nền xám nhạt
        panel.setLayout(new FlowLayout()); // Thiết lập kiểu layout cho panel
        panel.add(messageLabel);
        panel.add(nTextField);
        panel.add(calcButton);
    }

    private class CalcButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = nTextField.getText();
            int n = Integer.parseInt(input);
            int sum = tinhTong(n);
            JOptionPane.showMessageDialog(null, "Tổng từ 1 đến " + n + " là " + sum);
        }

        private int tinhTong(int n) {
            // Sử dụng công thức tổng của dãy số học
            return (1 + n) * n / 2;
        }
    }

    public static void main(String[] args) {
        new TinhTong();
    }
}
