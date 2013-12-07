m = int(raw_input())
p = []
for i in xrange(m):
    s = map(int,raw_input().split())
    p.append(set(s[1:]))
#print p
for i in xrange(m):
    flag = 1
    for j in xrange(m):
        if p[j].issubset(p[i]) and i != j:
            print "NO"
            flag = 0
            break
    if flag == 1:
        print "YES"
