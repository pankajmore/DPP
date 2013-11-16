def binary_search(a,x,low,high):
    while low < high:
        mid = (low+high)//2
        midval = a[mid][0]
        if midval < x:
            low = mid+1
        elif midval > x:
            high = mid
        else:
            return mid
    return high

def diwali(s,n,g,f):
    s.sort()
    #print s
    m = s[n-1][1]
    for i in xrange(n-2,-1,-1):
        if s[i][1] > m:
            m = s[i][1]
        else:
            s[i][1] = m
    #print s
    c = 0
    for i in f:
        index = binary_search(s,i,0,n)
        #print index
        if s[index][1] >= i:
            c += s[index][1]//i
    return (c*100)

n = int(raw_input())
s = [(map(int,raw_input().split())) for _ in xrange(n)]
g = int(raw_input())
f = [int(raw_input()) for _ in xrange(g)]
print diwali(s,n,g,f)
