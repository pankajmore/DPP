from operator import *

def pow(x,n,m):
    if n == 0:
        return 1
    elif n == 1:
        return x
    elif n % 2 == 0:
        return pow((x*x)%m,n/2)
    else:
        return (x * pow((x*x)%m,n/2)) % m

def fact(n):
  if n == 0:
    return 1
  return reduce(mul,range(1,n+1))

def nCr(n,r):
  return fact(n)/(fact(r)*fact(n-r))

M = 1000000007
A = int(raw_input())
B = int(raw_input())

n = max(A,B)
r = min(A,B)
if r < 24:
  if n == 25:
    print nCr(n+r-1,r)%M
  else:
    print 0
else:
  if n == r + 2:
    print (nCr(48,24)%M * pow(2,r-24,M)) % M
  else:
    print 0
