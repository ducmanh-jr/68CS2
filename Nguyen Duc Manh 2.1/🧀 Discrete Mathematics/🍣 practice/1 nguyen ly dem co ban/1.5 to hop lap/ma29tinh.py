def combinations_with_replacement(a,r):
    n =len(a)
    if n==1 :
        return [a*r]
    if r==1 :
        return [[i] for i in a ]
    
    C=[]
    for c in combinations_with_replacement( a, r-1):
        c=[a[0]]+c
        C.append(c)
    for c in combinations_with_replacement(a[1:],r):
        c.append
    return C
print((combinations_with_replacement(['a','b','c'],4)))

# xay dung bai toan nho thanh nghiem bai toan lon
import itertools
print(len(list(itertools.combinations_with_replacement(['a','b','c'],4))))# 15