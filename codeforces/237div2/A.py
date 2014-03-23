N = int(raw_input())
A = [raw_input() for _ in xrange(N)]
if A[1][0] == A[0][0]:
    print "NO"
    exit(0)
for i in xrange(N):
    if A[i][i] != A[0][0] or A[i][N-i-1] != A[0][0]:
        print "NO"
        exit(0)
for i in xrange(N):
    for j in xrange(N):
        if i != j and i+j !=N-1:
            if A[i][j] != A[1][0]:
                print "NO"
                exit(0)

print "YES"
