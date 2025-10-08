def binary_arrays(n):
    # Base case: when n is 1, return all binary arrays of length 1
    if n == 1:
        return [[True], [False]]
    
    A = []
    
    # Recursive case: build arrays of length n from arrays of length n-1
    for a in binary_arrays(n - 1):
        A.append([True] + a)  # Prepend True to each array of length n-1
        A.append([False] + a) # Prepend False to each array of length n-1
    
    return A

# Example usage
print(binary_arrays(2))

from sympy import *
p, q, r = symbols( 'p q r ')
P = p >> (~q & r) | False
for p_, q_, r_ in binary_arrays(3):
    print(p_, q_, r_, P.subs({p: p_, q: q_, r: r_}))