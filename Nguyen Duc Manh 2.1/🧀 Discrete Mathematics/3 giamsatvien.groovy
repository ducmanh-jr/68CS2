



public class ShiftSupervisor {//giam sat vien thay doi
    private String a1;// a1 = ten
    private String b1;// b1 = maNhanVien
    private double c1;// c1 = luongHangNam
    private double d1;// d1 = tienThuongSanXuatHangNam

    public ShiftSupervisor(String a1, String b1, double c1, double d1) {
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.d1 = d1;
    }

    public String laya1() {
        return a1;
    }
    public String layb1() {
        return b1;
    }
    public double layc1() {
        return c1;
    }
    public void datc1(double c1) {
        this.c1 = c1;
    }
    public double layd1() {
        return d1;
    }
    public void datd1(double d1) {
        this.d1 = d1;
    }

    public static void main(String[] args) {
        ShiftSupervisor supervisor = new ShiftSupervisor("Nguyen Duc Manh", "00000", 100000.0, 20000.0);

        System.out.println("Ten: " + supervisor.laya1());
        System.out.println("Ma nhan vien: " + supervisor.layb1());
        System.out.println("Luong hang nam: " + supervisor.layc1() + " $");
        System.out.println("Tien thuong san xuat hang nam: $" + supervisor.layd1() + " $");
    }
}


/** 2. Lớp ShiftSupervisor
Trong một nhà máy cụ thể, người giám sát ca là một nhân viên được trả lương giám sát ca làm việc. Ngoài tiền lương, người giám sát ca còn được thưởng hàng năm khi ca của họ đáp ứng được mục tiêu sản xuất. Thiết kế lớp ShiftSupervisor mở rộng lớp Nhân viên mà bạn đã tạo trong
Thử thách lập trình 1. Lớp ShiftSupervisor phải có một trường chứa
lương hàng năm và lĩnh vực có tiền thưởng sản xuất hàng năm mà giám sát ca có
kiếm được. Viết một hoặc nhiều hàm tạo và các phương thức truy cập và biến đổi thích hợp */