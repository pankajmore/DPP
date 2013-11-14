def knight(a):
    k = []
    for i in range(8):
        for j in range(8):
            if a[i][j] == "K":
                k.append((i,j))
    assert(len(k)==2)
    r = abs(k[0][0] - k[1][0])
    c = abs(k[0][1] - k[1][1])
    x,y = max(r,c),min(r,c)
    if y % 2 == 1 or x % 2 == 1:
        return "NO"
    c = y/2
    if (x-y) % 2 == 0 and ((x-y)/2) % 2 == 0:
        c += (x-y)/2
        if c % 2 == 0:
            return "YES"
        else:
            return "NO"
    else:
        return "NO"

t = int(raw_input())
for i in range(t):
    a = [raw_input() for _ in range(8)]
    if i != t-1:
        _ = raw_input()
    print knight(a)
