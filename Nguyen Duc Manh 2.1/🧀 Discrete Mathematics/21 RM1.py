def thap_ha_noi_nhanh_nhat(n, nguon, dich, trung_gian):
    buoc = 0
    
    def di_chuyen(n, nguon, dich, trung_gian):
        nonlocal buoc
        if n == 1:
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa 1 từ cột {nguon} sang cột {dich}")
        else:
            di_chuyen(n - 1, nguon, trung_gian, dich)
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa {n} từ cột {nguon} sang cột {dich}")
            di_chuyen(n - 1, trung_gian, dich, nguon)
    
    tong_buoc = 2**n - 1
    
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    
    di_chuyen(n, nguon, dich, trung_gian)

n = 3
thap_ha_noi_nhanh_nhat(n, 'A', 'C', 'B')

"""Các biến nonlocal được sử dụng trong các hàm lồng nhau 
(inner function). Lúc này, phạm vi cục bộ của biến không 
được xác định. Điều này có nghĩa là biến không thể nằm
trong phạm vi cục bộ hoặc toàn cục. Sử dụng từ khóa
nonlocal để tạo các biến nonlocal"""

def thap_ha_noi_nhanh_nhat(n, nguon, dich, trung_gian):
    def di_chuyen(n, nguon, dich, trung_gian, buoc):
        if n == 1:
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa 1 từ cột {nguon} sang cột {dich}")
        else:
            buoc = di_chuyen(n - 1, nguon, trung_gian, dich, buoc)
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa {n} từ cột {nguon} sang cột {dich}")
            buoc = di_chuyen(n - 1, trung_gian, dich, nguon, buoc)
        return buoc
    
    tong_buoc = 2**n - 1
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    di_chuyen(n, nguon, dich, trung_gian, 0)

n = 3
thap_ha_noi_nhanh_nhat(n, 'A', 'C', 'B')


"""Ở đây, chúng ta đã thêm một tham số buoc vào hàm di_chuyen
 và trả về giá trị buoc sau mỗi lần gọi đệ quy. Điều này giúp 
 hàm di_chuyen duy trì và cập nhật biến buoc mà không cần sử 
 dụng nonlocal hoặc global"""