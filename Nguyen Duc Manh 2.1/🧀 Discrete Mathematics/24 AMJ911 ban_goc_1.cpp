#include <iostream>
#include <string>
using namespace std;

const int MAX_NGAY = 31;
const int MAX_NGUYEN_LIEU = 100;

// Định nghĩa struct chi phí của một ngày
struct ChiPhiNgay {
    int chiPhi[MAX_NGUYEN_LIEU];
    int soNguyenLieu;
};

// Hàm nhập chi phí cho một ngày
void nhapChiPhiNgay(ChiPhiNgay& chiPhiNgay, int ngay) {
    cout << "***********************************************\n";
    cout << "*            Nhap chi phi cho ngay " << ngay << "             *\n";
    cout << "***********************************************\n";
    cout << "Xin hay cung cap thong tin ve chi phi mua nguyen lieu cho ngay hom do.\n";
    cout << "Nhap so luong nguyen lieu can mua: ";
    cin >> chiPhiNgay.soNguyenLieu;
    for (int i = 0; i < chiPhiNgay.soNguyenLieu; i++) {
        string tenNguyenLieu;
        int gia;
        cout << "Nhap ten nguyen lieu thu " << i + 1 << ": ";
        cin >> tenNguyenLieu;
        cout << "Nhap gia cua " << tenNguyenLieu << ": ";
        cin >> gia;
        chiPhiNgay.chiPhi[i] = gia;
    }
    cout << "Cam on ban da cung cap thong tin.\n";
}

// Hàm xem chi phí của một ngày
void xemChiPhiNgay(const ChiPhiNgay& chiPhiNgay, int ngay) {
    cout << "***********************************************\n";
    cout << "*           Xem chi phi cua ngay " << ngay << "             *\n";
    cout << "***********************************************\n";
    cout << "Duoi day la danh sach chi phi mua nguyen lieu cho ngay " << ngay << ":\n";
    int tongChiPhi = 0;
    for (int i = 0; i < chiPhiNgay.soNguyenLieu; i++) {
        cout << "- " << chiPhiNgay.chiPhi[i] << " dong\n";
        tongChiPhi += chiPhiNgay.chiPhi[i];
    }
    cout << "Tong chi phi: " << tongChiPhi << " dong\n";
}

// Hàm tìm kiếm nguyên liệu trong các ngày
void timKiemNguyenLieu(const ChiPhiNgay chiPhiNgay[], int soNgay, string tenNguyenLieu) {
    cout << "*************************************************\n";
    cout << "* Tim kiem nguyen lieu \"" << tenNguyenLieu << "\" trong cac ngay *\n";
    cout << "*************************************************\n";
    bool timThay = false;
    for (int i = 0; i < soNgay; i++) {
        for (int j = 0; j < chiPhiNgay[i].soNguyenLieu; j++) {
            if (tenNguyenLieu == "all" || tenNguyenLieu == to_string(chiPhiNgay[i].chiPhi[j])) {
                cout << "- Ngay " << i + 1 << ": " << chiPhiNgay[i].chiPhi[j] << " dong\n";
                timThay = true;
            }
        }
    }
    if (!timThay) {
        cout << "Khong tim thay nguyen lieu \"" << tenNguyenLieu << "\".\n";
    }
}

// Hàm tính tổng chi phí của tất cả các ngày
int tinhTongChiPhi(const ChiPhiNgay chiPhiNgay[], int soNgay) {
    cout << "*****************************************\n";
    cout << "*     Tinh tong chi phi hang ngay      *\n";
    cout << "*****************************************\n";
    int tongChiPhi = 0;
    for (int i = 0; i < soNgay; i++) {
        for (int j = 0; j < chiPhiNgay[i].soNguyenLieu; j++) {
            tongChiPhi += chiPhiNgay[i].chiPhi[j];
        }
    }
    return tongChiPhi;
}

int main() {
    cout << "********************************************\n";
    cout << "*  Chao mung quy khach den bep an truong hoc sang trong cua chung toi! *\n";
    cout << "*   Noi trai nghiem am thuc dang cap va nhung huong vi khong the nao quen  *\n";
    cout << "********************************************\n\n";

    ChiPhiNgay chiPhiNgay[MAX_NGAY];
    int soNgay = 0;
    int choice;
    do {
        cout << "=============================================\n";
        cout << "*           Quan ly chi phi hang ngay           *\n";
        cout << "=============================================\n";
        cout << "1. Nhap chi phi cho mot ngay\n";
        cout << "2. Xem chi phi cua mot ngay\n";
        cout << "3. Tim kiem nguyen lieu\n";
        cout << "4. Tong chi phi hang ngay\n";
        cout << "5. Thoat chuong trinh\n";
        cout << "Lua chon cua ban: ";
        cin >> choice;
        switch (choice) {
            case 1: {
                int ngay;
                cout << "Nhap ngay can nhap chi phi: ";
                cin >> ngay;
                nhapChiPhiNgay(chiPhiNgay[ngay - 1], ngay);
                if (ngay > soNgay) {
                    soNgay = ngay;
                }
                break;
            }
            case 2: {
                int ngayXem;
                cout << "Nhap ngay can xem chi phi: ";
                cin >> ngayXem;
                if (ngayXem > soNgay) {
                    cout << "Ngay " << ngayXem << " chua co chi phi.\n";
                } else {
                    xemChiPhiNgay(chiPhiNgay[ngayXem - 1], ngayXem);
                }
                break;
            }
            case 3: {
                string tenNguyenLieu;
                cout << "Nhap ten nguyen lieu can tim kiem (nhap \"all\" de xem tat ca): ";
                cin >> tenNguyenLieu;
                timKiemNguyenLieu(chiPhiNgay, soNgay, tenNguyenLieu);
                break;
            }
            case 4: {
                cout << "Tong chi phi hang ngay: " << tinhTongChiPhi(chiPhiNgay, soNgay) << " dong\n";
                break;
            }
            case 5: {
                cout << "Cam on quy khach da ghe tham nha hang cua chung toi. Hen gap lai!\n";
                break;
            }
            default: {
                cout << "Lua chon khong hop le. Xin vui long chon lai.\n";
            }
        }
    } while (choice != 5);
    return 0;
}
