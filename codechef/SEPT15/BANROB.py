__author__ = 'pankajm'
T = int(raw_input())
for _ in xrange(T):
    N, P = map(float, raw_input().split())
    A = 1000000000.0
    X = A
    M = pow(P, N)
    if N % 2 == 0:
        X *= (1 - M)
    else:
        X *= (1 + M)
    X /= (1 + P)
    print X, A - X