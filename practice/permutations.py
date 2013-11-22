def permutations(a):
    if len(a) == 1:
        return [a]
    else:
        res = []
        x = a[0]
        xs = a[1:]
        for p in permutations(xs):
            for i in xrange(len(p)+1):
                res.append(str(p[0:i]+x+p[i:]))
        return res
