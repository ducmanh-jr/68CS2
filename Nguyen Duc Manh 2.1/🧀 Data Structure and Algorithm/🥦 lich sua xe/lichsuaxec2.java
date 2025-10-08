import java.util.*;

public class lichsuaxec2 {
    static class Xe {
        int soNgaySua; // so ngay sua
        int mucPhat; // muc phat tren 1 ngay
        int id; // so thu tu xe
        int tienPhat; // tien phat cho xe

        Xe(int id, int soNgaySua, int mucPhat) {
            this.id = id;
            this.soNgaySua = soNgaySua;
            this.mucPhat = mucPhat;
            this.tienPhat = 0; // Khoi tao tien phat
        }

        void tinhTienPhat(int thoiGianConLai) {
            this.tienPhat = this.mucPhat * thoiGianConLai;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Doc so luong xe
        System.out.print("Nhap so luong xe: ");
        int n = scanner.nextInt();
        Xe[] xe = new Xe[n];

        // Doc so ngay sua va muc phat
        System.out.println("Nhap so ngay sua va muc phat (so ngay sua, muc phat):");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap so ngay sua cho xe thu " + (i + 1) + ": ");
            int soNgaySua = scanner.nextInt();
            System.out.print("Nhap muc phat cho xe thu " + (i + 1) + ": ");
            int mucPhat = scanner.nextInt();
            xe[i] = new Xe(i + 1, soNgaySua, mucPhat); // Luu so thu tu xe
        }

        // Tinh tong thoi gian sua
        int tongThoiGian = 0;
        for (Xe xeHienTai : xe) {
            tongThoiGian += xeHienTai.soNgaySua;
        }

        // Tinh tien phat cho moi xe
        for (Xe xeHienTai : xe) {
            int thoiGianConLai = tongThoiGian - xeHienTai.soNgaySua;
            xeHienTai.tinhTienPhat(thoiGianConLai);
        }

        // Sap xep xe theo tien phat (giam dan)
        Arrays.sort(xe, (xe1, xe2) -> Integer.compare(xe2.tienPhat, xe1.tienPhat));

        // Xuat ket qua
        System.out.println("Thu tu cac xe duoc sua (tu cao den thap):");
        for (Xe xeHienTai : xe) {
            System.out.println("Xe " + xeHienTai.id + " - Tien phat: " + xeHienTai.tienPhat);
        }

        // Dong scanner
        scanner.close();
    }
}
