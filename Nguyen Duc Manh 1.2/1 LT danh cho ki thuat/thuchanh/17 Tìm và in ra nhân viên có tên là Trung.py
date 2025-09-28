
# Tạo danh sách nhân viên với tên và mã nhân viên
def tao_danh_sach_nhan_vien(n):
    danh_sach_nhan_vien = []
    for i in range(n):
        ten_nhan_vien = input(f"Nhập tên nhân viên thứ {i+1}: ")
        ma_nhan_vien = input(f"Nhập mã nhân viên cho {ten_nhan_vien}: ")
        nhan_vien = {"Tên": ten_nhan_vien, "Mã nhân viên": ma_nhan_vien}
        danh_sach_nhan_vien.append(nhan_vien)
    return danh_sach_nhan_vien

# Tìm và in ra nhân viên có tên là "Trung"
def tim_nhan_vien_theo_ten(danh_sach_nhan_vien, ten):
    nhan_vien_tim_thay = [nhan_vien for nhan_vien in danh_sach_nhan_vien if nhan_vien["Tên"] == ten]
    return nhan_vien_tim_thay

# Nhập số lượng nhân viên
n = 10
nhan_vien = tao_danh_sach_nhan_vien(n)

# Tìm và in ra nhân viên có tên là "Trung"
nhan_vien_trung = tim_nhan_vien_theo_ten(nhan_vien, "Trung")
if nhan_vien_trung:
    print("Nhân viên có tên Trung:")
    for nhan_vien in nhan_vien_trung:
        print(f'Tên: {nhan_vien["Tên"]}, Mã nhân viên: {nhan_vien["Mã nhân viên"]}')
else:
    print("Không có nhân viên nào có tên Trung trong danh sách.")
