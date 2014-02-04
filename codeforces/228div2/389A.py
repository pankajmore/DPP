def gcd(a,b):
    if b==0:
        return a
    else:
        return gcd(b,a%b)

N = int(raw_input())
A = map(int,raw_input().split())
g = max(A)
for i in xrange(N):
    g = gcd(g,A[i])
print g*N
