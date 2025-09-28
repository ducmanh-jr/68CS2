def thap(n,a,c,b):
    def dich(n,a,c,b,buoc):
        if n==1 :
            buoc += 1
            print(f"buoc {buoc} dich chuyen cot {a} sang cot {c}")
        else:
            buoc = dich(n-1,a,b,c,buoc)
            buoc += 1
            print(f"buoc {buoc} dich chuyen cot {a} sang cot {c}")
            buoc = dich(n-1,b,c,a,buoc)
        return buoc
    tong = 2**n -1
    print(f"tong cac buoc can thuc hien {tong}")
    dich(n,a,c,b,0)
n=16
thap(n,'A','B','C')        