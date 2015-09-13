__author__ = 'pankajm'
T = int(raw_input())
for _ in xrange(T):
    N = int(raw_input())
    A = []
    S = dict()
    X = set()
    Y = set()
    for i in xrange(N):
        x, y = map(int, raw_input().split())
        A.append((x, y))
        S[(x, y)] = i + 1
        X.add(x)
        Y.add(y)
    min_x = min(X)
    max_x = max(X)
    min_y = min(Y)
    max_y = max(Y)
    if (min_x, min_y) in S:
        print 1
        print S[(min_x, min_y)], "NE"
    elif (min_x, max_y) in S:
        print 1
        print S[(min_x, max_y)], "SE"
    elif (max_x, min_y) in S:
        print 1
        print S[(max_x, min_y)], "NW"
    elif (max_x, max_y) in S:
        print 1
        print S[(max_x, max_y)], "SW"
    else:
        A.sort()
        minx = A[0]
        maxx = A[-1]
        print 2
        if minx[1] < maxx[1]:
            print S[minx], "NE"
            print S[maxx], "SW"
        else:
            print S[minx], "SE"
            print S[maxx], "NW"
