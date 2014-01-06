# -*- coding: utf-8 -*-
import math
class TheLotteryBothDivs:
    def find(self, goodSuffixes):
        if type(goodSuffixes) == int:
            A = [goodSuffixes]
        else:
            A = list(goodSuffixes)
        C = A
        #print C
        for i in xrange(len(C)):
            for j in xrange(len(C)):
                if j != i and C[j].endswith(C[i]):
                    C[j] = "DIRTY"
        C = [x for x in C if x != "DIRTY"]
        #print C
        s = 0
        for i in xrange(len(C)):
            s += 1.0/math.pow(10,len(C[i]))
        return s

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

def do_test(goodSuffixes, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = TheLotteryBothDivs()
    exception = None
    try:
        __result = instance.find(goodSuffixes);
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
        goodSuffixes = (
            "4"
        )
        __expected = 0.1

        # run the code
        return do_test(goodSuffixes, __expected, __no)

    if __no == 1:
        goodSuffixes = (
            "4",
            "7"
        )
        __expected = 0.2

        # run the code
        return do_test(goodSuffixes, __expected, __no)

    if __no == 2:
        goodSuffixes = (
            "47",
            "47"
        )
        __expected = 0.01

        # run the code
        return do_test(goodSuffixes, __expected, __no)

    if __no == 3:
        goodSuffixes = (
            "47",
            "58",
            "4747",
            "502"
        )
        __expected = 0.021

        # run the code
        return do_test(goodSuffixes, __expected, __no)

    if __no == 4:
        goodSuffixes = (
            "8542861",
            "1954",
            "6",
            "523",
            "000000000",
            "5426",
            "8"
        )
        __expected = 0.201100101

        # run the code
        return do_test(goodSuffixes, __expected, __no)

    # Your custom testcase goes here
    # if __no == 5 ...
    #     pass

def run_tests():
    sys.stdout.write("TheLotteryBothDivs (500 Points)\n\n")

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

    T = time.time() - 1389021360
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
