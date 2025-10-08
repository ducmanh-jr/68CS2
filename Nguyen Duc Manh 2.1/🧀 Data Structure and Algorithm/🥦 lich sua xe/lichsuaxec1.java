import java.util.*;

public class lichsuaxec1 {
    static class Xe {
        int soNgaySua; // so ngay sua
        int mucPhat; // muc phat tren 1 ngay
        int id; // so thu tu xe

        Xe(int id, int soNgaySua, int mucPhat) {
            this.id = id;
            this.soNgaySua = soNgaySua;
            this.mucPhat = mucPhat;
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

        // Sap xep xe theo tieu chi
        Arrays.sort(xe, (xe1, xe2) -> {
            // Sap xep theo muc phat (giam dan)
            if (xe1.mucPhat != xe2.mucPhat) {
                return Integer.compare(xe2.mucPhat, xe1.mucPhat);
            }
            // Neu bang nhau, sap xep theo so ngay sua (tang dan)
            return Integer.compare(xe1.soNgaySua, xe2.soNgaySua);
        });

        // Tinh toan tien phat
        int tongPhat = 0;
        int thoiGianHienTai = 0;
        List<Integer> thuTu = new ArrayList<>();

        for (Xe xeHienTai : xe) {
            thoiGianHienTai += xeHienTai.soNgaySua;

            // Tinh so ngay muon
            int ngayMuon = Math.max(0, thoiGianHienTai - xeHienTai.soNgaySua);
            tongPhat += ngayMuon * xeHienTai.mucPhat;

            // Ghi lai thu tu sua xe
            thuTu.add(xeHienTai.id); // Luu ID xe
        }

        // Xuat ket qua
        System.out.println("Tong tien phat toi thieu: " + tongPhat);
        System.out.print("Thu tu cac xe duoc sua: ");
        for (int id : thuTu) {
            System.out.print(id + " "); // In so thu tu xe
        }

        // Dong scanner
        scanner.close();
    }
}
/*
 * 3 2 4 1
 * 
 * 1 * 6
 * 3 * 7
 * 4 * 6
 * 2 * 8
 * 
 * mức phạt của xe này nhân với tổng thời gian sửa các xe còn lại
 * xe nào cao nhất sửa đầu tiên
 */
