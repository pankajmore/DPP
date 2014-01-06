# -*- coding: utf-8 -*-

class SplitIntoPairs:
    def makepairs(self, A, X):
        A = list(A)
        P = [x for x in A if x >= 0]
        N = [x for x in A if x < 0]
        if len(P)%2==0:
            return len(A)/2
        else:
            m1 = min(P)
            m2 = max(N)
            c = len(A)/2 -1
            if m1*m2 >= X:
                c += 1
            return c

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

def do_test(A, X, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = SplitIntoPairs()
    exception = None
    try:
        __result = instance.makepairs(A, X);
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
        A = (
            2, -1
        )
        X = -1
        __expected = 0

        # run the code
        return do_test(A, X, __expected, __no)

    if __no == 1:
        A = (
            1, -1
        )
        X = -1
        __expected = 1

        # run the code
        return do_test(A, X, __expected, __no)

    if __no == 2:
        A = (
            -5, -4, 2, 3
        )
        X = -1
        __expected = 2

        # run the code
        return do_test(A, X, __expected, __no)

    if __no == 3:
        A = (
            5, -7, 8, -2, -5, 3
        )
        X = -7
        __expected = 3

        # run the code
        return do_test(A, X, __expected, __no)

    if __no == 4:
        A = (
            3, 4, 5, 6, 6, -6, -4, -10, -1, -9
        )
        X = -2
        __expected = 4

        # run the code
        return do_test(A, X, __expected, __no)

    if __no == 5:
        A = (
            1000000, 1000000
        )
        X = -5
        __expected = 1

        # run the code
        return do_test(A, X, __expected, __no)

    # Your custom testcase goes here
    # if __no == 6 ...
    #     pass

def run_tests():
    sys.stdout.write("SplitIntoPairs (500 Points)\n\n")

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

    T = time.time() - 1389024180
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
