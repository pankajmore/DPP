N = int(raw_input())
A = map(int,raw_input().split())
s = "X"
while(True):
    flag = 0
    for i in xrange(N):
        if A[i] != 0:
            flag = 1
    if flag==0:
        break
    for i in xrange(N):
        if A[i] > 0 and s[-1] != 'P':
            s += "P"
            A[i] -= 1
        if i < N-1:
            s += "R"
    flag = 0
    for i in xrange(N):
        if A[i] != 0:
            flag = 1
    if flag==0:
        break
    for i in xrange(N-1,-1,-1):
        if A[i] > 0 and s[-1] != 'P':
            s += "P"
            A[i] -= 1
        if i > 0:
            s += "L"
print s[1:]
