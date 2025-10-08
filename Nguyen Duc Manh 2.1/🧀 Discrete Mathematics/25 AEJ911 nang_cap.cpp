#include <iostream>
#include <string>
using namespace std;

const int MAX_NGAY = 31;
const int MAX_NGUYEN_LIEU = 100;
const int MAX_SO_MON_AN = 10; // Số lượng món ăn tối đa

// Khai báo một struct để lưu thông tin về nguyên liệu
struct NguyenLieu {
    string tenNguyenLieu;
    int soLuong;
};

// Khai báo một struct để lưu thông tin về món ăn
struct MonAn {
    string tenMon;
    int maMon;
    NguyenLieu* nguyenLieu;
    int soNguyenLieu;
};

// Khai báo một mảng các món ăn
MonAn menuMonAn[MAX_SO_MON_AN];

// Số lượng món ăn hiện có trong menu
int soMonAn = 0;

// Hàm hiển thị menu món ăn và danh sách nguyên liệu của từng món
void hienThiMenuMonAn() {
    cout << "===== Danh sách menu món ăn =====\n";
    for (int i = 0; i < soMonAn; i++) {
        cout << "Món " << menuMonAn[i].tenMon << " (Mã " << menuMonAn[i].maMon << "):\n";
        cout << "Nguyên liệu cần cho món " << menuMonAn[i].tenMon << ":\n";
        for (int j = 0; j < menuMonAn[i].soNguyenLieu; j++) {
            cout << "- " << menuMonAn[i].nguyenLieu[j].tenNguyenLieu << ": " << menuMonAn[i].nguyenLieu[j].soLuong << endl;
        }
        cout << endl;
    }
}

// Hàm nhập thông tin về nguyên liệu cho một món ăn
void nhapNguyenLieuChoMonAn(MonAn& monAn) {
    cout << "Nhập số lượng nguyên liệu cần cho món " << monAn.tenMon << ": ";
    cin >> monAn.soNguyenLieu;
    monAn.nguyenLieu = new NguyenLieu[monAn.soNguyenLieu];
    for (int i = 0; i < monAn.soNguyenLieu; i++) {
        cout << "Nhập tên nguyên liệu thứ " << i + 1 << ": ";
        cin >> monAn.nguyenLieu[i].tenNguyenLieu;
        cout << "Nhập số lượng nguyên liệu thứ " << i + 1 << ": ";
        cin >> monAn.nguyenLieu[i].soLuong;
    }
}

// Hàm nhập thông tin về một món ăn mới
void nhapMonAn() {
    if (soMonAn < MAX_SO_MON_AN) {
        cout << "Nhập tên món ăn: ";
        cin >> menuMonAn[soMonAn].tenMon;
        cout << "Nhập mã món ăn: ";
        cin >> menuMonAn[soMonAn].maMon;
        nhapNguyenLieuChoMonAn(menuMonAn[soMonAn]);
        soMonAn++;
    } else {
        cout << "Danh sách món ăn đã đầy. Không thể thêm món ăn mới.\n";
    }
}

// Hàm nhập mã món ăn và hiển thị thông tin chi tiết về món ăn đó
void timMonAnTheoMa() {
    int maMonAn;
    cout << "Nhập mã món ăn cần tìm: ";
    cin >> maMonAn;
    bool timThay = false;
    for (int i = 0; i < soMonAn; i++) {
        if (menuMonAn[i].maMon == maMonAn) {
            cout << "Thông tin chi tiết về món " << menuMonAn[i].tenMon << " (Mã " << menuMonAn[i].maMon << "):\n";
            cout << "Nguyên liệu cần cho món " << menuMonAn[i].tenMon << ":\n";
            for (int j = 0; j < menuMonAn[i].soNguyenLieu; j++) {
                cout << "- " << menuMonAn[i].nguyenLieu[j].tenNguyenLieu << ": " << menuMonAn[i].nguyenLieu[j].soLuong << endl;
            }
            timThay = true;
            break;
        }
    }
    if (!timThay) {
        cout << "Không tìm thấy món ăn có mã " << maMonAn << ".\n";
    }
}

// Hàm nhập chi phí cho một ngày
void nhapChiPhiNgay(int chiPhiNgay[][MAX_NGUYEN_LIEU], int ngay) {
    int soNguyenLieu;
    cout << "Nhập số lượng nguyên liệu cần mua trong ngày : ";
    cin >> soNguyenLieu;
    for (int i = 0; i < soNguyenLieu; i++) {
        string tenNguyenLieu;
        int gia;
        cout << "Nhập tên nguyên liệu thứ " << i + 1 << ": ";
        cin >> tenNguyenLieu;
        cout << "Nhập giá của " << tenNguyenLieu << ": ";
        cin >> gia;
        chiPhiNgay[ngay - 1][i] = gia;
    }
}

// Hàm xem chi phí của một ngày
void xemChiPhiNgay(int chiPhiNgay[][MAX_NGUYEN_LIEU], int ngay) {
    cout << "Chi phí của ngày " << ngay << ":\n";
    int tongChiPhi = 0;
    for (int i = 0; chiPhiNgay[ngay - 1][i] != 0; i++) {
        cout << "- " << chiPhiNgay[ngay - 1][i] << " đồng\n";
        tongChiPhi += chiPhiNgay[ngay - 1][i];
    }
    cout << "Tổng chi phí: " << tongChiPhi << " đồng\n";
}

// Hàm tìm kiếm nguyên liệu trong các ngày
void timKiemNguyenLieu(int chiPhiNgay[][MAX_NGUYEN_LIEU], int soNgay, string tenNguyenLieu) {
    cout << "Kết quả tìm kiếm cho \"" << tenNguyenLieu << "\":\n";
    bool timThay = false;
    for (int i = 0; i < soNgay; i++) {
        for (int j = 0; chiPhiNgay[i][j] != 0; j++) {
            if (tenNguyenLieu == "all" || tenNguyenLieu == to_string(chiPhiNgay[i][j])) {
                cout << "- Ngày " << i + 1 << ": " << chiPhiNgay[i][j] << " đồng\n";
                timThay = true;
            }
        }
    }
    if (!timThay) {
        cout << "Không tìm thấy nguyên liệu \"" << tenNguyenLieu << "\".\n";
    }
}

// Hàm tính tổng chi phí của tất cả các ngày
int tinhTongChiPhi(int chiPhiNgay[][MAX_NGUYEN_LIEU], int soNgay) {
    int tongChiPhi = 0;
    for (int i = 0; i < soNgay; i++) {
        for (int j = 0; chiPhiNgay[i][j] != 0; j++) {
            tongChiPhi += chiPhiNgay[i][j];
        }
    }
    return tongChiPhi;
}

int main() {
    // Khởi tạo thông tin cho một số món ăn trong menu
    menuMonAn[0].tenMon = "Bún chả";
    menuMonAn[0].maMon = 1;
    menuMonAn[0].soNguyenLieu = 2;
    menuMonAn[0].nguyenLieu = new NguyenLieu[2];
    menuMonAn[0].nguyenLieu[0].tenNguyenLieu = "Thịt heo";
    menuMonAn[0].nguyenLieu[0].soLuong = 300;
    menuMonAn[0].nguyenLieu[1].tenNguyenLieu = "Bún";
    menuMonAn[0].nguyenLieu[1].soLuong = 200;

    menuMonAn[1].tenMon = "Phở";
    menuMonAn[1].maMon = 2;
    menuMonAn[1].soNguyenLieu = 3;
    menuMonAn[1].nguyenLieu = new NguyenLieu[3];
    menuMonAn[1].nguyenLieu[0].tenNguyenLieu = "Bò";
    menuMonAn[1].nguyenLieu[0].soLuong = 500;
    menuMonAn[1].nguyenLieu[1].tenNguyenLieu = "Hành";
    menuMonAn[1].nguyenLieu[1].soLuong = 100;
    menuMonAn[1].nguyenLieu[2].tenNguyenLieu = "Gừng";
    menuMonAn[1].nguyenLieu[2].soLuong = 50;

    menuMonAn[2].tenMon = "Gà nướng";
    menuMonAn[2].maMon = 3;
    menuMonAn[2].soNguyenLieu = 2;
    menuMonAn[2].nguyenLieu = new NguyenLieu[2];
    menuMonAn[2].nguyenLieu[0].tenNguyenLieu = "Gà";
    menuMonAn[2].nguyenLieu[0].soLuong = 400;
    menuMonAn[2].nguyenLieu[1].tenNguyenLieu = "Nước mắm";
    menuMonAn[2].nguyenLieu[1].soLuong = 50;

    // Gán số lượng món ăn cho biến soMonAn
    soMonAn = 3;

    int chiPhiNgay[MAX_NGAY][MAX_NGUYEN_LIEU] = {0};
    int soNgay = 0;
    int choice;
    do {
        cout << "===== Quản lý chi phí hàng ngày =====\n";
        cout << "1. Nhập chi phí cho một ngày\n";
        cout << "2. Xem chi phí của một ngày\n";
        cout << "3. Tìm kiếm nguyên liệu\n";
        cout << "4. Tổng chi phí hàng ngày\n";
        cout << "5. Hiển thị danh sách menu món ăn\n";
        cout << "6. Thêm một món ăn mới\n";
        cout << "7. Tìm món ăn theo mã\n";
        cout << "8. Thoát chương trình\n";
        cout << "Lựa chọn của bạn: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                int ngay;
                cout << "Nhập ngày cần nhập chi phí: ";
                cin >> ngay;
                nhapChiPhiNgay(chiPhiNgay, ngay);
                if (ngay > soNgay) {
                    soNgay = ngay;
                }
                break;
            }
            case 2: {
                int ngayXem;
                cout << "Nhập ngày cần xem chi phí: ";
                cin >> ngayXem;
                if (ngayXem > soNgay) {
                    cout << "Ngày " << ngayXem << " chưa có chi phí.\n";
                } else {
                    xemChiPhiNgay(chiPhiNgay, ngayXem);
                }
                break;
            }
            case 3: {
                string tenNguyenLieu;
                cout << "Nhập tên nguyên liệu cần tìm kiếm (nhập \"all\" để xem tất cả): ";
                cin >> tenNguyenLieu;
                timKiemNguyenLieu(chiPhiNgay, soNgay, tenNguyenLieu);
                break;
            }
            case 4: {
                cout << "Tổng chi phí hàng ngày: " << tinhTongChiPhi(chiPhiNgay, soNgay) << " đồng\n";
                break;
            }
            case 5: {
                hienThiMenuMonAn();
                break;
            }
            case 6: {
                nhapMonAn();
                break;
            }
            case 7: {
                timMonAnTheoMa();
                break;
            }
            case 8: {
                cout << "Thoát chương trình.\n";
                break;
            }
            default: {
                cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại.\n";
            }
        }
    } while (choice != 8);
    // Giải phóng bộ nhớ cho các mảng động
    for (int i = 0; i < soMonAn; i++) {
        delete[] menuMonAn[i].nguyenLieu;
    }
    return 0;
}
