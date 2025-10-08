#c1 lập trình 
def permutations(a):
    n = len(a)
    if n == 1:
        return [a]  # Nếu n = 1, trả về danh sách chứa danh sách a
    P = []
    for i in range(n):
        b = a.copy()  # Tạo b là bản sao của a
        x = b.pop(i)  # Loại bỏ phần tử tại chỉ số i
        for p in permutations(b):  # Đệ quy gọi lại hàm permutations
            p = [x] + p  # Thêm x vào đầu của danh sách p
            P.append(p)  # Thêm hoán vị p vào danh sách P
    return P
a = permutations([3, 4, 5, 6])
for k in a :
    print( k )

#c2 dùng itertools
import itertools
a=(list(itertools.permutations([3,4,5,6])))

# tìm hoán vị thứ 4
print(f"hv{ a[3] }" )

# vậy tìm tổ hợp đứng sau 'a','f'
index = a.index(((3, 5, 6, 4)))
bb = a[index + 1]
print(bb)
