from sympy import *
# Khai báo các biến ký hiệu
n, i = symbols('n i')

# Tính tổng của dãy số từ 1 đến n
sum_expression = Sum(i, (i, 1, n)).doit().simplify()

# In ra kết quả
print(f"Tổng của các số từ 1 đến {n}: {sum_expression}")


