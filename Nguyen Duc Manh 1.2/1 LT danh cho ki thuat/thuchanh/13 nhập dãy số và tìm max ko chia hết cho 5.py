



m = input (" nhập dãy số , cách nhau dáu phẩy : ").split()
m = [int(num) for num in m if int(num)%5!=0]
max_value = max(m)
print("số lớn nhất không chia hết cho 5 :  ",max_value)






