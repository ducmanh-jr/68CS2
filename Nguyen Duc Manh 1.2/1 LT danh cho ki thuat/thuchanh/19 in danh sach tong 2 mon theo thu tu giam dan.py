class sv :
    def __init__(self,hoten,lop,diemtoan,diemtin):
        self.hoten=hoten
        self.lop=lop
        self.diemtoan=diemtoan
        self.diemtin=diemtin
        self.tongdiem=diemtoan+diemtin

# danh sachs lop
danhsach =[]
while True :
    hoten=input("nhap ho va ten(nhap 'p' de dung ):")
    if hoten.lower()== 'p':
        break 
    lop=input("nhap ten lop ")
    diemtoan=float(input("nhap diem mon toan  "))
    diemtin=float(input("nhap diem mon tin"))
    sinhvien=sv(hoten,lop,diemtoan,diemtin)
    danhsach.append(sinhvien)
# toan cao nhat 
toanmax = max(sinhvien.diemtoan for sinhvien in danhsach)
print("cac sinh vien co diem toan cao nhat ")
for sinhvien in danhsach:
    if sinhvien.diemtoan == toanmax:
        print(sinhvien.hoten)
        print(sinhvien.lop)
#tong 2 thaps nhat
tongmin = min(sinhvien.tongdiem for sinhvien in danhsach)
print("cac sinh vien co tong thap nhat ")
for sinhvien in danhsach:
    if sinhvien.tongdiem == tongmin:
        print(sinhvien.hoten)
        print(sinhvien.lop)
# in danh sach tong 2 mo theo thu tu giam dan
danhsach.sort(key=lambda x:x.tongdiem,reverse= True)
print("")
for sinhvien in danhsach:
    print(f"{sinhvien.hoten}- tong diem : {sinhvien.tongdiem}")