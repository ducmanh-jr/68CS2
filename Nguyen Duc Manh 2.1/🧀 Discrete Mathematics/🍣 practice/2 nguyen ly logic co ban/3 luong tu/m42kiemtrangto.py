def is_prime(n):
    for k in range(2, n):
        if n % k == 0:
            return False
    return True
print(is_prime(7))
# Chức năng is_composite(n) kiểm tra xem một số n có phải là số hợp số hay không.
#  Một số hợp số là số nguyên dương lớn hơn 1 và có ít nhất một ước số khác ngoài 1 và chính nó.
def is_composite(n):
    for k in range(2, n):
        if n % k == 0:
            return True
    return False
print(is_composite(7))