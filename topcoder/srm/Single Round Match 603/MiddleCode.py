# -*- coding: utf-8 -*-

class MiddleCode:
    def encode(self, s):
        t = ""
        while(len(s)>0):
            if(len(s)%2==1):
                m = (len(s)-1)/2
                t += s[m]
                s = s[:m]+s[m+1:]
            else:
                m = (len(s))/2 - 1
                if s[m] < s[m+1]:
                    t += s[m]
                    s = s[:m] + s[m+1:]
                else:
                    t += s[m+1]
                    s = s[:m+1] + s[m+2:]
        return t

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

def do_test(s, __expected, caseNo):
    sys.stdout.write("  Testcase #%d ... " % caseNo)

    startTime = time.time()
    instance = MiddleCode()
    exception = None
    try:
        __result = instance.encode(s);
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
        s = "word"
        __expected = "ordw"

        # run the code
        return do_test(s, __expected, __no)

    if __no == 1:
        s = "aaaaa"
        __expected = "aaaaa"

        # run the code
        return do_test(s, __expected, __no)

    if __no == 2:
        s = "abacaba"
        __expected = "caabbaa"

        # run the code
        return do_test(s, __expected, __no)

    if __no == 3:
        s = "shjegr"
        __expected = "ejghrs"

        # run the code
        return do_test(s, __expected, __no)

    if __no == 4:
        s = "adafaaaadafawafwfasdaa"
        __expected = "afawadafawafaafsadadaa"

        # run the code
        return do_test(s, __expected, __no)

    # Your custom testcase goes here
    # if __no == 5 ...
    #     pass

def run_tests():
    sys.stdout.write("MiddleCode (250 Points)\n\n")

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

    T = time.time() - 1389023806
    PT, TT = (T / 60.0, 75.0)
    points = 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT))
    sys.stdout.write("Time   : %d minutes %d secs\n" % (int(T/60), T%60))
    sys.stdout.write("Score  : %.2f points\n" % points)

if __name__ == '__main__':
    run_tests()

# }}}
# CUT end
