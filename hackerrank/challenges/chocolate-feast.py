T = int(raw_input())
for _ in xrange(T):
    N,C,M = map(int,raw_input().split())
    k = N/C
    c = N/C
    while k >= M:
        c += k/M
        k = k%M + k/M
    print c
