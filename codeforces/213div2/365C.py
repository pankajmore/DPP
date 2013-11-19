def matrix(a,k):
    n = len(a)
    s = [0]*n
    c = 0
    for i in xrange(n):
        c+=a[i]
        s[i] = c
    b = []
    d = {}
    #print s
    for i in xrange(n):
        for j in xrange(i,n):
            if i==0:
                b.append(s[j] - 0)
                x = s[j]
            else:
                b.append(s[j]-s[i-1])
                x = s[j] - s[i-1]
            if d.has_key(x):
                d[x] += 1
            else:
                d[x] = 1
    assert(len(b) == n*(n+1)/2)
    count = 0
    m = len(b)
    for i in b:
        if k%i == 0:
            j = k/i
            #print j
            if d.has_key(j):
                count += d[j]
    return count

k = int(raw_input())
a = map(int,raw_input())
print matrix(a,k)
