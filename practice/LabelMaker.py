def findLabel(l,r):
    n = len(l)
    s = ""
    while(r>0):
        rem = r%n
        print rem
        s += l[(rem-1)%n]
        r = r/n
    return s[::-1]

T = int(raw_input())
for i in xrange(T):
    s,r = raw_input().split()
    r = int(r)
    print "Case #{0}: {1}".format(i+1,findLabel(s,r))
