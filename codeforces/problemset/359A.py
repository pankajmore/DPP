def min_ops(arr,m,n):
    for i in xrange(m):
        if(arr[i][0]==1 or arr[i][n-1]==1):
            return 2
    for i in xrange(n):
        if(arr[0][i]==1 or arr[m-1][i]==1):
            return 2
    return 4

m,n = [int(x) for x in (raw_input().split())]
arr = [[int(x) for x in raw_input().split()] for _ in xrange(m)]
print min_ops(arr,m,n)
