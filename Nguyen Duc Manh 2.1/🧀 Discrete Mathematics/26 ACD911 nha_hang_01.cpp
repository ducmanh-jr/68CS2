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
        cout << "Không tìm thấy món ăn với mã " << maMonAn << endl;
    }
}

// Hàm tính tổng chi phí của tất cả các ngày
int tinhTongChiPhi(int chiPhiNgay[MAX_NGAY], int soNgay) {
    int tongChiPhi = 0;
    for (int i = 0; i < soNgay; i++) {
        tongChiPhi += chiPhiNgay[i];
    }
    return tongChiPhi;
}

int main() {
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

        // Khởi tạo thông tin cho các món ăn mới
    menuMonAn[3].tenMon = "Rendang - Cà Ri Khô Indonesia";
    menuMonAn[3].maMon = 4;
    menuMonAn[3].soNguyenLieu = 3;
    menuMonAn[3].nguyenLieu = new NguyenLieu[3];
    menuMonAn[3].nguyenLieu[0].tenNguyenLieu = "Thịt bò";
    menuMonAn[3].nguyenLieu[0].soLuong = 300;
    menuMonAn[3].nguyenLieu[1].tenNguyenLieu = "Gia vị cà ri";
    menuMonAn[3].nguyenLieu[1].soLuong = 100;
    menuMonAn[3].nguyenLieu[2].tenNguyenLieu = "Dầu ăn";
    menuMonAn[3].nguyenLieu[2].soLuong = 50;

    menuMonAn[4].tenMon = "Sushi - Nhật Bản";
    menuMonAn[4].maMon = 5;
    menuMonAn[4].soNguyenLieu = 3;
    menuMonAn[4].nguyenLieu = new NguyenLieu[3];
    menuMonAn[4].nguyenLieu[0].tenNguyenLieu = "Gạo";
    menuMonAn[4].nguyenLieu[0].soLuong = 200;
    menuMonAn[4].nguyenLieu[1].tenNguyenLieu = "Cá sống";
    menuMonAn[4].nguyenLieu[1].soLuong = 100;
    menuMonAn[4].nguyenLieu[2].tenNguyenLieu = "Giấm gạo";
    menuMonAn[4].nguyenLieu[2].soLuong = 50;

    menuMonAn[5].tenMon = "Pizza - Ý";
    menuMonAn[5].maMon = 6;
    menuMonAn[5].soNguyenLieu = 4;
    menuMonAn[5].nguyenLieu = new NguyenLieu[4];
    menuMonAn[5].nguyenLieu[0].tenNguyenLieu = "Bột mỳ";
    menuMonAn[5].nguyenLieu[0].soLuong = 250;
    menuMonAn[5].nguyenLieu[1].tenNguyenLieu = "Sốt cà chua";
    menuMonAn[5].nguyenLieu[1].soLuong = 100;
    menuMonAn[5].nguyenLieu[2].tenNguyenLieu = "Phô mai";
    menuMonAn[5].nguyenLieu[2].soLuong = 150;
    menuMonAn[5].nguyenLieu[3].tenNguyenLieu = "Hành tây";
    menuMonAn[5].nguyenLieu[3].soLuong = 30;

    // Khởi tạo thông tin cho món 4
    menuMonAn[6].tenMon = "Tom Yum - Thái Lan";
    menuMonAn[6].maMon = 7;
    menuMonAn[6].soNguyenLieu = 4;
    menuMonAn[6].nguyenLieu = new NguyenLieu[4];
    menuMonAn[6].nguyenLieu[0].tenNguyenLieu = "Tôm";
    menuMonAn[6].nguyenLieu[0].soLuong = 200;
    menuMonAn[6].nguyenLieu[1].tenNguyenLieu = "Nước cốt dừa";
    menuMonAn[6].nguyenLieu[1].soLuong = 100;
    menuMonAn[6].nguyenLieu[2].tenNguyenLieu = "Sả";
    menuMonAn[6].nguyenLieu[2].soLuong = 20;
    menuMonAn[6].nguyenLieu[3].tenNguyenLieu = "Hành lá";
    menuMonAn[6].nguyenLieu[3].soLuong = 10;

    // Tiếp tục khởi tạo thông tin cho các món ăn khác

    // Khởi tạo thông tin cho món 5
    menuMonAn[7].tenMon = "Vịt quay Bắc Kinh - Trung Quốc";
    menuMonAn[7].maMon = 8;
    menuMonAn[7].soNguyenLieu = 2;
    menuMonAn[7].nguyenLieu = new NguyenLieu[2];
    menuMonAn[7].nguyenLieu[0].tenNguyenLieu = "Vịt";
    menuMonAn[7].nguyenLieu[0].soLuong = 300;
    menuMonAn[7].nguyenLieu[1].tenNguyenLieu = "Gia vị vịt quay";
    menuMonAn[7].nguyenLieu[1].soLuong = 50;

    // Khởi tạo thông tin cho món 6
    menuMonAn[8].tenMon = "Hương Vị Dimsum - Hồng Kông";
    menuMonAn[8].maMon = 9;
    menuMonAn[8].soNguyenLieu = 3;
    menuMonAn[8].nguyenLieu = new NguyenLieu[3];
    menuMonAn[8].nguyenLieu[0].tenNguyenLieu = "Thịt lợn";
    menuMonAn[8].nguyenLieu[0].soLuong = 200;
    menuMonAn[8].nguyenLieu[1].tenNguyenLieu = "Tôm";
    menuMonAn[8].nguyenLieu[1].soLuong = 100;
    menuMonAn[8].nguyenLieu[2].tenNguyenLieu = "Bột mì";
    menuMonAn[8].nguyenLieu[2].soLuong = 50;

    // Tiếp tục khởi tạo thông tin cho các món ăn khác

    // Khởi tạo thông tin cho món 7
    menuMonAn[9].tenMon = "Chocolate Mềm Mịn với Lớp Kem Kiểu Mexico - Mexico";
    menuMonAn[9].maMon = 10;
    menuMonAn[9].soNguyenLieu = 4;
    menuMonAn[9].nguyenLieu = new NguyenLieu[4];
    menuMonAn[9].nguyenLieu[0].tenNguyenLieu = "Socola";
    menuMonAn[9].nguyenLieu[0].soLuong = 100;
    menuMonAn[9].nguyenLieu[1].tenNguyenLieu = "Kem";
    menuMonAn[9].nguyenLieu[1].soLuong = 50;
    menuMonAn[9].nguyenLieu[2].tenNguyenLieu = "Đường";
    menuMonAn[9].nguyenLieu[2].soLuong = 30;
    menuMonAn[9].nguyenLieu[3].tenNguyenLieu = "Vanilla";
    menuMonAn[9].nguyenLieu[3].soLuong = 10;

    // Khởi tạo thông tin cho món 8
    menuMonAn[10].tenMon = "Pasta - Biểu Tượng Của Ẩm Thực Ý";
    menuMonAn[10].maMon = 11;
    menuMonAn[10].soNguyenLieu = 3;
    menuMonAn[10].nguyenLieu = new NguyenLieu[3];
    menuMonAn[10].nguyenLieu[0].tenNguyenLieu = "Mỳ spaghetti";
    menuMonAn[10].nguyenLieu[0].soLuong = 200;
    menuMonAn[10].nguyenLieu[1].tenNguyenLieu = "Sốt cà chua";
    menuMonAn[10].nguyenLieu[1].soLuong = 100;
    menuMonAn[10].nguyenLieu[2].tenNguyenLieu = "Phô mai Parmesan";
    menuMonAn[10].nguyenLieu[2].soLuong = 50;

    // Tiếp tục khởi tạo thông tin cho các món ăn khác

    // Khởi tạo thông tin cho món 9
    menuMonAn[11].tenMon = "Cà Ri Massaman Thái Lan - Vương Quốc Của Hương Vị";
    menuMonAn[11].maMon = 12;
    menuMonAn[11].soNguyenLieu = 4;
    menuMonAn[11].nguyenLieu = new NguyenLieu[4];
    menuMonAn[11].nguyenLieu[0].tenNguyenLieu = "Thịt bò";
    menuMonAn[11].nguyenLieu[0].soLuong = 300;
    menuMonAn[11].nguyenLieu[1].tenNguyenLieu = "Cà rốt";
    menuMonAn[11].nguyenLieu[1].soLuong = 100;
    menuMonAn[11].nguyenLieu[2].tenNguyenLieu = "Khoai tây";
    menuMonAn[11].nguyenLieu[2].soLuong = 150;
    menuMonAn[11].nguyenLieu[3].tenNguyenLieu = "Nước dừa";
    menuMonAn[11].nguyenLieu[3].soLuong = 200;

    // Khởi tạo thông tin cho món 10
    menuMonAn[12].tenMon = "Mì Ramen - Ngọn Hải Đảo Nhật Bản";
    menuMonAn[12].maMon = 13;
    menuMonAn[12].soNguyenLieu = 3;
    menuMonAn[12].nguyenLieu = new NguyenLieu[3];
    menuMonAn[12].nguyenLieu[0].tenNguyenLieu = "Mì Ramen";
    menuMonAn[12].nguyenLieu[0].soLuong = 1;
    menuMonAn[12].nguyenLieu[1].tenNguyenLieu = "Trứng";
    menuMonAn[12].nguyenLieu[1].soLuong = 2;
    menuMonAn[12].nguyenLieu[2].tenNguyenLieu = "Rau cải";
    menuMonAn[12].nguyenLieu[2].soLuong = 1;

    // Khởi tạo thông tin cho món 11
    menuMonAn[13].tenMon = "Phở - Di Sản Ẩm Thực Việt Nam";
    menuMonAn[13].maMon = 14;
    menuMonAn[13].soNguyenLieu = 3;
    menuMonAn[13].nguyenLieu = new NguyenLieu[3];
    menuMonAn[13].nguyenLieu[0].tenNguyenLieu = "Bò";
    menuMonAn[13].nguyenLieu[0].soLuong = 300;
    menuMonAn[13].nguyenLieu[1].tenNguyenLieu = "Gừng";
    menuMonAn[13].nguyenLieu[1].soLuong = 50;
    menuMonAn[13].nguyenLieu[2].tenNguyenLieu = "Hành";
    menuMonAn[13].nguyenLieu[2].soLuong = 100;

    // Khởi tạo thông tin cho món 12
    menuMonAn[14].tenMon = "Bibimbap - Hàn Quốc";
    menuMonAn[14].maMon = 15;
    menuMonAn[14].soNguyenLieu = 4;
    menuMonAn[14].nguyenLieu = new NguyenLieu[4];
    menuMonAn[14].nguyenLieu[0].tenNguyenLieu = "Thịt bò";
    menuMonAn[14].nguyenLieu[0].soLuong = 150;
    menuMonAn[14].nguyenLieu[1].tenNguyenLieu = "Rau cải";
    menuMonAn[14].nguyenLieu[1].soLuong = 100;
    menuMonAn[14].nguyenLieu[2].tenNguyenLieu = "Gạo";
    menuMonAn[14].nguyenLieu[2].soLuong = 200;
    menuMonAn[14].nguyenLieu[3].tenNguyenLieu = "Trứng";
    menuMonAn[14].nguyenLieu[3].soLuong = 50;

    // Khởi tạo thông tin cho món 13
    menuMonAn[15].tenMon = "Lasagna - Ý";
    menuMonAn[15].maMon = 16;
    menuMonAn[15].soNguyenLieu = 3;
    menuMonAn[15].nguyenLieu = new NguyenLieu[3];
    menuMonAn[15].nguyenLieu[0].tenNguyenLieu = "Thịt bò";
    menuMonAn[15].nguyenLieu[0].soLuong = 200;
    menuMonAn[15].nguyenLieu[1].tenNguyenLieu = "Sốt cà chua";
    menuMonAn[15].nguyenLieu[1].soLuong = 150;
    menuMonAn[15].nguyenLieu[2].tenNguyenLieu = "Mozzarella";
    menuMonAn[15].nguyenLieu[2].soLuong = 100;

    // Khởi tạo thông tin cho món 14
    menuMonAn[16].tenMon = "Lẩu Thái - Mê Cung Hương Vị";
    menuMonAn[16].maMon = 17;
    menuMonAn[16].soNguyenLieu = 4;
    menuMonAn[16].nguyenLieu = new NguyenLieu[4];
    menuMonAn[16].nguyenLieu[0].tenNguyenLieu = "Thịt heo";
    menuMonAn[16].nguyenLieu[0].soLuong = 300;
    menuMonAn[16].nguyenLieu[1].tenNguyenLieu = "Tôm";
    menuMonAn[16].nguyenLieu[1].soLuong = 200;
    menuMonAn[16].nguyenLieu[2].tenNguyenLieu = "Nấm";
    menuMonAn[16].nguyenLieu[2].soLuong = 100;
    menuMonAn[16].nguyenLieu[3].tenNguyenLieu = "Rau cải";
    menuMonAn[16].nguyenLieu[3].soLuong = 150;

    // Khởi tạo thông tin cho món 15
    menuMonAn[17].tenMon = "Gỏi cuốn - Việt Nam";
    menuMonAn[17].maMon = 18;
    menuMonAn[17].soNguyenLieu = 3;
    menuMonAn[17].nguyenLieu = new NguyenLieu[3];
    menuMonAn[17].nguyenLieu[0].tenNguyenLieu = "Tôm";
    menuMonAn[17].nguyenLieu[0].soLuong = 200;
    menuMonAn[17].nguyenLieu[1].tenNguyenLieu = "Bún";
    menuMonAn[17].nguyenLieu[1].soLuong = 150;
    menuMonAn[17].nguyenLieu[2].tenNguyenLieu = "Rau sống";
    menuMonAn[17].nguyenLieu[2].soLuong = 100;

    // Khởi tạo thông tin cho món 16
    menuMonAn[18].tenMon = "Cà ri - Món ăn không thể thiếu của người dân Ấn Độ";
    menuMonAn[18].maMon = 19;
    menuMonAn[18].soNguyenLieu = 4;
    menuMonAn[18].nguyenLieu = new NguyenLieu[4];
    menuMonAn[18].nguyenLieu[0].tenNguyenLieu = "Thịt gà";
    menuMonAn[18].nguyenLieu[0].soLuong = 300;
    menuMonAn[18].nguyenLieu[1].tenNguyenLieu = "Cà rốt";
    menuMonAn[18].nguyenLieu[1].soLuong = 200;
    menuMonAn[18].nguyenLieu[2].tenNguyenLieu = "Nước dừa";
    menuMonAn[18].nguyenLieu[2].soLuong = 150;
    menuMonAn[18].nguyenLieu[3].tenNguyenLieu = "Cà ri gia vị";
    menuMonAn[18].nguyenLieu[3].soLuong = 100;

    // Khởi tạo thông tin cho món 17
    menuMonAn[19].tenMon = "Cháo ếch Singapore";
    menuMonAn[19].maMon = 20;
    menuMonAn[19].soNguyenLieu = 3;
    menuMonAn[19].nguyenLieu = new NguyenLieu[3];
    menuMonAn[19].nguyenLieu[0].tenNguyenLieu = "Ốc ếch";
    menuMonAn[19].nguyenLieu[0].soLuong = 400;
    menuMonAn[19].nguyenLieu[1].tenNguyenLieu = "Gạo nếp";
    menuMonAn[19].nguyenLieu[1].soLuong = 300;
    menuMonAn[19].nguyenLieu[2].tenNguyenLieu = "Gừng";
    menuMonAn[19].nguyenLieu[2].soLuong = 50;

    // Khởi tạo thông tin cho món 18
    menuMonAn[20].tenMon = "Coxinhas - Một trong những biểu tượng ẩm thực đường phố của Brazil";
    menuMonAn[20].maMon = 21;
    menuMonAn[20].soNguyenLieu = 3;
    menuMonAn[20].nguyenLieu = new NguyenLieu[3];
    menuMonAn[20].nguyenLieu[0].tenNguyenLieu = "Thịt gà";
    menuMonAn[20].nguyenLieu[0].soLuong = 300;
    menuMonAn[20].nguyenLieu[1].tenNguyenLieu = "Bột mì";
    menuMonAn[20].nguyenLieu[1].soLuong = 200;
    menuMonAn[20].nguyenLieu[2].tenNguyenLieu = "Hành tây";
    menuMonAn[20].nguyenLieu[2].soLuong = 50;

    // Khởi tạo thông tin cho món 19
    menuMonAn[21].tenMon = "Bánh Macaron - Hương vị tinh tế của ẩm thực Pháp";
    menuMonAn[21].maMon = 22;
    menuMonAn[21].soNguyenLieu = 2;
    menuMonAn[21].nguyenLieu = new NguyenLieu[2];
    menuMonAn[21].nguyenLieu[0].tenNguyenLieu = "Bột hạt hạnh nhân";
    menuMonAn[21].nguyenLieu[0].soLuong = 100;
    menuMonAn[21].nguyenLieu[1].tenNguyenLieu = "Đường bột";
    menuMonAn[21].nguyenLieu[1].soLuong = 100;

    // Khởi tạo thông tin cho món 20
    menuMonAn[22].tenMon = "Súp hành tây - Hương vị truyền thống của Pháp";
    menuMonAn[22].maMon = 23;
    menuMonAn[22].soNguyenLieu = 2;
    menuMonAn[22].nguyenLieu = new NguyenLieu[2];
    menuMonAn[22].nguyenLieu[0].tenNguyenLieu = "Hành tây";
    menuMonAn[22].nguyenLieu[0].soLuong = 200;
    menuMonAn[22].nguyenLieu[1].tenNguyenLieu = "Nước dùng";
    menuMonAn[22].nguyenLieu[1].soLuong = 300;


    soMonAn = 23; // Số lượng món ăn đã thêm mới

    int chiPhiNgay[MAX_NGAY] = {0}; // Mảng lưu chi phí của mỗi ngày
    int soNgay = 0; // Số lượng ngày đã nhập chi phí

    int luaChon;
    do {
        cout << "===== Quản lý nhà hàng =====\n";
        cout << "1. Hiển thị menu món ăn\n";
        cout << "2. Thêm một món ăn mới\n";
        cout << "3. Tìm một món ăn theo mã\n";
        cout << "4. Nhập chi phí cho một ngày\n";
        cout << "5. Hiển thị tổng chi phí của tất cả các ngày\n";
        cout << "0. Thoát\n";
        cout << "Nhập lựa chọn của bạn: ";
        cin >> luaChon;

        switch (luaChon) {
            case 1:
                hienThiMenuMonAn();
                break;
            case 2:
                nhapMonAn();
                break;
            case 3:
                timMonAnTheoMa();
                break;
            case 4:
                int chiPhi;
                cout << "Nhập chi phí cho ngày " << soNgay + 1 << ": ";
                cin >> chiPhi;
                chiPhiNgay[soNgay] = chiPhi;
                soNgay++;
                break;
            case 5:
                cout << "Tổng chi phí của tất cả các ngày là: " << tinhTongChiPhi(chiPhiNgay, soNgay) << endl;
                break;
            case 0:
                cout << "Cảm ơn bạn đã sử dụng chương trình.\n";
                break;
            default:
                cout << "Lựa chọn không hợp lệ. Vui lòng chọn lại.\n";
                break;
        }
    } while (luaChon != 0);

    return 0;
}
