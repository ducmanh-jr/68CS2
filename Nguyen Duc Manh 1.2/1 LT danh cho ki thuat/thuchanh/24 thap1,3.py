def thap(n,a,c,b):
    def dich(n,a,c,b,buoc):
        """if num >= 0:
                print("So duong hoac bang 0")
            else:
                print("So am")"""
        """x = int(input("Nhap mot so: "))
            if x < 0:
                print('So am')
            elif x == 0:
                print('So 0')
            elif x == 1:
                print('So 1')
            else:
                print('So duong')"""
        if n==1:
            """ buoc += 1 được sử dụng để tăng giá trị của biến buoc lên mỗi khi 
            một bước thực hiện của thuật toán được thực hiện. Biến buoc được sử 
            dụng để theo dõi số bước thực hiện trong quá trình di chuyển đĩa trong 
            vấn đề tháp Hà Nội."""
            buoc += 1
            """nếu chúng ta đang xử lý một đĩa duy nhất ( n == 1),đã di chuyển hết xuất phát sang cột đích. Ở trạng thái này, 
            chúng ta cần thực hiện một bước di chuyển cuối cùng để di chuyển đĩa cuối cùng từ cột xuất phát sang cột đích.
            Do đó, trong trường hợp này, biến buoc (đã được truyền vào từ hàm gọi) được tăng lên 1 đơn vị (buoc += 1).
            Sau đó, thông điệp được in ra với số bước hiện tại và hành động di chuyển tương ứng. Điều này giúp hiển thị 
            các bước di chuyển cụ thể của thuật toán khi giải quyết bài toán tháp Hà Nội."""
            print(f"buoc {buoc} dich chuyen {a} sang {c}")
            """đây là bước cuối cùng"""
        else:# khi n không bằng 1, tức là khi còn nhiều hơn một đĩa cần di chuyển.
            """Trong trường hợp này, chúng ta muốn thực hiện các bước sau đây:

            Di chuyển n-1 đĩa từ cột xuất phát a sang cột trung gian b.
            Di chuyển đĩa cuối cùng từ cột xuất phát a sang cột đích c.
            Di chuyển n-1 đĩa từ cột trung gian b (đã được di chuyển sang cột đích c) sang cột đích c, sử dụng cột xuất phát a làm cột trung gian.
            Do đó, chúng ta gọi đệ quy hàm dich với n-1 để di chuyển các 
            đĩa từ cột a sang cột b, trong đó a là cột xuất phát, b là cột trung gian, và c là cột đích. Khi đó, biến buoc được truyền vào 
            hàm đệ quy và được sử dụng để theo dõi số bước di chuyển đã thực hiện."""
            buoc = dich(n-1,a,b,c,buoc)
            buoc += 1
            print(f"buoc {buoc} dich chuyen cot {a} sang cot {c}")
            buoc = dich(n-1,b,c,a,buoc)
            return buoc
    tong = 2**n -1
    print(f"tong cac buoc can thuc hien {tong}")
    dich(n,a,c,b,0)
n=5
thap(n,'A','B','C')        