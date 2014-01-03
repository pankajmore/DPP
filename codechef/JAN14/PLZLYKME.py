def like(L,D,S,C):
    m = S
    if m >= L:
        return True
    for d in xrange(D-1):
        m *= (1+C)
        if m >= L:
            return True
    return False

T = int(raw_input())
for i in xrange(T):
    L,D,S,C = map(long,raw_input().split())
    if like(L,D,S,C):
        print "ALIVE AND KICKING"
    else:
        print "DEAD AND ROTTING"
