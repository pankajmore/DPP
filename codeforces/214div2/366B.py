import sys
def todo(n,k,a):
    m = sys.maxint
    index = -1
    for i in xrange(k):
        c = 0
        for j in xrange(n//k):
            c += a[(i+j*k)%n]
        if m > c:
            m = c
            index = i
        #print i,c
    return index+1

n,k = map(int,raw_input().split())
a = map(int,raw_input().split())
print todo(n,k,a)
