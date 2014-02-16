def gcd(a,b):
    if b == 0:
        return a
    else:
        return gcd(b,a%b)

def rotate(A,k):
    n = len(A)
    for i in xrange(gcd(n,k)):
        temp = A[i]
        old = A[i]
        start = i
        while (i+k)%n != start:
            temp = A[(i+k)%n]
            A[(i+k)%n] = old
            old = temp
            i = (i+k)%n
        A[(i+k)%n] = old
        print A
    return A
