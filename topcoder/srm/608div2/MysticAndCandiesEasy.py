# -*- coding: utf-8 -*-

class MysticAndCandiesEasy:
    def minBoxes(self, C, X, high):
        if type(high) == int:
            high = [high]
        else:
            high = list(high)
        A = high.sort()
        N = len(high)
        c = 0
        k = 0
        m = C-X
        for i in xrange(N):
            if c + high[i] <= m:
                c += high[i]
                k += 1
        return (N-k)

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

def do_test(C, X, high, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = MysticAndCandiesEasy()
    exception = None
    try:
        __result = instance.minBoxes(C, X, high);
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
        C = 10
        X = 10
        high = (
            20
        )
        __expected = 1

        # run the code
        return do_test(C, X, high, __expected, __no)

    if __no == 1:
        C = 10
        X = 7
        high = (
            3, 3, 3, 3, 3
        )
        __expected = 4

        # run the code
        return do_test(C, X, high, __expected, __no)

    if __no == 2:
        C = 100
        X = 63
        high = (
            12, 34, 23, 45, 34
        )
        __expected = 3

        # run the code
        return do_test(C, X, high, __expected, __no)

    if __no == 3:
        C = 19
        X = 12
        high = (
            12, 9, 15, 1, 6, 4, 9, 10, 10, 10, 14, 14, 1, 1, 12, 10, 9, 2, 3, 6, 1, 7, 3, 4, 10, 3, 14
        )
        __expected = 22

        # run the code
        return do_test(C, X, high, __expected, __no)

    if __no == 4:
        C = 326
        X = 109
        high = (
            9, 13, 6, 6, 6, 16, 16, 16, 10, 16, 4, 3, 10, 8, 11, 17, 12, 5, 7, 8, 7, 4, 15, 7, 14, 2, 2, 1, 17, 1, 7, 7, 12, 17, 2, 9, 7, 1, 8, 16, 7, 4, 16, 2, 13, 3, 13, 1, 17, 6
        )
        __expected = 15

        # run the code
        return do_test(C, X, high, __expected, __no)

    # Your custom testcase goes here
    # if __no == 5 ...
    #     pass

def run_tests():
    sys.stdout.write("MysticAndCandiesEasy (500 Points)\n\n")

    nPassed = nAll = 0
    if len(sys.argv) <= 1:
        for i in range(5):
            nAll += 1
            nPassed += run_testcase(i)
    else:
        for arg in sys.argv[1:]:
            nAll += 1
            nPassed += run_testcase(int(arg))

    sys.stdout.write("\nPassed : %d / %d cases\n" % (nPassed, nAll))

    T = time.time() - 1391789016
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
