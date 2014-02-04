N = int(raw_input())
A = [list(raw_input()) for _ in xrange(N)]
#print A[1][1]
flag = 0
for i in xrange(N):
    for j in xrange(N):
        if A[i][j]=="#":
            if(i+1 < N):
                if A[i+1][j] != "#":
                    flag = 1
                    break
                A[i+1][j] = "1"
                if j-1 >= 0:
                    if A[i+1][j-1] != "#":
                        flag = 1
                        break
                    A[i+1][j-1] = "1"
                else:
                    flag = 1
                    break
                if j+1 < N:
                    if A[i+1][j+1] != "#":
                        flag = 1
                        break
                    A[i+1][j+1] = "1"
                else:
                    flag=1
                    break
                if i+2 < N:
                    if A[i+2][j] != "#":
                        flag = 1
                        break
                    A[i+2][j] = "1"
                else:
                    flag=1
                    break
            else:
                flag=1
                break
if flag==1:
    print "NO"
else:
    print "YES"
