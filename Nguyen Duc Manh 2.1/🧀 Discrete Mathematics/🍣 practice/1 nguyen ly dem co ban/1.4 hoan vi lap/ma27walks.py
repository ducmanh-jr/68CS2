def walks(a, b, x, y):
    # Base cases
    if a == x:
        return ['U' * (y - b)]
    if b == y:
        return ['R' * (x - a)]
    
    # Recursive case
    W = []
    
    # Move right
    for w in walks(a + 1, b, x, y):
        W.append('R' + w)
    
    # Move up
    for w in walks(a, b + 1, x, y):
        W.append('U' + w)
    
    return W

# Example usage
print(walks(0, 0, 2, 2))
