# Khởi tạo ma trận A và B
A = [[1, 2, 3],
     [2, 3, 4]]

B = [[2, 3],
     [3, 4],
     [4, 5]]

# Hàm nhân ma trận A và B
def matrix_mul(A, B):
    m, n = len(A), len(A)  # Số dòng của A và số cột của A
    p = len(B[0])             # Số cột của B
    
    # Khởi tạo ma trận kết quả C với kích thước mxp và gán giá trị ban đầu là 0
    c = [[0 for j in range(p)] for i in range(m)]
    
    # Thực hiện nhân ma trận
    for i in range(m):
        for j in range(p):
            for k in range(n):
                c[i][j] += A[i][k] * B[k][j]
    return c

# Gọi hàm và in kết quả
ket_qua = matrix_mul(A, B)
print("Kết quả nhân ma trận tự viết:")
for row in ket_qua:
    print(row)

# Kiểm tra lại bằng hàm dot của numpy
import numpy as np 
ket_qua_np = np.dot(A, B)
print("\nKết quả nhân ma trận bằng numpy:")
print(ket_qua_np)
