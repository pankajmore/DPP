def stair(arr,last):
    n = len(arr)
    arr.sort()
    if arr[0]==1 or arr[n-1]==last:
        return "NO"
    if n < 3:
        return "YES"
    for i in range(0,n-2):
        if arr[i+1] - arr[i] == 1 and arr[i+2] - arr[i+1] == 1:
            return "NO"
    return "YES"

n,k= [int(x) for x in raw_input().split()]
if k == 0:
    print "YES"
else:
    arr = [int(x) for x in raw_input().split()]
    print stair(arr,n)
