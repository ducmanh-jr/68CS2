def thap(n,a,b,c):
    def di(n,a,b,c,buoc):
        if n==1:
            buoc += 1
            print(f" di chuyen tu cot {a} sang cot {b}")
        else:
            buoc=di(n-1,a,c,b,buoc)
            buoc += 1
            print(f" di chuyen tu cot {a} sang cot {b}")
            buoc=di(n-1,c,b,a,buoc)
        return buoc 
    tong = 2**n-1
    print(f"tong vav buoc can thuc hien {tong}")
    di(n,a,b,c,0)
n=3
thap(n,'A','B','C')