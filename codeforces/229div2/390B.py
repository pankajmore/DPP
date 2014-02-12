from math import *
N = int(raw_input())
A = map(int,raw_input().split())
B = map(int,raw_input().split())
c = 0
for i in xrange(N):
    if B[i] == 1:
        c -= 1
        continue
    x = floor(B[i]/2.0)
    y = ceil(B[i]/2.0)
    assert(x+y==B[i])
    if A[i] >= y:
        c += x*y
    else:
        c -= 1
print int(c)
