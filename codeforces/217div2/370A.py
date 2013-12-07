r1,c1,r2,c2 = map(int,raw_input().split())
if r1==r2 or c1==c2:
    rook = 1
else:
    rook = 2
if (r1+c1)%2 != (r2+c2)%2:
    bishop = 0
else:
    if abs(r1-r2)==abs(c1-c2):
        bishop = 1
    else:
        bishop = 2
king = max(abs(r1-r2),abs(c1-c2))
print "{0} {1} {2}".format(rook,bishop,king)
