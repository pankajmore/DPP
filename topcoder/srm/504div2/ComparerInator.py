# -*- coding: utf-8 -*-

class ComparerInator:
    def makeProgram(self, A, B, wanted):
        if type(A) == int:
            A = [A]
        else:
            A = list(A)
        if type(B) == int:
            B = [B]
        else:
            B = list(B)
        if type(wanted) == int:
            wanted = [wanted]
        else:
            wanted = list(wanted)
        if A == wanted or B == wanted:
            return 1
        m = [max(A[i],B[i]) for i in xrange(len(A))]
        mm = [min(A[i],B[i]) for i in xrange(len(A))]
        if m == wanted or mm == wanted:
            return 7
        return -1

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

def do_test(A, B, wanted, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = ComparerInator()
    exception = None
    try:
        __result = instance.makeProgram(A, B, wanted);
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
            1
        )
        B = (
            2
        )
        wanted = (
            2
        )
        __expected = 1

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    if __no == 1:
        A = (
            1, 3
        )
        B = (
            2, 1
        )
        wanted = (
            2, 3
        )
        __expected = 7

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    if __no == 2:
        A = (
            1, 3, 5
        )
        B = (
            2, 1, 7
        )
        wanted = (
            2, 3, 5
        )
        __expected = -1

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    if __no == 3:
        A = (
            1, 3, 5
        )
        B = (
            2, 1, 7
        )
        wanted = (
            1, 3, 5
        )
        __expected = 1

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    if __no == 4:
        A = (
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        )
        B = (
            5, 4, 7, 8, 3, 1, 1, 2, 3, 4, 6
        )
        wanted = (
            1, 2, 3, 4, 3, 1, 1, 2, 3, 4, 6
        )
        __expected = 7

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    if __no == 5:
        A = (
            1, 5, 6, 7, 8
        )
        B = (
            1, 5, 6, 7, 8
        )
        wanted = (
            1, 5, 6, 7, 8
        )
        __expected = 1

        # run the code
        return do_test(A, B, wanted, __expected, __no)

    # Your custom testcase goes here
    # if __no == 6 ...
    #     pass

def run_tests():
    sys.stdout.write("ComparerInator (250 Points)\n\n")

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

    T = time.time() - 1390302893
    PT, TT = (T / 60.0, 75.0)
    points = 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
