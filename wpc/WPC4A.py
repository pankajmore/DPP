T = int(raw_input())
for _ in xrange(T):
    s = raw_input()
    m,n = map(int,raw_input().split())
    if m == n:
        print "{0} {0}".format(len(s))
    else:
        x = len(s)
        t = n-m
        c = 0
        for i in xrange(len(s)):
            if s[i] == 'a':
                c += 1
            else:
                c = 0
            if c == m:
                x += t
                c = 0
        print "{0} {1}".format(min(len(s),x),max(len(s),x))
