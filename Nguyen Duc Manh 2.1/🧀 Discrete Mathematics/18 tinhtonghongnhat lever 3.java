import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TinhTongTuMotDenN extends JFrame {
    private JPanel panel;
    private JLabel thongBaoLabel;
    private JTextField nTextField;
    private JButton tinhToanButton;
    private final int CHIEU_RONG_CUA_SO = 310;
    private final int CHIEU_CAO_CUA_SO = 100;

    public TinhTongTuMotDenN() {
        setTitle("Tính tổng các số từ 1 đến n");
        setSize(CHIEU_RONG_CUA_SO, CHIEU_CAO_CUA_SO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taoPanel();
        add(panel);
        setVisible(true);
    }

    private void taoPanel() {
        thongBaoLabel = new JLabel("Nhập số n vào đây, n là số nguyên dương");
        nTextField = new JTextField(10);
        tinhToanButton = new JButton("Tính toán");
        tinhToanButton.addActionListener(new LangNgheNutTinhToan());

        // Tạo màu nền cho panel (màu hồng xám)
        panel = new JPanel();
        panel.setBackground(new Color(255, 192, 203)); // Màu hồng xám
        panel.setLayout(new FlowLayout()); // Thiết lập kiểu layout cho panel
        panel.add(thongBaoLabel);
        panel.add(nTextField);
        panel.add(tinhToanButton);
    }

    private class LangNgheNutTinhToan implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nhap = nTextField.getText();
            int n = Integer.parseInt(nhap);
            int tong = tinhTong(n);
            JOptionPane.showMessageDialog(null, "Tổng từ 1 đến " + n + " là " + tong);
        }

        private int tinhTong(int n) {
            // Sử dụng công thức tổng của dãy số học
            return (1 + n) * n / 2;
        }
    }

    public static void main(String[] args) {
        new TinhTongTuMotDenN();
    }
}
