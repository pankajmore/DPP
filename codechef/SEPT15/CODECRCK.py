__author__ = 'pankajm'
import math

i, k, s = map(int, raw_input().split())
a_i, b_i = map(float, raw_input().split())
x = math.sqrt(2)
y = math.sqrt(3)
u = x - x * y
v = x + x * y
N = abs(k - i)
if N % 2 == 0:
    a_k = a_i
    b_k = b_i
    if k > i:
        print (a_k + b_k) * pow(2, 2 * N - s)
    else:
        print (a_k + b_k) / pow(2, 2 * N + s)
else:
    N -= 1
    a_k = u * a_i + v * b_i
    b_k = v * a_i - u * b_i
    if k > i:
        print (a_k + b_k) * pow(2, 2 * N - s)
    else:
        print (a_k + b_k) / (pow(2, 2 * N + s) * 16)