import ttg

# Mệnh đề a: (p ∨ q) → (p ∧ ¬r)
aa = ttg.Truths(
    ['p', 'q', 'r'],
    ['p or q',
    ' ~r',
    'p and ~r',
    
    '(p or q) => (p and ~r)']
).as_pandas
print(" bang chan ly cua menh de a ")
print(aa)


