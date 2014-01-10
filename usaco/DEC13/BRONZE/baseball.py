def ge(A,x):
    low=0
    high=len(A)-1
    while(low<high):
        mid=low+(high-low)/2
        if(A[mid] >= x):
            high = mid
        else:
            low = mid+1
    if(A[low] < x):
        return -1
    return low

def le(A,x):
    low=0
    high=len(A)-1
    while(low<high):
        mid = low + (high-low+1)/2
        if A[mid] > x:
            high = mid-1
        else:
            low = mid
    if(A[low] > x):
        return -1
    return low

fin = open('baseball.in','r')
fout = open('baseball.out','w')
N = int(fin.readline())
A = [int(fin.readline()) for _ in xrange(N)]
A.sort()
#print A
#print le(A,8)
s = 0
for i in xrange(0,N):
    for j in xrange(i+1,N):
        a = A[i]
        b = A[j]
        l = le(A,b+2*(b-a))
        g = ge(A,b+(b-a))
        if(l>=g and l!=-1 and g!=-1):
            #print a,b,g,l
            c = l-g+1
            s += c
#print s
fout.write(str(s))
