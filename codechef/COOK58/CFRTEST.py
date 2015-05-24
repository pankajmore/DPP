__author__ = 'pankajm'
# cook your code here
T = int(raw_input())
for _ in xrange(T):
    N = int(raw_input())
    A = map(int,raw_input().split())
    print len(set(A))