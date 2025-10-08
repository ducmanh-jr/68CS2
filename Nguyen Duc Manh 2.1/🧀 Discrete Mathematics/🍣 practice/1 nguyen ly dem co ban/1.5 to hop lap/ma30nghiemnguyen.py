def nghiem (n,r):
    if n==1:
        return [[r]]
    X = []
    for k in range(r+1):
        for x in nghiem(n-1,r-k):
            x = [k]+x
            X.append(x)

    return X

print(len(nghiem(3,4) ))

for x1 in range(5):
    for x2 in range(5):
        for x3 in range (5):
            if x1+x2+x3 == 4:
                print(len(x1,x2,x3))
    