N = int(raw_input())
K = int(raw_input())
A = [int(raw_input()) for _ in xrange(N)]
A.sort()
#print A
m = A[-1] - A[0]
for i in xrange(N-K+1):
    m = min(m,A[i+K-1]-A[i])
print m
