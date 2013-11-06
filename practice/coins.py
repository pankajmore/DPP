def no_of_possible_changes(n,d):
    D = len(d)
    C = [[0]*(D) for _ in range(n+1)]
    for i in range(1,n+1):
        C[i][0]=1
    for i in range(D):
        C[0][i]=1
    for i in range(1,n+1):
        for j in range(1,D):
            C[i][j] = C[i][j-1]
            y = i - d[j]
            while(y>=0):
                C[i][j]+=C[y][j-1]
                y -= d[j]
    return C[n][D-1]

def min_coins(n,d):
    arr = [0]*(n+1)
    b = [0]*(n+1)
    b[0]=0
    arr[0] = 0
    for i in range(1,n+1):
        l = []
        for j in d:
            if(i-j>=0):
                l.append(arr[i-j])
        if(len(l)==0):
            return "Not possible"
        arr[i] = min(l)+1
        b[i]=d[l.index(arr[i]-1)]
    print(arr)
    print(b)
    print(backTrack(n,b))
    return arr[n]

def backTrack(n,b):
    if n==0:
        return []
    else:
        return backTrack(n-b[n],b) + [b[n]]

n = int(input())
print(no_of_possible_changes(n,[1,6,10]))
#print(min_coins(1,[1,6,10]))
