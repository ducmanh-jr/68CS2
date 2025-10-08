def thap_ha_noi_nhanh_nhat(n, nguon, dich, trung_gian):
    def di_chuyen(n, nguon, dich, trung_gian):
        if n == 1:
            print(f"Di chuyển đĩa 1 từ cột {nguon} sang cột {dich}")
        else:
            di_chuyen(n - 1, nguon, trung_gian, dich)
            print(f"Di chuyển đĩa {n} từ cột {nguon} sang cột {dich}")
            di_chuyen(n - 1, trung_gian, dich, nguon)
    
    tong_buoc = 2**n - 1
    
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    
    di_chuyen(n, nguon, dich, trung_gian)

n = 15
thap_ha_noi_nhanh_nhat(n, 'A', 'C', 'B')
