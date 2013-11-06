def partition(arr):
    m = len(arr)
    s = sum(arr)
    C = [[False]*(s+1) for _ in range(m)]
    for i in range(1,s+1):
        C[0][i]=True if (arr[0]==i) else False
    for j in range(1,s+1):
        for i in range(1,m):
            C[i][j] = C[i-1][j] or (C[i-1][j-arr[i]] if(j - arr[i] >= 0) else False)
    print(C)
    for i in range(int(s/2),-1,-1):
        if C[m-1][i] == True:
            return (abs(2*i-s),backTrack(C,arr,m-1,i))

def backTrack(C,arr,i,j):
    if i < 0:
        return []
    elif C[i-1][j]:
        return backTrack(C,arr,i-1,j)
    else:
        arr[i] = -arr[i]
        return (backTrack(C,arr,i-1,j-arr[i]) + [-arr[i]])


m = int(input())
arr = [int(x) for x in (input()).split()]
print(partition(arr))
print(arr)
if sum(arr) < 0:
    arr = [-x for x in arr]
print(arr)
