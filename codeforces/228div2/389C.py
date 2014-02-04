N = int(raw_input())
A = map(int,raw_input().split())
A.sort()
for k in xrange(1,N+1):
    flag = 0
    for i in xrange(N):
        if A[i] < (i/k):
            flag=1
            break
    if flag==0:
        break
print k
