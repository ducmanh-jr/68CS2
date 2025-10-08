from sympy import *
p, q, r, s, t, u = symbols( 'p q r s t u' )
P = (p >> q) & (q>> r & s) 
P = (p>>q) & (q >> r & s ) & (~r | ~t | u ) & ( p & t )
print(P.simplify())