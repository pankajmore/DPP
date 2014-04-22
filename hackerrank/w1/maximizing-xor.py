def  maxXor( l,  r):
  m = 0
  for i in xrange(l,r+1):
    for j in xrange(i+1,r+1):
      m = max(m,i^j)
  return m

_l = int(raw_input());


_r = int(raw_input());

res = maxXor(_l, _r);
print(res)
