#include <iostream>
#include <string>

using namespace std;

// Khai báo hằng số
const int MAX_MON_AN = 100;
const int MAX_NGUYEN_LIEU = 5;
const int MAX_MON_AN_TRONG_DON_HANG = 10;
const int MAX_NGUOI_DUNG = 100;

// Khai báo struct NguyenLieu
struct NguyenLieu {
    string tenNguyenLieu;
    int soLuong;
};

// Khai báo struct MonAn
struct MonAn {
    string maMonAn;
    string tenMonAn;
    int soNguyenLieu;
    NguyenLieu nguyenLieu[MAX_NGUYEN_LIEU];
    int gia;
};

// Khai báo struct DonHang
struct DonHang {
    MonAn monAn[MAX_MON_AN_TRONG_DON_HANG];
    int soMonAn;
};

// Khai báo struct NguoiDung
struct NguoiDung {
    string username;
    string password;
};

// Khai báo biến toàn cục
MonAn menuMonAn[MAX_MON_AN];
int soMonAnTrongMenu = 0;
NguoiDung danhSachNguoiDung[MAX_NGUOI_DUNG];
int soNguoiDung = 0;

// Hàm hiển thị menu món ăn
void hienThiMenuMonAn() {
    cout << "===== Menu món ăn =====" << endl;
    for (int i = 0; i < soMonAnTrongMenu; i++) {
        cout << "Mã món ăn: " << menuMonAn[i].maMonAn << endl;
        cout << "Tên món ăn: " << menuMonAn[i].tenMonAn << endl;
        cout << "Số nguyên liệu: " << menuMonAn[i].soNguyenLieu << endl;
        cout << "Nguyên liệu: " << endl;
        for (int j = 0; j < menuMonAn[i].soNguyenLieu; j++) {
            cout << "- " << menuMonAn[i].nguyenLieu[j].tenNguyenLieu << ": " << menuMonAn[i].nguyenLieu[j].soLuong << endl;
        }
        cout << "Giá: " << menuMonAn[i].gia << endl;
        cout << endl;
    }
}

// Hàm thêm một món ăn mới vào menu
void nhapMonAn() {
    if (soMonAnTrongMenu < MAX_MON_AN) {
        cout << "Nhập thông tin cho món ăn mới:" << endl;
        cout << "Mã món ăn: ";
        cin >> menuMonAn[soMonAnTrongMenu].maMonAn;
        cout << "Tên món ăn: ";
        cin.ignore();
        getline(cin, menuMonAn[soMonAnTrongMenu].tenMonAn);
        cout << "Số nguyên liệu: ";
        cin >> menuMonAn[soMonAnTrongMenu].soNguyenLieu;
        for (int i = 0; i < menuMonAn[soMonAnTrongMenu].soNguyenLieu; i++) {
            cout << "Nhập tên nguyên liệu thứ " << i + 1 << ": ";
            cin.ignore();
            getline(cin, menuMonAn[soMonAnTrongMenu].nguyenLieu[i].tenNguyenLieu);
            cout << "Nhập số lượng nguyên liệu: ";
            cin >> menuMonAn[soMonAnTrongMenu].nguyenLieu[i].soLuong;
        }
        cout << "Nhập giá: ";
        cin >> menuMonAn[soMonAnTrongMenu].gia;
        soMonAnTrongMenu++;
        cout << "Món ăn đã được thêm vào menu." << endl;
    } else {
        cout << "Danh sách món ăn đã đầy, không thể thêm mới." << endl;
    }
}

// Hàm tính tổng chi phí của đơn hàng
int tinhTongChiPhi(const DonHang &donHang) {
    int tongChiPhi = 0;
    for (int i = 0; i < donHang.soMonAn; i++) {
        tongChiPhi += donHang.monAn[i].gia;
    }
    return tongChiPhi;
}

// Hàm nhập đơn hàng
void nhapDonHang(DonHang &donHang) {
    donHang.soMonAn = 0;
    string maMonAn;
    do {
        cout << "Nhập mã món ăn (nhập '0' để kết thúc): ";
        cin >> maMonAn;
        if (maMonAn != "0") {
            bool timThay = false;
            for (int i = 0; i < soMonAnTrongMenu; i++) {
                if (menuMonAn[i].maMonAn == maMonAn) {
                    donHang.monAn[donHang.soMonAn++] = menuMonAn[i];
                    timThay = true;
                    break;
                }
            }
            if (!timThay) {
                cout << "Không tìm thấy món ăn với mã " << maMonAn << ". Vui lòng nhập lại." << endl;
            }
        }
    } while (maMonAn != "0" && donHang.soMonAn < MAX_MON_AN_TRONG_DON_HANG);
}

// Hàm hiển thị đơn hàng
void hienThiDonHang(const DonHang &donHang) {
    cout << "===== Đơn hàng =====" << endl;
    for (int i = 0; i < donHang.soMonAn; i++) {
        cout << "Mã món ăn: " << donHang.monAn[i].maMonAn << endl;
        cout << "Tên món ăn: " << donHang.monAn[i].tenMonAn << endl;
        cout << "Số nguyên liệu: " << donHang.monAn[i].soNguyenLieu << endl;
        cout << "Nguyên liệu: " << endl;
        for (int j = 0; j < donHang.monAn[i].soNguyenLieu; j++) {
            cout << "- " << donHang.monAn[i].nguyenLieu[j].tenNguyenLieu << ": " << donHang.monAn[i].nguyenLieu[j].soLuong << endl;
        }
        cout << "Giá: " << donHang.monAn[i].gia << endl;
        cout << endl;
    }
}

// Hàm xác nhận đơn hàng và thanh toán
void xacNhanVaThanhToan(const DonHang &donHang) {
    string luaChon;
    cout << "Bạn có muốn xác nhận đơn hàng và thanh toán (Y/N)? ";
    cin >> luaChon;
    if (luaChon == "Y" || luaChon == "y") {
        int tongChiPhi = tinhTongChiPhi(donHang);
        cout << "Tổng chi phí đơn hàng: " << tongChiPhi << " đồng." << endl;
        cout << "Bạn có muốn thanh toán trực tuyến hay tại cửa hàng (Online/Store)? ";
        cin >> luaChon;
        if (luaChon == "Online" || luaChon == "online") {
            cout << "Thanh toán trực tuyến thành công." << endl;
        } else if (luaChon == "Store" || luaChon == "store") {
            cout << "Vui lòng thanh toán tại cửa hàng." << endl;
        } else {
            cout << "Lựa chọn không hợp lệ." << endl;
        }
    } else {
        cout << "Đã hủy đơn hàng." << endl;
    }
}

// Hàm đăng ký người dùng mới
void dangKyNguoiDung() {
    if (soNguoiDung < MAX_NGUOI_DUNG) {
        cout << "Nhập tên người dùng: ";
        cin >> danhSachNguoiDung[soNguoiDung].username;
        cout << "Nhập mật khẩu: ";
        cin >> danhSachNguoiDung[soNguoiDung].password;
        soNguoiDung++;
        cout << "Đăng ký thành công." << endl;
    } else {
        cout << "Danh sách người dùng đã đầy, không thể đăng ký mới." << endl;
    }
}

// Hàm đăng nhập
bool dangNhap(string username, string password) {
    for (int i = 0; i < soNguoiDung; i++) {
        if (danhSachNguoiDung[i].username == username && danhSachNguoiDung[i].password == password) {
            return true;
        }
    }
    return false;
}

int main() {
    DonHang donHang;
    int choice;
    string username, password;

    // Đăng ký người dùng mặc định
    danhSachNguoiDung[soNguoiDung++] = {"admin", "admin"};

    // Menu chương trình
    do {
        cout << "===== Quản lý đơn hàng =====" << endl;
        cout << "1. Đăng ký người dùng mới" << endl;
        cout << "2. Đăng nhập" << endl;
        cout << "3. Hiển thị menu món ăn" << endl;
        cout << "4. Thêm món ăn vào menu" << endl;
        cout << "5. Nhập đơn hàng" << endl;
        cout << "6. Hiển thị đơn hàng" << endl;
        cout << "7. Tính tổng chi phí đơn hàng" << endl;
        cout << "8. Xác nhận đơn hàng và thanh toán" << endl;
        cout << "0. Thoát" << endl;
        cout << "Nhập lựa chọn: ";
        cin >> choice;

        switch (choice) {
            case 1:
                dangKyNguoiDung();
                break;
            case 2:
                cout << "Nhập tên người dùng: ";
                cin >> username;
                cout << "Nhập mật khẩu: ";
                cin >> password;
                if (dangNhap(username, password)) {
                    cout << "Đăng nhập thành công." << endl;
                } else {
                    cout << "Đăng nhập không thành công. Vui lòng kiểm tra lại tên người dùng và mật khẩu." << endl;
                }
                break;
            case 3:
                hienThiMenuMonAn();
                break;
            case 4:
                nhapMonAn();
                break;
            case 5:
                nhapDonHang(donHang);
                break;
            case 6:
                hienThiDonHang(donHang);
                break;
            case 7:
                cout << "Tổng chi phí đơn hàng: " << tinhTongChiPhi(donHang) << endl;
                break;
            case 8:
                xacNhanVaThanhToan(donHang);
                break;
            case 0:
                cout << "Thoát chương trình." << endl;
                break;
            default:
                cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại." << endl;
                break;
        }
    } while (choice != 0);

    return 0;
}
