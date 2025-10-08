#trình bày chỉnh hợp 

# lập trình 
def   permutations(a,r):
    if r ==1 :
        return [[i] for i in a ]# nếu r=1 thì trả về a and có dạng a = [[2],[4],[5]]
    P = []
    n=len(a) 
    for i in range (n): # i chạy 1 đến 4 , nếu i = 2 
        b=a.copy() 
        x=b.pop(i) # bỏ đi phần tử i 
        for p in permutations(b,r-1): # r dạng số nguyên 
            p=[x]+p 
            P.append(p)
    return P
manh = (permutations([1,2,3,4],3))
for lananh in manh:
    print(lananh)

# thư viện 
import itertools
print(list(itertools.permutations([1,2,3,4],3)))
