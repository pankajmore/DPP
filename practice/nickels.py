n = int(raw_input())
a = [1,5,10,25]
def nickels(n,a):
    if n == 0 or len(a) == 1:
        return 1
    else:
        return sum([nickels(n-x*a[0],a[1:]) for x in xrange(n//a[0]+1)])

def dp_nickels(n,a):
    t = len(a)
    dp = [[0]*t for _ in xrange(n+1)]
    for i in xrange(n+1):
        dp[i][0] = 1
    for i in xrange(t):
        dp[0][i] = 1
    for j in xrange(1,t):
        for i in xrange(1,n+1):
            for k in xrange((n//a[j]) + 1):
                dp[i][j] += dp[i-k*a[j]][j-1]
    return dp[n][t-1]
print nickels(n,[25,10,5,1])
print dp_nickels(n,a)
