fin = open('records.in','r')
fout = open('records.out','w')
N = int(fin.readline())
if N == 0:
    fout.write(str(0))
    exit(0)
A = [fin.readline().split() for _ in xrange(N)]
for i in xrange(N):
    A[i].sort()
A.sort()
c = 1
m = 1
#print A
for i in xrange(1,N):
    if A[i-1] == A[i]:
        c+=1
        #print c
    else:
        c=1
    if(c>m):
        m=c
#print m
fout.write(str(m))
