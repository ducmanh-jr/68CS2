
def thap_ha_noi_nhanh_nhat(n, nguon, dich, trung_gian):
    tong_buoc = 2**n - 1
    
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    
    if n % 2 == 0:
        trung_gian, dich = dich, trung_gian
        
    for i in range(1, tong_buoc + 1):
        if i % 3 == 1:
            print(f"Bước {i}: Di chuyển đĩa 1 từ cột {nguon} sang cột {dich}")
        elif i % 3 == 2:
            print(f"Bước {i}: Di chuyển đĩa {n} từ cột {nguon} sang cột {trung_gian}")
        elif i % 3 == 0:
            print(f"Bước {i}: Di chuyển đĩa {n} từ cột {trung_gian} sang cột {dich}")
n = 5
thap_ha_noi_nhanh_nhat(n, 'A', 'C', 'B')

# bài toán tháp hà nội
def thap_ha_noi(n, a, b, c):# nguồn , dịch và trung gian
    if n == 1:
        print("Di chuyển đĩa 1 từ cột", a, "đến cột", b)
        return
    thap_ha_noi(n-1, a, c, b)
    print("Di chuyển đĩa", n, "từ cột", a, "đến cột", b)
    thap_ha_noi(n-1, c, b, a)

n = 5
thap_ha_noi(n, 'A', 'B', 'C')
