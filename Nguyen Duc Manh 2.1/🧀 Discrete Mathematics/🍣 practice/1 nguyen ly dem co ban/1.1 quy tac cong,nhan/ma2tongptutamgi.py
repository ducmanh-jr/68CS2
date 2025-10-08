#  quy tắc tính tổng số phần tử trong một tam giác
# 1
# 1 2
# 1 2 3
# 1 2 3 4
n=4
counter = 0

for i in range (1,n+1):# i chạy từ 1 đến 4
    for j in range (1,i+1):#cứ 1 i 1 j , 2i thì 2j
        counter += 1 # vậy sẽ có 1+2+3+4
        #print (counter ,i,j)
#print(counter)

n = 4
for i in range(1, n + 1):
    for j in range(1, i + 1):
        print(j,end='')
    print()  # Chuyển dòng sau mỗi hàng
# 1
# 1 2
# 1 2 3
# 1 2 3 4


