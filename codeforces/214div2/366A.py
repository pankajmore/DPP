def dina(n,arr):
    for i in xrange(4):
        min1 = min(arr[i][0],arr[i][1])
        min2 = min(arr[i][3],arr[i][2])
        if min1 + min2 <= n:
            return (i+1,(min1,n-min1))
    return -1

n = int(raw_input())
arr = [map(int,raw_input().split()) for _ in xrange(4)]
res = dina(n,arr)
if res == -1:
    print "-1"
else:
    print (str(res[0])+" "+str(res[1][0])+" "+str(res[1][1]))
