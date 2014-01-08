k = int(raw_input())
H = [0]*9
for _ in xrange(4):
    A = list(raw_input())
    A = [int(x) for x in A if x != '.']
    #print A
    for v in A:
        H[v-1] += 1
for v in H:
    if v > (2*k):
        print "NO"
        exit(0)
print "YES"
