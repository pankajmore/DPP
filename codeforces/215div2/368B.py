def suffixes(n,m,a,r):
    b = [0]*n
    s = set()
    for i in xrange(n-1,-1,-1):
        s.add(a[i])
        b[i] = len(s)
    for i in xrange(m):
        print b[r[i]-1]

n,m = map(int,raw_input().split())
a = map(int,raw_input().split())
r = [int(raw_input()) for _ in xrange(m)]
suffixes(n,m,a,r)
