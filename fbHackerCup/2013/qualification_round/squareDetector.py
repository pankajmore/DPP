def higherleft(a,n):
    for i in xrange(n):
        for j in xrange(n):
            if a[i][j] == "#":
                return (i,j)

def lowerright(a,n):
    for i in xrange(n-1,-1,-1):
        for j in xrange(n-1,-1,-1):
            if a[i][j] == "#":
                return (i,j)

def squareDetector(a,n):
    x1,y1 = higherleft(a,n)
    x2,y2 = lowerright(a,n)
    if x2 < x1 or y2 < y1:
        return False
    if y1 - y2 != x1 - x2:
        return False
    for i in xrange(n):
        for j in xrange(n):
            if i >= x1 and i <= x2 and j >= y1 and j <= y2:
                if a[i][j] != "#":
                    return False
            else:
                if a[i][j] == "#":
                    return False
    return True


T = int(raw_input())
for i in xrange(T):
    N = int(raw_input())
    a = [raw_input() for _ in xrange(N)]
    if squareDetector(a,N):
        print "Case #{0}: YES".format(i+1)
    else:
        print "Case #{0}: NO".format(i+1)
