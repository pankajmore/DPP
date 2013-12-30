N= int(raw_input())
A = map(int,raw_input().split())
B = A[:]
B.sort()
R = []
D = dict()
c = 0
for x in B:
    if x > c:
        c = x
    else:
        c = c+1
    if D.has_key(x):
        D[x].append(c)
    else:
        D[x] = []
        D[x].append(c)
for x in A:
    R.append(D[x][-1])
    D[x].pop()
print " ".join(map(str,R))
