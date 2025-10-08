def catalan_walks(a, b, n):
    # Base case: if we've reached the end (a == n), complete the path with 'U' moves
    if a == n:
        return ['U' * (n - b)]
    
    W = []

    # Only add right moves if we haven't exceeded the number of up moves
    if a >= b:
        for w in catalan_walks(a + 1, b, n):
            W.append('R' + w)
    
    # Only add up moves if we haven't reached the end yet
    if a > b:
        for w in catalan_walks(a, b + 1, n):
            W.append('U' + w)
    
    return W

# Example usage
print(catalan_walks(0, 0, 3))


from sympy import *
print([binomial(2*n, n) / (n+1) for n in range(11)])