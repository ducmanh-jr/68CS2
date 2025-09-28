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
    
    tong_buoc = (1 << n) - 1
    
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    
    di_chuyen(n, nguon, dich, trung_gian)

n = 15
thap_ha_noi_nhanh_nhat(n, 'A', 'C', 'B')
