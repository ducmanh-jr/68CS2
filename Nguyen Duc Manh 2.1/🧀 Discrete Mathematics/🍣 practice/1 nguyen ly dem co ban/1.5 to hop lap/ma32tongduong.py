def summands(n):
    # Base case: if n is 1, there is only one way to write it
    if n == 1:
        return [[1]]
    
    S = []
    
    # Iterate through all possible first summands
    for i in range(1, n):
        for s in summands(n - i):
            S.append([i] + s)
    
    # Add the summand consisting of just n itself
    S.append([n])
    
    return S

# Example usage
print(summands(3))


