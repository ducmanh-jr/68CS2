def thap(n, a, c, b):
    def dich(n, a, c, b, buoc):
        if n == 1:
            buoc += 1
            print(f"buoc {buoc} dich chuyen cot {a} sang cot {c}")
        else:
            dich(n - 1, a, b, c, buoc)
            buoc += 1
            print(f"buoc {buoc} dich chuyen cot {a} sang cot {c}")
            dich(n - 1, b, c, a, buoc)
        return buoc
    # Sử dụng danh sách để lưu trữ giá trị của buoc
    tong = 2 ** n - 1
    print(f"tong cac buoc can thuc hien {tong}")
    dich(n, a, c, b, 0)

n = 3
thap(n, 'A', 'B', 'C')
