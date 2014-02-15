def  getXNumber(num):
    n = num
    two = three = five = seven = 0
    while n % 2 == 0:
        two += 1
        n /= 2
    while n % 3 == 0:
        three += 1
        n /= 3
    while n % 5 == 0:
        five += 1
        n /= 5
    while n % 7 == 0:
        seven += 1
        n /= 5
    if n > 1:
        return -1
    else:
        l = []
#        print two,three,five,seven
        while two >= 3:
            l.append(8)
            two -= 3
        while three >= 2:
            l.append(9)
            three -= 2
        while two >= 2:
            l.append(4)
            two -= 2
        if two == 1 and three == 1:
            l.append(6)
        elif two == 1:
            l.append(2)
        elif three == 1:
            l.append(3)
        l.extend([5 for _ in xrange(five)])
        l.extend([7 for _ in xrange(seven)])
        l.sort()
        res = int("".join(map(str,l)))
        return res

N = int(raw_input())
print getXNumber(N)
