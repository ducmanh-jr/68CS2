import math

def giai_phuong_trinh_bac_hai(a, b, c):
    # Tính delta
    delta = b**2 - 4*a*c
    
    # Nếu delta âm, phương trình không có nghiệm thực
    if delta < 0:
        return None, None
    elif delta == 0:
        # Nếu delta bằng 0, phương trình có nghiệm kép
        x = -b / (2*a)
        return x, None
    else:
        # Nếu delta dương, phương trình có hai nghiệm
        x1 = (-b + math.sqrt(delta)) / (2*a)
        x2 = (-b - math.sqrt(delta)) / (2*a)
        return x1, x2

def nhap_a_b_c():
    a = float(input("Nhập hệ số a: "))
    b = float(input("Nhập hệ số b: "))
    c = float(input("Nhập hằng số tự do c: "))
    return a, b, c

def main():
    while True:
        print("\n-- Giải phương trình bậc hai ax^2 + bx + c = 0 --")
        a, b, c = nhap_a_b_c()
        
        # Gọi hàm giải phương trình bậc hai
        nghiem1, nghiem2 = giai_phuong_trinh_bac_hai(a, b, c)
        
        if nghiem1 is None:
            print("Phương trình không có nghiệm thực. Vui lòng nhập lại.")
        else:
            if nghiem2 is None:
                print("Phương trình có một nghiệm:")
                print("x =", nghiem1)
            else:
                print("Phương trình có hai nghiệm:")
                print("x1 =", nghiem1)
                print("x2 =", nghiem2)
            break

if __name__ == "__main__":
    main()
