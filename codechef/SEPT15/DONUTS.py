T = int(raw_input())
for _ in xrange(T):
    N, M = map(int, raw_input().split())
    A = map(int, raw_input().split())
    A.sort()
    G = M - 1
    C = 0
    # print A
    for x in A:
        if G - x > 0:
            G -= x + 1
            C += x
        else:
            C += G
            break
    print C