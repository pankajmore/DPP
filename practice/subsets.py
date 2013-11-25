def subsets(a,n,s):
    if n == 0:
        print s
    else:
        subsets(a[1:],n-1,s)
        subsets(a[1:],n-1,s.append(a[0]))
