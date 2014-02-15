from collections import *
def key(s):
    l = [0]*256
    for x in s:
        l[ord(x)] += 1
    return str(l)

def anagrams(ls):
    d = defaultdict(list)
    for x in ls:
        d[key(x)].append(x)
    l = [d[k] for k in d.keys()]
    return l

print anagrams(["cat","bat","act","tab"])
