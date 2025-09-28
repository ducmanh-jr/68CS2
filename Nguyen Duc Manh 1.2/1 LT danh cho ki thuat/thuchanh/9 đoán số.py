


import random                                                            # tên

def guessing_name():                                                     # khai báo hàm                  # m1 = answer đoán số
    m1 = random.randint(0, 10)                                                                           # s1 = remaining_guess lượt đoán                                 
    s1 = 3

    
    while True:                                                          # vòng lặp 
        s1 -= 1                                                                                                                      
        
        try:
            x1 = int(input("Người chơi 1 đoán số: "))                                                     # x1 = người chs 1 
        except ValueError:
            print("Vui lòng nhập một số nguyên.")
            continue
        if x1 == m1:
            print("Bạn đã đoán trúng và người 1 là người thắng cuộc.")
            break
        else:
            print("Bạn đã đoán sai, đến lượt người chơi 2.")
        try:
            x2 = int(input("Người chơi 2 đoán số: "))                                                      # x2 = người chs 2 
        except ValueError:
            print("Vui lòng nhập một số nguyên.")
            continue
        if x2 == m1:
            print("Bạn đã đoán trúng và người 2 là người thắng cuộc.")
            break
        else:
            print("Bạn đã đoán sai, đến lượt người chơi 1.")
        
        
        if s1 <= 0:                                                        # kết quả 
            print("Số lượt đoán đã hết. Đáp án là:", m1)
            break
        if   x1 == m1 or x2 == m1:
            print ("Bạn đoán chính xác")
        elif   x1 < m1 or x2 < m1:
            print ("Quá thấp")
        elif  x1 > m1 or x2 > m1: 
            print ("Quá cao")
            
            
guessing_name()                                                            # kết thúc
