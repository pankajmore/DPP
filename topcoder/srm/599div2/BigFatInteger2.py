# -*- coding: utf-8 -*-
from math import *
class BigFatInteger2:
    def isDivisible(self, A, B, C, D):
        d1 = dict()
        d2 = dict()
        for i in range(2,max(3,int(sqrt(A)))):
            while A % i==0:
                if i in d1:
                    d1[i] += 1
                else:
                    d1[i] = 1
                A /= i
        if A > 1:
            if A in d1:
                d1[A] += 1
            else:
                d1[A] = 1
        for i in range(2,max(3,int(sqrt(C)))):
            while C % i==0:
                if i in d2:
                    d2[i] += 1
                else:
                    d2[i] = 1
                C /= i
        if C > 1:
            if C in d2:
                d2[C] += 1
            else:
                d2[C] = 1

        for k in d1.keys():
            d1[k] *= B
        for k in d2.keys():
            d2[k] *= D
        s1 = set(d1.keys())
        s2 = set(d2.keys())
        #print(d1,d2)
        if s2.difference(s1) != set():
            return "not divisible"
        for k in d1.keys():
            if k in d2:
                if d1[k] < d2[k]:
                    return "not divisible"
        return "divisible"
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

def do_test(A, B, C, D, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = BigFatInteger2()
    exception = None
    try:
        __result = instance.isDivisible(A, B, C, D);
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
        A = 6
        B = 1
        C = 2
        D = 1
        __expected = "divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    if __no == 1:
        A = 2
        B = 1
        C = 6
        D = 1
        __expected = "not divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    if __no == 2:
        A = 1000000000
        B = 1000000000
        C = 1000000000
        D = 200000000
        __expected = "divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    if __no == 3:
        A = 8
        B = 100
        C = 4
        D = 200
        __expected = "not divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    if __no == 4:
        A = 999999937
        B = 1000000000
        C = 999999929
        D = 1
        __expected = "not divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    if __no == 5:
        A = 2
        B = 2
        C = 4
        D = 1
        __expected = "divisible"

        # run the code
        return do_test(A, B, C, D, __expected, __no)

    # Your custom testcase goes here
    # if __no == 6 ...
    #     pass

def run_tests():
    sys.stdout.write("BigFatInteger2 (500 Points)\n\n")

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

    T = time.time() - 1386173289
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
