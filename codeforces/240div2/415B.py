from math import *
n,a,b = map(int,raw_input().split())
A = map(int,raw_input().split())
B = [0]*n
for i in xrange(n):
    k = (A[i]*a)//b;
    B[i] = A[i] - int(ceil((k * b)/float(a)));
print " ".join(map(str,B))
