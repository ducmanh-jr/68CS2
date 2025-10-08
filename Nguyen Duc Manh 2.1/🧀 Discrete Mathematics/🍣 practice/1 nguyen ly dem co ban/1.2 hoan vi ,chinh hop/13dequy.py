# từ 0 1 hay viêt bao nhiêu hoans vị có 3 kí tự 
def binary_strs(n):
    if n==1:
        return['0','1']
    A = []
    for s in binary_strs(n-1):
        A.append('0'+s)
    for s in binary_strs(n-1):
        A.append('1'+s)
        return A
print (binary_strs(3))

import itertools
print(list(itertools.product([0,1],repeat=3 )))


