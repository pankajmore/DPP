from math import *
N,X = map(int,raw_input().split())
A = map(int,raw_input().split())
A.sort()
#print A
B = []
F = N
S = 0
for i in xrange(N):
    s = ceil(A[i]/2.0)
    if X-s < 0:
        break
    else:
        X -= s
        F -= 1
        B.append(A[i]-s)
#print B
#print X
for i in B:
    if i <= X:
        S += 1
        X -= i
    else:
        break
print str(F)+" "+str(S)
