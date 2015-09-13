__author__ = 'pankajm'
T = int(raw_input())
for _ in xrange(T):
    N = int(raw_input())
    A = [0] * (N * N)
    for i in xrange(N):
        L = map(int, raw_input().split())
        for j in xrange(N):
            A[L[j] - 1] = (i, j)
    c = 0
    for i in xrange(1, N * N):
        c += abs(A[i][0] - A[i - 1][0]) + abs(A[i][1] - A[i - 1][1])
    print c