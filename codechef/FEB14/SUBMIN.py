N = int(raw_input())
A = map(int,raw_input().split())
Q = int(raw_input())
for _ in xrange(Q):
    m = int(raw_input())
    c = 0
    for i in xrange(0,N):
        for j in xrange(i,N):
            if min(A[i:j+1]) == m:
                c += 1
    print c
