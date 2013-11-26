def algo(s,m,rr):
    x = y = z = 0
    a = []
    for i in xrange(len(s)):
        if s[i] == "x":
            x+=1
        if s[i] == "y":
            y+=1
        if s[i] == "z":
            z+=1
        a.append((x,y,z))
    for i in xrange(m):
        l,r = rr[i]
        l -= 1
        r -= 1
        c = r - l + 1
        if c < 3:
            print "YES"
        else:
            if l == 0:
                exp = a[r]
            else:
                exp = (a[r][0]-a[l-1][0],a[r][1]-a[l-1][1],a[r][2]-a[l-1][2])
            ans = list((c//3,c//3,c//3))
            if c % 3 == 0:
                pass
            if c % 3 == 1:
                ans[0] += 1
            if c % 3 == 2:
                ans[0] += 1
                ans[1] += 1
            exp = list(exp)
            exp.sort()
            ans.sort()
            #print ans,exp
            if ans == exp:
                print "YES"
            else:
                print "NO"

s = raw_input()
m = int(raw_input())
r = [map(int,raw_input().split()) for _ in xrange(m)]
algo(s,m,r)
