from collections import deque
def ops(a):
    q = deque()
    push = []
    p = []
    c = 0
    #print a
    for i in range(len(a)):
        while c < a[i]:
            c += 1
            q.append((c,"pushBack"))
            push.append("pushBack")
            q.appendleft((c,"pushFront"))
            push.append("pushFront")
        #assert(c == a[i])
        if c == a[i]:
            z,s = q.pop()
            assert(z == a[i])
            p.append(len(push)+len(p))
            continue
        if c > a[i]:
            if len(q) == 0:
                return "impossible"
            z,s = q.pop()
            while z != a[i]:
                if len(q) == 0:
                    return "impossible"
                if s=="pushBack":
                    push[2*z-2] = -1
                else:
                    push[2*z-1] = -1
                z,s = q.pop()
            assert(z == a[i])
            p.append(len(push)+len(pop))
    #assert(len(q) == 0)
    while len(q) > 0:
        z,s = q.pop()
        if s=="pushBack":
            push[2*z-2] = -1
        else:
            push[2*z-1] = -1

    assert(len(q)==0)
    pp = deque(p)
    j = pp.popleft()
    ans = []
    for i in range(len(push)):
        if i == j:
            ans.append("popBack")
            j = pp.popleft()
        ans.append(push[i])
    ans.append("popBack")
    for _ in xrange(len(pp)):
        ans.append("popBack")
    res = [x for x in ans if x != -1]
    return res

a = [int(x) for x in raw_input().split(",")]
res = ops(a)
if res == "impossible":
    print "impossible"
else:
    print ",".join(res)
