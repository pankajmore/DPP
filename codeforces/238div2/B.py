N = int(raw_input())
s = raw_input()
A = list()
c = 0
for i in xrange(N):
    #print c, A
    if s[i] == ".":
        if len(A) > 0 and type(A[-1]) == int:
                A[-1] += 1
        else:
            A.append(1)
    if s[i] == "R":
        if len(A) > 0:
            c += A[0]
        A = list()
        A.append("R")
    if s[i] == "L":
        if len(A) >= 2 and A[0] == "R":
            c += (A[1]%2)
        A = list()
if len(A) > 0:
    if A[0] != "R":
        c += A[0]
print c
