from math import *
a,b = map(int,raw_input().split())
s = 0
while(a>=b):
    s += b
    a = a - b + 1
s += a
print s
