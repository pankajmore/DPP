n,m = map(int,raw_input().split())
A = map(int,raw_input().split())
A = [x-1 for x in A]
B = [-1]*n
for i in xrange(m):
    for j in xrange(A[i],n):
        if B[j] == -1:
            B[j] = A[i]
B = [x+1 for x in B]
print " ".join(map(str,B))
