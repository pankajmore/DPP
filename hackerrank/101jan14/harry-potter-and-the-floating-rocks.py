def gcd(a,b):
    if b==0:
        return a
    return gcd(b,a%b)

T = int(raw_input())
for _ in xrange(T):
    x1,y1,x2,y2 = map(int,raw_input().split())
    n = abs(y2-y1)
    m = abs(x2-x1)
    g = gcd(n,m)
    m /= g
    if x1==x2 and y1==y2:
        print 0
    elif abs(x2-x1) == 0:
        print abs(y2-y1)-1
    elif abs(y2-y1)== 0:
        print abs(x2-x1)-1
    else:
        print (abs(x2-x1)-1)/m
