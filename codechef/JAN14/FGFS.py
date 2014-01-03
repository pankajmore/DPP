from collections import defaultdict
T = int(raw_input())
d = defaultdict(list)
for _ in xrange(T):
    N,K = map(int,raw_input().split())
    for i in xrange(N):
        s,f,p = map(int,raw_input().split())
        d[p].append((f,s))
    c = 0
    for p in d.keys():
        ff = 0
        d[p].sort()
        d[p].reverse()
        while(len(d[p]) != 0):
            f,s = d[p].pop()
            if s >= ff:
                c += 1
                #print f,s
                ff = f
    print c
