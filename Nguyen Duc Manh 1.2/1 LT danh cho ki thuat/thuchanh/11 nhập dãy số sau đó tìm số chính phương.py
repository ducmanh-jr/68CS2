import math

def kiem_tra_so_chinh_phuong(n):
    sqrt_n = math.sqrt(n)
    return sqrt_n==int(sqrt_n)

def tim_so_chinh_phuong (arr):
    so_chinh_phuong = []
    for num in arr:f6
    if num >=0 and tim_so_chinh_phuong(num):
            so_chinh_phuong.append(num)
            return so_chinh_phuong
        
    day_so= input ("Nhập dãy số nguyên cách nhau bằng dấu cách:")
    day_so= day_so.split()
    day_so= [int [x] for x in day_so] 
    
    so_chinh_phuong = tim_so_chinh_phuong(day_so)
    print ("Các số chính phương trong dãy số là:" , so_chinh_phuong)