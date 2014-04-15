T = int(raw_input())
for i in xrange(T):
    C,F,X = map(float,raw_input().split())
    r = 2
    s = 0
    while(X/r > C/r +X/(r+F)):
        #print C/r
        s += C/r
        r += F
    #print X/r
    s += X/r
    print "Case #{0}: {1}".format(i+1,s)
