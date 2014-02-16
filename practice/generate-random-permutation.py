from random import *

def gen_random_permutation(n):
    A = range(n)
    for i in xrange(n):
        r = randint(i,n-1)
        A[i],A[r] = A[r],A[i]
    return A

# Testing the randomness
c = 0
for i in xrange(10000):
    A = gen_random_permutation(2)
    if A == [0,1]:
        c += 1
print c

def shuffle(A):
    n = len(A)
    for i in xrange(n):
        r = randint(i,n-1)
        A[i],A[r] = A[r],A[i]
    return A
