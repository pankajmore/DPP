# -*- coding: utf-8 -*-

class MathContest:
    def countBlack(self, ballSequence, repetitions):
        ls = [ballSequence for _ in xrange(repetitions)]
        s = "".join(ls)
        s = [0 if x=="B" else 1 for x in s]
        i = 0
        N = len(s)
        j = N-1
        cpos = 0
        ccol = 0
        c = 0
        for _ in xrange(N):
            assert(i<=j)
            x = s[cpos]
            if cpos == i:
                cpos += 1
                i += 1
            else:
                assert(cpos==j)
                cpos -= 1
                j -= 1

            if x == ccol:
                ccol ^= 1
                c += 1
            else:
                assert(x != ccol)
                cpos = i+j-cpos
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

def do_test(ballSequence, repetitions, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = MathContest()
    exception = None
    try:
        __result = instance.countBlack(ballSequence, repetitions);
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
        ballSequence = "BBWWB"
        repetitions = 1
        __expected = 2

        # run the code
        return do_test(ballSequence, repetitions, __expected, __no)

    if __no == 1:
        ballSequence = "BBB"
        repetitions = 10
        __expected = 1

        # run the code
        return do_test(ballSequence, repetitions, __expected, __no)

    if __no == 2:
        ballSequence = "BW"
        repetitions = 10
        __expected = 20

        # run the code
        return do_test(ballSequence, repetitions, __expected, __no)

    if __no == 3:
        ballSequence = "WWWWWWWBWWWWWWWWWWWWWW"
        repetitions = 1
        __expected = 2

        # run the code
        return do_test(ballSequence, repetitions, __expected, __no)

    # Your custom testcase goes here
    # if __no == 4 ...
    #     pass

def run_tests():
    sys.stdout.write("MathContest (500 Points)\n\n")

    nPassed = nAll = 0
    if len(sys.argv) <= 1:
        for i in range(4):
            nAll += 1
            nPassed += run_testcase(i)
    else:
        for arg in sys.argv[1:]:
            nAll += 1
            nPassed += run_testcase(int(arg))

    sys.stdout.write("\nPassed : %d / %d cases\n" % (nPassed, nAll))

    T = time.time() - 1390303786
    PT, TT = (T / 60.0, 75.0)
    points = 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
