from itertools import *
from operator import *
def largest_number(N,O):
    m = 0
    for c in combinations_with_replacement(range(2,10),O):
        x = reduce(mul,c)
        if len(str(x))==N and x > m:
            m = x
    return m

print(largest_number(2,3))
