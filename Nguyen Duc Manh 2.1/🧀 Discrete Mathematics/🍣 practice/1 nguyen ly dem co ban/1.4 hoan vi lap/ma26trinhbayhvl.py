def permutations_with_replacement(a,n):
    r = len (a)
    if sum(n)==0:
        return [[]]
    P=[]
    for i in range(r):
        if n [i]>0:
            nn = n.copy()
            nn[i]-=1
            for p in permutations_with_replacement(a,nn):
                p = [a[i]]+p
                P.append(p)
    return P 
print(permutations_with_replacement(['a','b','c'],[1,11,3]))
len(permutations_with_replacement(['a','b','c'],[1,11,3]))
print(permutations_with_replacement(['a','b','c'],[1,2,3])[9])# hoan vi thu 10 la bao nhieu

