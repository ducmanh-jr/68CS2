def combinations(a, r):
    if r == 1:
        return [[i] for i in a]
    n = len(a)
    if r == n:
        return [a]
    C = []
    for c in combinations(a[1:], r-1):
        C.append([a[0]] + c)
    for c in combinations(a[1:], r):
        C.append(c)
    return C

# Example usage
(combinations([1, 2, 3, 4, 5], 2))



import itertools
aa=(list( itertools.combinations(['a','b','c','d','e','f'], 2) ))

# tô hợp thứ 4 
print(aa[4])

# vậy tìm tổ hợp đứng sau 'a','f'
index = aa.index(('a', 'f'))
bb = aa[index + 1]
print(bb)

