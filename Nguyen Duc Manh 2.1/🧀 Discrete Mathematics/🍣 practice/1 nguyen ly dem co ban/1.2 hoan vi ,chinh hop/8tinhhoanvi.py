#  tính hoán vị ( n! )

# c1 lập trình 
def factorial(n):
    p=1 # bat dau voi 1 
    for i in range(1,n+1):# cho i chay tu 1 den n 
        p*=i # n=4 thi la 4*3*2*1 _ 1 1*2 2*3 6*4
    return p 

print(factorial(4))

# c2 lập trình 
def factorial(n):
    if n==0:
        return 1 
    return n*factorial(n-1)# nhan den khi n=1 va n=0 tra ve 1 
print(factorial(4))

# c3 dung sympy
from sympy import *
print(factorial(4))