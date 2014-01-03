def feedback(s):
    N = len(s)
    for i in xrange(N-3):
        if s[i:i+3] == "010" or s[i:i+3] == "101":
            return "Good"
    return "Bad"

T = int(raw_input())
for i in xrange(T):
    s = raw_input()
    print feedback(s)
