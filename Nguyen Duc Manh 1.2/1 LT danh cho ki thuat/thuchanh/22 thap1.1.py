def thaphanoi(n, a, c, b):
    def dich(n, a, c, b, buoc):
        if n == 1:
            buoc += 1
            print(f"buoc {buoc} : di chuyen dia 1 tu cot {a} sang cot {c}")
        else:
            buoc = dich(n-1, a, b, c, buoc)
            buoc += 1
            print(f"buoc {buoc} : di chuyen dia {n} tu cot {a} sang cot {c}")
            buoc = dich(n-1, b, c, a, buoc)
        return buoc

    tong = 2**n - 1
    print(f"tong buoc can thuc hien {tong}")
    dich(n, a, c, b, 0)

n = 3
thaphanoi(n, 'cot 1', 'cot 2', 'cot 3')
