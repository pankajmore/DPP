def n2(s):
    n = len(s)
    res = [n-i for i in xrange(n)]
    for i in xrange(n):
        d = set()
        for j in xrange(i,n):
            d.add(s[j])
            if len(d) == 3:
                res[i] = j-i
    print res
    return sum(res)

print(n2("aabc"))
print(n2("aabbac"))
