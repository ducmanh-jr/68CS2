
public class SS {// ShiftSupervisor = giam sat vien thay doi SS
    private String a1;// a1 = ten
    private String a2;// a2 = maNhanVien
    private double a3;// a3 = luongHangNam
    private double a4;// a4 = tienThuongSanXuatHangNam

    public SS(String a1, String a2, double a3, double a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public String aa1() {// laya1
        return a1;
    }

    public String aa2() {
        return a2;
    }

    public double aa3() {
        return a3;
    }

    public double aa4() {
        return a4;
    }

    public static void main(String[] args) {
        SSSS ss = new SSSS("Nguyen Duc Manh", "00000", 100000.0, 20000.0);

        System.out.println("Ten: " + ss.aa1());
        System.out.println("Ma nhan vien: " + ss.aa2());
        System.out.println("Luong hang nam: " + ss.aa3() + " $");
        System.out.println("Tien thuong san xuat hang nam: $" + ss.aa4() + " $");
    }
}

/**
 * 2. Lớp ShiftSupervisor
 * Trong một nhà máy cụ thể, người giám sát ca là một nhân viên được trả lương
 * giám sát ca làm việc. Ngoài tiền lương, người giám sát ca còn được thưởng
 * hàng năm khi ca của họ đáp ứng được mục tiêu sản xuất. Thiết kế lớp
 * ShiftSupervisor mở rộng lớp Nhân viên mà bạn đã tạo trong
 * Thử thách lập trình 1. Lớp ShiftSupervisor phải có một trường chứa
 * lương hàng năm và lĩnh vực có tiền thưởng sản xuất hàng năm mà giám sát ca có
 * kiếm được. Viết một hoặc nhiều hàm tạo và các phương thức truy cập và biến
 * đổi thích hợp
 */