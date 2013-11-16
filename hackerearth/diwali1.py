import sys
def diwali(s,n,g,f):
    m = max(s.keys())
    mm = - sys.maxint
    a = [0]*(m+1)
    for i in xrange(m,-1,-1):
        if s.has_key(i) and s[i]>mm:
            a[i] = s[i]
            mm = s[i]
        else:
            a[i] = mm
    c = 0
    for j in f:
        if a[j] >= j:
            c += a[j]//j
    return (c*100)

s = dict()
n = int(raw_input())
for i in xrange(n):
    y,z = map(int,raw_input().split())
    s[y]=z
g = int(raw_input())
f = [int(raw_input()) for _ in xrange(g)]
print diwali(s,n,g,f)
