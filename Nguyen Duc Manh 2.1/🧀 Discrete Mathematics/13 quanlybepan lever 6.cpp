
#include <iostream>
#include <string>
using namespace std;

const int a1 = 30;
const int a2 = 100;


void nhaps1(int s1[][a2], int s2) {
    int s3;
    cout << "Nhập số lượng nguyên liệu cần mua: ";
    cin >> s3;
    for (int i = 0; i < s3; i++) {
        string s4;
        int s5;
        cout << "Nhập tên nguyên liệu thứ " << i + 1 << ": ";
        cin >> s4;
        cout << "Nhập giá của " << s4 << ": ";
        cin >> s5;
        s1[s2 - 1][i] = s5;
    }
}


void xems1(int s1[][a2], int s2) {
    cout << "Chi phí của ngày " << s2 << ":\n";
    int z1 = 0;
    for (int i = 0; s1[s2 - 1][i] != 0; i++) {
        cout << "- " << s1[s2 - 1][i] << " đồng\n";
        z1 += s1[s2 - 1][i];
    }
    cout << "Tổng chi phí: " << z1 << " đồng\n";
}


void timKiemNguyenLieu(int s1[][a2], int z2, string s4) {
    cout << "Kết quả tìm kiếm cho \"" << s4 << "\":\n";
    bool z3 = false;
    for (int i = 0; i < z2; i++) {
        for (int j = 0; s1[i][j] != 0; j++) {
            if (s4 == "all" || s4 == to_string(s1[i][j])) {
                cout << "- Ngày " << i + 1 << ": " << s1[i][j] << " đồng\n";
                z3 = true;
            }
        }
    }
    if (!z3) {
        cout << "Không tìm thấy nguyên liệu \"" << s4 << "\".\n";
    }
}

int tinhTongChiPhi(int s1[][a2], int z2) {
    int z1 = 0;
    for (int i = 0; i < z2; i++) {
        for (int j = 0; s1[i][j] != 0; j++) {
            z1 += s1[i][j];
        }
    }
    return z1;
}

int main() {
    int s1[a1][a2] = {0};
    int z2 = 0;
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
                int s2;
                cout << "Nhập ngày cần nhập chi phí: ";
                cin >> s2;
                nhaps1(s1, s2);
                if (s2 > z2) {
                    z2 = s2;
                }
                break;
            }
            case 2: {
                int z4;
                cout << "Nhập ngày cần xem chi phí: ";
                cin >> z4;
                if (z4 > z2) {
                    cout << "Ngày " << z4 << " chưa có chi phí.\n";
                } else {
                    xems1(s1, z4);
                }
                break;
            }
            case 3: {
                string s4;
                cout << "Nhập tên nguyên liệu cần tìm kiếm (nhập \"all\" để xem tất cả): ";
                cin >> s4;
                timKiemNguyenLieu(s1, z2, s4);
                break;
            }
            case 4: {
                cout << "Tổng chi phí hàng ngày: " << tinhTongChiPhi(s1, z2) << " đồng\n";
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
