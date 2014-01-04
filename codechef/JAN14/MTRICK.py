T = int(raw_input())
for _ in xrange(T):
    N = int(raw_input())
    L = map(int,raw_input().split())
    A,B,C = map(int,raw_input().split())
    S = raw_input()
    y = 0
    z = 1
    i = 0
    j = N-1
    curr = i
    for k in xrange(N):
        if S[k] == 'R':
            curr = i+j-curr
        if S[k] == 'A':
            y = (y+A)%C
        if S[k] == 'M':
            z = (z*B)%C
            y = (y*B)%C
        print ((z*L[curr])+y)%C,
        if curr == i:
            curr += 1
            i += 1
        else:
            curr -= 1
            j -= 1
    print
