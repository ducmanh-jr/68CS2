import math as m
v = (m.sin,m.cos)
for f in v :
    for x in [0,m.pi/2]:
        print ("{}({:.3f}) = {:.3f}".format(f.__name__,x,f(x)))