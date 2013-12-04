# -*- coding: utf-8 -*-

class MiniatureDachshund:
    def maxMikan(self, mikan, weight):
        if type(mikan) == int:
            mikan = [mikan]
        mikan = [x for x in mikan]
        mikan.sort()
        c = 0
        for i in range(len(mikan)):
            if weight + mikan[i] <= 5000:
                weight += mikan[i]
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

def do_test(mikan, weight, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = MiniatureDachshund()
    exception = None
    try:
        __result = instance.maxMikan(mikan, weight);
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
        mikan = (
            100, 100, 100, 100, 100
        )
        weight = 4750
        __expected = 2

        # run the code
        return do_test(mikan, weight, __expected, __no)

    if __no == 1:
        mikan = (
            100, 100, 100, 100, 50
        )
        weight = 4750
        __expected = 3

        # run the code
        return do_test(mikan, weight, __expected, __no)

    if __no == 2:
        mikan = (
            120, 90, 130, 100, 110, 80
        )
        weight = 3000
        __expected = 6

        # run the code
        return do_test(mikan, weight, __expected, __no)

    if __no == 3:
        mikan = (
            50
        )
        weight = 5000
        __expected = 0

        # run the code
        return do_test(mikan, weight, __expected, __no)

    if __no == 4:
        mikan = (
            200, 50, 200, 50, 200, 50, 200, 50
        )
        weight = 4800
        __expected = 4

        # run the code
        return do_test(mikan, weight, __expected, __no)

    # Your custom testcase goes here
    # if __no == 5 ...
    #     pass

def run_tests():
    sys.stdout.write("MiniatureDachshund (250 Points)\n\n")

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

    T = time.time() - 1386172885
    PT, TT = (T / 60.0, 75.0)
    points = 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
