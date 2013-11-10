from itertools import *
def min_players(P,F,prefs):
    m = P
    for i in range(1,P):
        for j in combinations(range(P),i):
            arr = [0]*F
            for k in j:
                for v,l in enumerate(prefs):
                    if l[k] == "1":
                        arr[v]=1
            #print arr
            if all(arr):
                return i

prefs = ["1000","0100","0101"]
print(min_players(4,3,prefs))
