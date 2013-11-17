a = [1]*61
for i in xrange(1,61):
    a[i] = a[i-1]+1 if i%2==0 else 2*a[i-1]

T = int(raw_input())
for i in xrange(T):
    x = int(raw_input())
    print a[x]
