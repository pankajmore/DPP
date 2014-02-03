T = int(raw_input())
for _ in xrange(T):
    N = int(raw_input())
    S = raw_input()
    A = map(int,raw_input().split())
    S = list(S)
    for i in xrange(N):
        S[A[i]-1],S[i] = S[i],S[A[i]-1]
    print "".join(S)
