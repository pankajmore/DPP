def kGood(n,k):
    a = [int(x) for x in n]
    aa = set(a)
    if aa.issuperset(set(range(k+1))):
        return True
    else:
        return False

def foo(a,k):
    count = 0
    for i in xrange(len(a)):
        if kGood(a[i],k):
            count += 1
    return count

n,k = map(int,raw_input().split())
a = [raw_input() for _ in xrange(n)]
print foo(a,k)
