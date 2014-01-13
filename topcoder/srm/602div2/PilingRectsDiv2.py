# -*- coding: utf-8 -*-
import math
class PilingRectsDiv2:
    def getmax(self, X, Y, limit):
        if type(X) == int:
            X = [X]
        else:
            X = list(X)
        if type(Y) == int:
            Y = [Y]
        else:
            Y = list(Y)
        mx = -1
        for w in xrange(1,limit+1):
            h = math.ceil(limit/float(w))
            r = sum([(X[i] >= w and Y[i] >= h) or (X[i] >= h and Y[i] >=w) for i in xrange(len(X))])
            mx = max(mx,r)
        return mx if mx > 0 else -1

# CUT begin
# TEST CODE FOR PYTHON {{{
import sys
import time

def tc_equal(expected, received):
    try:
        _t = type(expected)
        received = _t(received)
        if _t == list or _t == tuple:
            if len(expected) != len(received): return False
            return all(tc_equal(e, r) for (e, r) in zip(expected, received))
        elif _t == float:
            eps = 1e-9
            if abs(expected - received) < eps: return True
            if abs(received) > abs(expected) * (1.0 - eps) and abs(received) < abs(expected) * (1.0 + eps): return True
        else:
            return expected == received
    except:
        return False

def do_test(X, Y, limit, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = PilingRectsDiv2()
    exception = None
    try:
        __result = instance.getmax(X, Y, limit);
    except:
        import traceback
        exception = traceback.format_exc()
    elapsed = time.time() - startTime   # in sec

    if exception is not None:
        sys.stdout.write("RUNTIME ERROR: \n")
        sys.stdout.write(exception + "\n")
        return 0

    if tc_equal(__expected, __result):
        sys.stdout.write("PASSED! " + ("(%.3f seconds)" % elapsed) + "\n")
        return 1
    else:
        sys.stdout.write("FAILED! " + ("(%.3f seconds)" % elapsed) + "\n")
        sys.stdout.write("           Expected: " + str(__expected) + "\n")
        sys.stdout.write("           Received: " + str(__result) + "\n")
        return 0

def run_testcase(__no):
    if __no == 0:
        X = (
            1, 2, 3, 1
        )
        Y = (
            3, 2, 4, 4
        )
        limit = 3
        __expected = 3

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    if __no == 1:
        X = (
            4, 7
        )
        Y = (
            7, 4
        )
        limit = 25
        __expected = 2

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    if __no == 2:
        X = (
            10
        )
        Y = (
            10
        )
        limit = 9999
        __expected = -1

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    if __no == 3:
        X = (
            10
        )
        Y = (
            3
        )
        limit = 30
        __expected = 1

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    if __no == 4:
        X = (
            3, 6, 5, 8, 2, 9, 14
        )
        Y = (
            14, 6, 13, 8, 15, 6, 3
        )
        limit = 27
        __expected = 4

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    if __no == 5:
        X = (
            121, 168, 86, 106, 36, 10, 125, 97, 53, 26, 148, 129, 41, 18, 173, 55, 13, 73, 91, 174, 177, 190, 28, 164, 122, 92, 5, 26, 58, 188, 14, 67, 48, 196, 41, 94, 24, 89, 54, 117, 12, 6, 155, 103, 200, 128, 184, 29, 92, 149
        )
        Y = (
            199, 182, 43, 191, 2, 145, 15, 53, 38, 37, 61, 45, 157, 129, 119, 123, 177, 178, 183, 188, 132, 108, 112, 137, 92, 59, 75, 196, 102, 152, 114, 121, 181, 93, 32, 3, 24, 116, 4, 163, 96, 159, 196, 43, 59, 150, 79, 113, 20, 146
        )
        limit = 5345
        __expected = 24

        # run the code
        return do_test(X, Y, limit, __expected, __no)

    # Your custom testcase goes here
    # if __no == 6 ...
    #     pass

def run_tests():
    sys.stdout.write("PilingRectsDiv2 (500 Points)\n\n")

    nPassed = nAll = 0
    if len(sys.argv) <= 1:
        for i in range(6):
            nAll += 1
            nPassed += run_testcase(i)
    else:
        for arg in sys.argv[1:]:
            nAll += 1
            nPassed += run_testcase(int(arg))

    sys.stdout.write("\nPassed : %d / %d cases\n" % (nPassed, nAll))

    T = time.time() - 1389632023
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
