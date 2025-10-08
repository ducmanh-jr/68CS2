

from sympy import *
print(binomial(10,4))

def binomial(n,r):# nhi thuc 
    p=1
    for i in range(r):
        p  = p * (n-i)// (i+1)
    return p
print(binomial(10,4))
