


import random                                                            # tên

def guessing_name():                                                     # khai báo hàm                  # a1 = answer đoán số
    a1 = random.randint(0, 10)                                                                           # b1 = remaining_guess lượt đoán                                 
    b1 = 3

    
    while True:                                                          # vòng lặp 
        b1 -= 1                                                                                                                      
        
        try:
            c1 = int(input("Người chơi 1 đoán số: "))                                                     # c1 = người chs 1 
        except ValueError:
            print("Vui lòng nhập một số nguyên.")
            continue
        if c1 == a1:
            print("Bạn đã đoán trúng và người 1 là người thắng cuộc.")
            break
        else:
            print("Bạn đã đoán sai, đến lượt người chơi 2.")
        try:
            c2 = int(input("Người chơi 2 đoán số: "))                                                      # c2 = người chs 2 
        except ValueError:
            print("Vui lòng nhập một số nguyên.")
            continue
        if c2 == a1:
            print("Bạn đã đoán trúng và người 2 là người thắng cuộc.")
            break
        else:
            print("Bạn đã đoán sai, đến lượt người chơi 1.")
        
        
        if b1 <= 0:                                                        # kết quả 
            print("Số lượt đoán đã hết. Đáp án là:", a1)
            break
        if   c1 == a1 or c2 == a1:
            print ("Bạn đoán chính xác")
        elif   c1 < a1 or c2 < a1:
            print ("Quá thấp")
        elif  c1 > a1 or c2 > a1: 
            print ("Quá cao")
            
            
guessing_name()                                                            # kết thúc
