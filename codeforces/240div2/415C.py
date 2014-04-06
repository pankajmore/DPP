from math import *
n,k = map(int,raw_input().split())
t = k - n/2 + 1
if n == 1:
    if k == 0:
        print 1
    else:
        print -1
    exit(0)
if t <= 0:
    print -1
    exit(0)
A = []
A.append(t)
A.append(2*t)
A.extend([2*t+1+i for i in xrange(n-2)])
#print A
assert(len(A)==n)
assert(A[n-1] <= pow(10,9))
print " ".join(map(str,A))
