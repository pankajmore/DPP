def max_con(s):
    c = 1
    A = [0]*26
    for i in xrange(1,len(s)):
        if s[i] == s[i-1]:
            c += 1
        else:
            c = 1
        A[ord(s[i])-97] = max(c,A[ord(s[i])-97])
    #print A
    return A

T = int(raw_input())
for _ in xrange(T):
    s,t = raw_input().split()
    A = max_con(s)
    B = max_con(t)
    C = [A[i]+B[i] for i in xrange(26)]
    print max(C)
