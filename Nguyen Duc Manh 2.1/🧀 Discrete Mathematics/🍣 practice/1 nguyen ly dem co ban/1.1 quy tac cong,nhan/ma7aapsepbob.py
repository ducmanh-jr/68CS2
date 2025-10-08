# sắp sếp bong bóng 
def bubblesort(x):
    n=len(x)
    for i in range (n-1):
        for j in range (n-1,i,-1):
            if x[j] < x[j-i]:
                x[j-1],x[j]=x[j],x[j-1]

    return x
print(bubblesort([7,9,2,5,8,1]))
#hoạt động bằng cách liên tục so sánh và hoán đổi các cặp phần tử liền kề nếu chúng không theo thứ tự mong muốn