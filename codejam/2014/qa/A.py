T = int(raw_input())
for i in xrange(T):
    a = int(raw_input())
    A = [map(int,raw_input().split()) for _ in xrange(4)]
    sa = set(A[a-1])
    b = int(raw_input())
    B = [map(int,raw_input().split()) for _ in xrange(4)]
    sb = set(B[b-1])
    sr = sa.intersection(sb)
    #print sr
    if len(sr) == 0:
        print "Case #{0}: Volunteer cheated!".format(i+1)
    elif len(sr) > 1:
        print "Case #{0}: Bad magician!".format(i+1)
    else:
        print "Case #{0}: {1}".format(i+1,list(sr)[0])
