class SV :
    def __init__(self,z1,z2,z3):
        self.z1=z1
        self.z2=z2
        self.z3=z3
    def showin4(self):
        print("ho va ten   ", self.z1)
        print("lop",self.z2)
        print("gioi tinh",self.z3)
ds_SV = []
sosv = int(input("nhap so luong sinh vien  "))
for SV in range(sosv):
    z1=input("nhap ten sinh vien  ")
    z2=input("lop")
    z3=input("gioi tinh ")
    SV =SV (z1,z2,z3)
    ds_SV.append(SV)
for SV in ds_SV:
    SV.showin4()
for SV in ds_SV:
    if SV .z3 == "nam":
        print ("sinh vien gioi tinh nam ",SV.z1)
for SV in ds_SV:
    count=0
    if SV.z1=="cuong":
        count=count+1
        print("so sinh vien ten cuong")
