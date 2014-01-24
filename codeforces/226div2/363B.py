import sys
def fence(arr,k):
    n = len(arr)
    s = sys.maxsize
    index = 0
    m = [0]*n
    t = 0
    for i in range(n):
        t += arr[i]
        m[i] = t
    for i in range(1,n-k+1):
        x = m[i+k-1] - m[i-1]
        #print x
        if s > x:
            s = x
            index = i+1
    return index

n,k = [int(x) for x in raw_input().split()]
arr = [int(x) for x in raw_input().split()]
print fence(arr,k)
