'''Một số sinh viên không biết đá banh.
∃x¬P(x)
Không có sinh viên nào biết đá banh.
¬∃xP(x)hoặc∀x¬P(x)
Có một và chỉ một sinh viên biết đá banh.
∃x(P(x)∧∀y(P(y)→y=x))


Cho L(x,y) là “x yêu y”, trong đó x, y thuộc tập tất cả mọi người trên thế giới. Biểu diễn theo L(x,y):
Dưới đây là cách biểu diễn các câu theo ký hiệu logic dựa trên biểu thức L(x,y) ("x yêu y"):
Mọi người đều yêu Kaka.
∀xL(x,Kaka)
Mọi người đều yêu một ai đó.
∀x∃yL(x,y)
Mọi người đều yêu một ai đó không phải là chính mình.
∀x∃y(L(x,y)∧y khác x)
Không có ai yêu tất cả mọi người.
¬∃x∀yL(x,y)
'''

"""1 passwold gồm 10 ký tự từ 26 ký tự tiếng Anh và 10 chữ số nếu: """
# Kí tự đầu là 1 số lẻ, kí tự cuối là 1 số chẵn
# 5*5*36 mũ 8 
n= 5*5*36**8 
print(n)