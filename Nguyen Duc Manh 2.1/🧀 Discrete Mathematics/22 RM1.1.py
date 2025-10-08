

def thap(n, a, b, c):
    # Hàm di thực hiện giải thuật tháp Hà Nội để di chuyển n đĩa từ cột a sang cột b, sử dụng cột trung gian c
    def di(n, a, b, c, buoc):
        if n == 1:  # Trường hợp cơ bản: chỉ có một đĩa
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa 1 từ cột {a} sang cột {b}")  # Di chuyển đĩa từ cột a sang cột b
        else:
            # Di chuyển n-1 đĩa từ cột a sang cột c, sử dụng cột b làm cột trung gian
            buoc = di(n - 1, a, c, b, buoc)
            buoc += 1
            print(f"Bước {buoc}: Di chuyển đĩa {n} từ cột {a} sang cột {b}")  # Di chuyển đĩa từ cột a sang cột b
            # Di chuyển n-1 đĩa từ cột c sang cột b, sử dụng cột a làm cột trung gian
            buoc = di(n - 1, c, b, a, buoc)
        return buoc
    
    # Tính tổng số bước cần thiết để di chuyển n đĩa từ cột a sang cột b
    tong_buoc = 2**n - 1
    print(f"Tổng số bước cần thiết: {tong_buoc}")
    
    # Gọi hàm di để thực hiện giải thuật tháp Hà Nội
    di(n, a, b, c, 0)

# Số lượng đĩa ban đầu
n = 3

# Gọi hàm thap để giải quyết bài toán
thap(n, 'A', 'C', 'B')

def thap(n,a,b,c):
    def di(n,a,b,c,buoc):
        if n==1 :
            buoc +=1
            print(f"buoc {buoc} : di ch cot {a} sang cot {b}")
        else:
            buoc=di(n-1,a,c,b,buoc)
            buoc += 1
            print(f"buoc {buoc} : di ch cot {a} sang cot {b}")
            buoc=di(n-1,c,b,a,buoc)
        return buoc 
    tong = 2**n-1
    print(f"tong cac buoc {tong}")
    di(n,a,b,c,0)
n=3
thap(n,'A','B','C')

