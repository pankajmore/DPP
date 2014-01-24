def digit(d):
    if d < 5:
        a = "O-"
    else:
        a = "-O"
        d = d - 5
    if d == 0:
        b = "-OOOO"
    elif d == 1:
        b = "O-OOO"
    elif d == 2:
        b = "OO-OO"
    elif d == 3:
        b = "OOO-O"
    elif d == 4:
        b = "OOOO-"
    else:
        assert(false)
    return a+"|"+b

def soroban(n):
    s = n[::-1]
    s = [int(x) for x in s]
    return [digit(d) for d in s]

n = (raw_input())
soro = soroban(n)
for i in soro:
    print(i)
