def num_of_digits(N):
    return len(str(N))

def foo(d):
    x = 0
    for i in xrange(d):
        x = x*10 + pow(10,i)
    return x

#for i in xrange(0,10):
#    print foo(i)

def head(N):
    return int(str(N)[0])

def rest(N):
    if len(str(N)) == 1:
        return -1
    return int(str(N)[1:])

def bar(k):
    x = 0
    while k > 0:
        if k%10 == 0:
            x += 1
        k /= 10
    return x

def count_zeros(N):
    if N == 0:
        return 0
    if N <= 10:
        return 1
    a = N/10
    r = N%10
    res = a + 10*(count_zeros(a)-1)
    if r > 0:
        res += r * bar(a) + 1
    return res

def count_digits(N,x):
    d = num_of_digits(N)
    c = 0
    # Count from 1 to 10*(d-1)
    c += foo(d-1)
    f = head(N)
    r = rest(N)
    if r == -1:
        if f >= x:
            c += 1
        return c
    else:
        c += (f-1)*foo(num_of_digits(N)-1)
        c += count_digits(rest(N),x)
        if f > x:
            c += pow(10,num_of_digits(N)-1)
        if f == x:
            c += r+1
        return c

def brute_force(N,x):
    c = 0
    for i in xrange(1,N+1):
        s = list(str(i))
        s = [y for y in s if int(y)==x]
        c += len(s)
    return c

def  getDigitsInBook(n):
    for i in xrange(0,10):
        if i == 0:
            print count_zeros(N+1) - 1
        else:
            print count_digits(N,i)

# N = int(raw_input())
# for i in xrange(0,10):
#     if i == 0:
#         c = count_zeros(N+1)-1
#     else:
#         c = count_digits(N,i)
# #    b = brute_force(N,i)
#     print N,i,c
