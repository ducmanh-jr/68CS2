
#include <iostream>
#include <string>
using namespace std;

const int MAX_NGAY = 31;
const int MAX_NGUYEN_LIEU = 100;

// Hàm nhập chi phí cho một ngày
void nhapChiPhiNgay(int chiPhiNgay[][MAX_NGUYEN_LIEU], int ngay) {
    int soNguyenLieu;
    cout << "Nhập số lượng nguyên liệu cần mua: ";
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
    int chiPhiNgay[MAX_NGAY][MAX_NGUYEN_LIEU] = {0};
    int soNgay = 0;
    int choice;
    do {
        cout << "===== Quản lý chi phí hàng ngày =====\n";
        cout << "1. Nhập chi phí cho một ngày\n";
        cout << "2. Xem chi phí của một ngày\n";
        cout << "3. Tìm kiếm nguyên liệu\n";
        cout << "4. Tổng chi phí hàng ngày\n";
        cout << "5. Thoát chương trình\n";
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
                cout << "Thoát chương trình.\n";
                break;
            }
            default: {
                cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại.\n";
            }
        }
    } while (choice != 5);
    return 0;
}
