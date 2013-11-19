def goodSegment(a):
    n = len(a)
    if n == 1:
        return 1
    b = [2]*n
    for i in xrange(2,n):
        if a[i] == a[i-1] + a[i-2]:
            b[i] = b[i-1]+1
    return max(b)



n = int(raw_input())
a = map(int,raw_input().split())
print goodSegment(a)
