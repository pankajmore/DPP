from itertools import *
def subset(a,k):
    n = len(a)
    if k == 0:
        return "YES"
    for size in xrange(1,n+1):
        for c in combinations(range(n),size):
            s = 0
            for j in c:
                s+= a[j]
            if s == k:
                return "YES"
    return "NO"

T = int(raw_input())
for i in xrange(T):
    raw_input()
    a = [int(x) for x in raw_input().split()]
    k = int(raw_input())
    print subset(a,k)
