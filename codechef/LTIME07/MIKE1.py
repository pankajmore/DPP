N,M=map(int,raw_input().split())
A = [map(int,raw_input().split()) for _ in xrange(N)]
L = int(raw_input())
X = [map(int,raw_input().split()) for _ in xrange(L)]
X = [[x-1,y-1] for [x,y] in X]
E1 = E2 = 0
#print A
for i in xrange(L):
    if X[i][0] >= N or X[i][1] >= M:
        E1 = -1
        break
    else:
        E1 += A[X[i][0]][X[i][1]]
for i  in xrange(L):
    if X[i][0] >= M or X[i][1] >= N:
        E2 = -1
        break
    else:
        E2 += A[X[i][1]][X[i][0]]
print max(E1,E2)
