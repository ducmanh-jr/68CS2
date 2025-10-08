import ttg
aa = ttg.Truths(
    [ 'p' , 'q' , 'r' ],
    [' p => ( ~q and r ) or False ']
).as_pandas
print(aa)

    