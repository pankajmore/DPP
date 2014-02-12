N = int(raw_input())
A = set()
B = set()
for _ in xrange(N):
    x,y = map(int,raw_input().split())
    A.add(x)
    B.add(y)
print min(len(A),len(B))
