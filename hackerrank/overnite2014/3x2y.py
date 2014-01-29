def f(x,y):
    if x == 0 and y == 0:
        return 0
    m = x%3
    n = y%2
    xx = x/3
    yy = y/2
    if (m == 0 and n == 0) or (m==2 and n==0):
        return f(xx,yy)
    if (m == 1 and n == 0) or (m == 0 and n == 1) or (m==2 and n==1):
        return 1+f(xx,yy)
    if (m == 1 and n == 1):
        return 2 + f(xx,yy)
    assert(False)

T = int(raw_input())
for _ in xrange(T):
    x,y = map(int,raw_input().split())
    print f(x,y)
