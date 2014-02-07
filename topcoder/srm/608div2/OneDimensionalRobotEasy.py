# -*- coding: utf-8 -*-

class OneDimensionalRobotEasy:
    def finalPosition(self, commands, A, B):
        x = 0
        for i in xrange(len(commands)):
            if commands[i] == "L":
                if x != -A:
                    x -= 1
            else:
                if x!= B:
                    x += 1
        return x

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

def do_test(commands, A, B, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = OneDimensionalRobotEasy()
    exception = None
    try:
        __result = instance.finalPosition(commands, A, B);
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
        commands = "RRLRRLLR"
        A = 10
        B = 10
        __expected = 2

        # run the code
        return do_test(commands, A, B, __expected, __no)

    if __no == 1:
        commands = "RRRRR"
        A = 3
        B = 4
        __expected = 4

        # run the code
        return do_test(commands, A, B, __expected, __no)

    if __no == 2:
        commands = "LLLLLLLLLLR"
        A = 2
        B = 6
        __expected = -1

        # run the code
        return do_test(commands, A, B, __expected, __no)

    if __no == 3:
        commands = "RRRRRRRLRRLRRRRRRRRRRRRLRLRRRRRRRRLRRRRRLRRRRRRRRR"
        A = 5
        B = 20
        __expected = 20

        # run the code
        return do_test(commands, A, B, __expected, __no)

    if __no == 4:
        commands = "RLRLLLLLLLRLLLRLLLLLLLLRLLLLLRLLLRRLLLLLRLLLLLRLLL"
        A = 34
        B = 15
        __expected = -30

        # run the code
        return do_test(commands, A, B, __expected, __no)

    # Your custom testcase goes here
    # if __no == 5 ...
    #     pass

def run_tests():
    sys.stdout.write("OneDimensionalRobotEasy (250 Points)\n\n")

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

    T = time.time() - 1391788803
    PT, TT = (T / 60.0, 75.0)
    points = 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
