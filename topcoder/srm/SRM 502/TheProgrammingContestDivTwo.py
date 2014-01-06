# -*- coding: utf-8 -*-

class TheProgrammingContestDivTwo:
    def find(self, T, requiredTime):
        if type(requiredTime) == int:
            A = [requiredTime]
        else:
            A = list(requiredTime);
        A.sort();
        c = i = s = p = 0;
        for i in xrange(len(A)):
            if c+A[i] <= T:
                c += A[i]
                i += 1
                s += 1
                p += c
            else:
                break
        return (s,p)

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

def do_test(T, requiredTime, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = TheProgrammingContestDivTwo()
    exception = None
    try:
        __result = instance.find(T, requiredTime);
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
        T = 74
        requiredTime = (
            47
        )
        __expected = (
            1, 47
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    if __no == 1:
        T = 74
        requiredTime = (
            4747
        )
        __expected = (
            0, 0
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    if __no == 2:
        T = 47
        requiredTime = (
            8, 5
        )
        __expected = (
            2, 18
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    if __no == 3:
        T = 47
        requiredTime = (
            12, 3, 21, 6, 4, 13
        )
        __expected = (
            5, 86
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    if __no == 4:
        T = 58
        requiredTime = (
            4, 5, 82, 3, 4, 65, 7, 6, 8, 7, 6, 4, 8, 7, 6, 37, 8
        )
        __expected = (
            10, 249
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    if __no == 5:
        T = 100000
        requiredTime = (
            100000
        )
        __expected = (
            1, 100000
        )

        # run the code
        return do_test(T, requiredTime, __expected, __no)

    # Your custom testcase goes here
    # if __no == 6 ...
    #     pass

def run_tests():
    sys.stdout.write("TheProgrammingContestDivTwo (250 Points)\n\n")

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

    T = time.time() - 1389020707
    PT, TT = (T / 60.0, 75.0)
    points = 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
