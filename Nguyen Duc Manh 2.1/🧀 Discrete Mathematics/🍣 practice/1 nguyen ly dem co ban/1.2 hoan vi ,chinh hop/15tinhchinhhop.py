# tính chỉnh hợp 

# lập trình 
def P(n,r):
    P=1
    for i in range(r):
        P *= n-i 
    return P
print(P(8,5))

# thư viện 
from sympy import *
n,r=8,5
print(factorial(n)/factorial(n-r))
