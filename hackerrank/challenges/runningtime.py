N = int(raw_input())
A = map(int,raw_input().split())
c = 0
for i in xrange(N):
    for j in xrange(i-1,-1,-1):
        if A[j] > A[j+1]:
            A[j+1],A[j] = A[j],A[j+1]
            c += 1
        else:
            break
print c
