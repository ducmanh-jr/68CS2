import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TinhTongTuMotDenN extends JFrame {
    private JPanel a1; // Panel chứa các thành phần giao diện
    private JLabel a2; // Nhãn thông báo
    private JTextField a3; // Ô nhập giá trị n
    private JButton a4; // Nút tính toán
    private final int a5 = 310; // Chiều rộng cửa sổ
    private final int a6 = 100; // Chiều cao cửa sổ

    public TinhTongTuMotDenN() {
        setTitle("Tính tổng các số từ 1 đến n");
        setSize(a5, a6);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taoPanel();
        add(a1);
        setVisible(true);
    }

    private void taoPanel() {
        a2 = new JLabel("Nhập số n vào đây, n là số nguyên dương");
        a3 = new JTextField(10);
        a4 = new JButton("Tính toán");
        a4.addActionListener(new LangNgheNutTinhToan());

        // Tạo màu nền cho panel (màu hồng xám)
        a1 = new JPanel();
        a1.setBackground(new Color(255, 192, 203)); // Màu hồng xám
        a1.setLayout(new FlowLayout()); // Thiết lập kiểu layout cho panel
        a1.add(a2);
        a1.add(a3);
        a1.add(a4);
    }

    private class LangNgheNutTinhToan implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nhap = a3.getText();
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

/**
 * import javax.swing.*;
 * Dòng này import toàn bộ các lớp trong gói javax.swing, bao gồm các lớp để tạo
 * giao diện người dùng
 * sử dụng Swing, một trong những framework phổ biến trong việc phát triển giao
 * diện Java.
 * import java.awt.*;
 * Tương tự, dòng này import toàn bộ các lớp trong gói java.awt, gồm các lớp để
 * điều khiển giao diện
 * và đồ họa trong Java.
 * import java.awt.event.*;
 * Import các lớp trong gói java.awt.event để xử lý sự kiện như khi người dùng
 * tương tác với các thành
 * phần giao diện như nút hay ô nhập liệu.
 */
/**
 * Tất nhiên! Hãy đi sâu vào từng phần của mã nguồn và giải thích cách mỗi hàm
 * hoạt động cũng như cách chúng kết hợp với nhau để tạo ra ứng dụng tính tổng
 * các số từ 1 đến n.
 * 
 * ### Phần 1: Khai báo và cấu hình cửa sổ giao diện
 * 
 * 1. **public class TinhTongTuMotDenN extends JFrame {**
 * - Định nghĩa một lớp mới với tên `TinhTongTuMotDenN`, mở rộng từ lớp
 * `JFrame`, cho phép lớp này trở thành một cửa sổ giao diện.
 * 
 * 2. **public TinhTongTuMotDenN() {**
 * - Phương thức khởi tạo của lớp `TinhTongTuMotDenN`.
 * 
 * 3. **setTitle("Tính tổng các số từ 1 đến n");**
 * - Đặt tiêu đề của cửa sổ là "Tính tổng các số từ 1 đến n".
 * 
 * 4. **setSize(a5, a6);**
 * - Đặt kích thước của cửa sổ là `a5` chiều rộng và `a6` chiều cao.
 * 
 * 5. **setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);**
 * - Đặt hành động khi người dùng đóng cửa sổ là thoát chương trình.
 * 
 * 6. **taoPanel();**
 * - Gọi phương thức `taoPanel()` để tạo giao diện và thêm nó vào cửa sổ.
 * 
 * 7. **add(a1);**
 * - Thêm panel `a1` vào cửa sổ.
 * 
 * 8. **setVisible(true);**
 * - Hiển thị cửa sổ lên màn hình.
 * 
 * ### Phần 2: Tạo panel và các thành phần giao diện
 * 
 * 1. **private void taoPanel() {**
 * - Phương thức này tạo các thành phần giao diện và thêm chúng vào panel.
 * 
 * 2. **a2 = new JLabel("Nhập số n vào đây, n là số nguyên dương");**
 * - Tạo một nhãn để hiển thị thông báo hướng dẫn.
 * 
 * 3. **a3 = new JTextField(10);**
 * - Tạo một ô nhập liệu với chiều dài ban đầu là 10 ký tự.
 * 
 * 4. **a4 = new JButton("Tính toán");**
 * - Tạo một nút với văn bản là "Tính toán".
 * 
 * 5. **a4.addActionListener(new LangNgheNutTinhToan());**
 * - Gán một trình nghe sự kiện cho nút tính toán.
 * 
 * 6. **a1 = new JPanel();**
 * - Khởi tạo panel `a1`.
 * 
 * 7. **a1.setBackground(new Color(255, 192, 203));**
 * - Đặt màu nền cho panel là màu hồng xám.
 * 
 * 8. **a1.setLayout(new FlowLayout());**
 * - Thiết lập kiểu layout cho panel là FlowLayout.
 * 
 * 9. **a1.add(a2);**
 * - Thêm nhãn `a2` vào panel.
 * 
 * 10. **a1.add(a3);**
 * - Thêm ô nhập liệu `a3` vào panel.
 * 
 * 11. **a1.add(a4);**
 * - Thêm nút `a4` vào panel.
 * 
 * ### Phần 3: Xử lý sự kiện tính tổng
 * 
 * 1. **private class LangNgheNutTinhToan implements ActionListener {**
 * - Lớp nội tạo này lắng nghe sự kiện khi nút "Tính toán" được nhấn.
 * 
 * 2. **public void actionPerformed(ActionEvent e) {**
 * - Phương thức này được gọi khi có sự kiện xảy ra trên nút "Tính toán".
 * 
 * 3. **String nhap = a3.getText();**
 * - Lấy dữ liệu nhập vào từ ô nhập liệu `a3`.
 * 
 * 4. **int n = Integer.parseInt(nhap);**
 * - Chuyển đổi dữ liệu nhập vào thành kiểu số nguyên.
 * 
 * 5. **int tong = tinhTong(n);**
 * - Gọi phương thức `tinhTong()` để tính tổng từ 1 đến n.
 * 
 * 6. **JOptionPane.showMessageDialog(null, "Tổng từ 1 đến " + n + " là " +
 * tong);**
 * - Hiển thị thông báo kết quả với tổng tính được.
 * 
 * ### Phần 4: Tính tổng các số từ 1 đến n
 * 
 * 1. **private int tinhTong(int n) {**
 * - Phương thức này tính tổng các số từ 1 đến n.
 * 
 * 2. **return (1 + n) * n / 2;**
 * - Sử dụng công thức tổng của dãy số học để tính tổng từ 1 đến n.
 * 
 * ### Phần 5: Phương thức main()
 * 
 * 1. **public static void main(String[] args) {**
 * - Phương thức `main()` để khởi chạy chương trình.
 * 
 * 2. **new TinhTongTuMotDenN();**
 * - Tạo một đối tượng mới của lớp `TinhTongTuMotDenN`, kích hoạt cửa sổ và giao
 * diện.
 */
