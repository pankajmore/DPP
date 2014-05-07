T = int(raw_input())
for _ in xrange(T):
    n,a,b = [int(raw_input()) for _ in xrange(3)]
    A = [(n-x-1)*a + x*b for x in xrange(n)]
    A = list(set(A))
    A.sort()
    print " ".join(map(str,A))
