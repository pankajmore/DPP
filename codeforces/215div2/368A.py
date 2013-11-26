def profit(n,d,a,m):
    a.sort()
    s = 0
    for i in xrange(min(m,n)):
        s+=a[i]
    if m <= n:
        return s
    else:
        return (s-(m-n)*d)

n,d = map(int,raw_input().split())
a = map(int,raw_input().split())
m = int(raw_input())
print profit(n,d,a,m)
