
import java.time.LocalDate;

public class nhanvien {// nhanvien = ProductionWorker
    private String aa1; // aa1 = tennhanvien
    private String bb1; // bb1 = masosinhvien
    private LocalDate cc1; // cc1 = ngaythue
    private int dd1; // dd1 = shift
    private double ee1; // ee1 = luong theo gio

    public nhanvien(String aa1, String bb1, LocalDate cc1, int dd1, double ee1) {
        this.aa1 = aa1;
        this.bb1 = bb1;
        this.cc1 = cc1;
        this.dd1 = dd1;
        this.ee1 = ee1;
    }

    public String getAa1() {
        return aa1;
    }

    public void setAa1(String aa1) {
        this.aa1 = aa1;
    }

    public String getBb1() {
        return bb1;
    }

    public void setBb1(String bb1) {
        this.bb1 = bb1;
    }

    public LocalDate getCc1() {
        return cc1;
    }

    public void setCc1(LocalDate cc1) {
        this.cc1 = cc1;
    }

    public int getDd1() {
        return dd1;
    }

    public void setDd1(int dd1) {
        this.dd1 = dd1;
    }

    public double getEe1() {
        return ee1;
    }

    public void setEe1(double ee1) {
        this.ee1 = ee1;
    }

    public static void main(String[] args) {
        LocalDate ngayThue = LocalDate.of(2027, 9, 4);
        nhanvien worker = new nhanvien("Nguyen Duc Manh", "999-M", ngayThue, 1, 1000);
        System.out.println("Ten nhan vien: " + worker.getAa1());
        System.out.println("Ma so nhan vien: " + worker.getBb1());
        System.out.println("Ngay thue: " + worker.getCc1());
        System.out.println("lam ca: " + worker.getDd1());// shift = lam ca
        System.out.println("Luong theo gio: " + worker.getEe1() + "USD");
    }
}

/**
 * 1. Lớp nhân viên và công nhân sản xuất
 * Thiết kế một lớp có tên là Nhân viên. Lớp học nên giữ các thông tin sau trong
 * các trường:
 * • Tên nhân viên
 * • Mã số nhân viên ở định dạng XXX–L, trong đó mỗi X là một chữ số trong phạm
 * vi 0–9
 * và L là một chữ cái trong phạm vi A–M.
 * • Ngày thuê
 * Viết một hoặc nhiều hàm tạo và các phương thức truy cập và biến đổi thích hợp
 * cho lớp.
 * Tiếp theo, viết một lớp có tên ProductionWorker để mở rộng lớp Nhân viên. Các
 * Lớp ProductionWorker phải có các trường để chứa thông tin sau:
 * • Shift (số nguyên)
 * • Mức lương hàng giờ (gấp đôi)
 * Ngày làm việc được chia thành hai ca: ngày và đêm. Trường shift sẽ là một giá
 * trị nguyên
 * thể hiện ca làm việc của nhân viên. Ca ngày là ca 1 và ca đêm là ca
 * shift 2. Viết một hoặc nhiều hàm tạo và các phương thức truy cập và biến đổi
 * thích hợp cho
 * lớp. Trình diễn các lớp bằng cách viết một chương trình sử dụng đối tượng
 * ProductionWorker.
 */