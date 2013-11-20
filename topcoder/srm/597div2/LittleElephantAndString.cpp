#include <cstdio>
#include <cmath>
#include <cstring>
#include <ctime>
#include <iostream>
#include <algorithm>
#include <set>
#include <vector>
#include <sstream>
#include <typeinfo>

using namespace std;

class LittleElephantAndString {
    public:
    int getNumber(string A, string B) {
      vector <int> cntA(26,0),cntB(26,0);
      int n = A.size();
      for(int i=0;i<n;i++) {
        cntA[A[i]-'A']++;
        cntB[B[i]-'A']++;
      }
      for(int i=0;i<26;i++){
        if(cntA[i]!=cntB[i]) {
          return -1;
        }
      }
      int j=n-1;
      int cnt=0;
      for(int i=n-1;i>=0;i--) {
        if(B[j]==A[i]){
          j--;
          cnt++;
        }
      }
      //cout<<j<<endl;
      return n-cnt;

    }
};

// CUT begin
template <typename T> string pretty_print(T t) { stringstream s; typeid(T) == typeid(string) ? s << "\"" << t << "\"" : s << t; return s.str(); }

bool do_test(string A, string B, int __expected, int caseNo) {
    cout << "  Testcase #" << caseNo << " ... ";

    time_t startClock = clock();
    LittleElephantAndString *instance = new LittleElephantAndString();
    int __result = instance->getNumber(A, B);
    double elapsed = (double)(clock() - startClock) / CLOCKS_PER_SEC;
    delete instance;

    if (__result == __expected) {
        cout << "PASSED!" << " (" << elapsed << " seconds)" << endl;
        return true;
    }
    else {
        cout << "FAILED!" << " (" << elapsed << " seconds)" << endl;
        cout << "           Expected: " << pretty_print(__expected) << endl;
        cout << "           Received: " << pretty_print(__result) << endl;
        return false;
    }
}

bool run_testcase(int __no) {
    switch (__no) {
        case 0: {
            string A = "ABC";
            string B = "CBA";
            int __expected = 2;
            return do_test(A, B, __expected, __no);
        }
        case 1: {
            string A = "A";
            string B = "B";
            int __expected = -1;
            return do_test(A, B, __expected, __no);
        }
        case 2: {
            string A = "AAABBB";
            string B = "BBBAAA";
            int __expected = 3;
            return do_test(A, B, __expected, __no);
        }
        case 3: {
            string A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            string B = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
            int __expected = 25;
            return do_test(A, B, __expected, __no);
        }
        case 4: {
            string A = "A";
            string B = "A";
            int __expected = 0;
            return do_test(A, B, __expected, __no);
        }
        case 5: {
            string A = "DCABA";
            string B = "DACBA";
            int __expected = 2;
            return do_test(A, B, __expected, __no);
        }

        // Your custom testcase goes here
        case 6:
            break;
        default: break;
    }
    return 0;
}

int main(int argc, char *argv[]) {
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(2);
    cout << "LittleElephantAndString (500 Points)" << endl << endl;

    int nPassed = 0, nAll = 0;
    if (argc == 1)
        for (int i = 0; i < 6; ++i) nAll++, nPassed += run_testcase(i);
    else
        for (int i = 1; i < argc; ++i) nAll++, nPassed += run_testcase(atoi(argv[i]));
    cout << endl << "Passed : " << nPassed << "/" << nAll << " cases" << endl;

    int T = time(NULL) - 1384964185;
    double PT = T / 60.0, TT = 75.0;
    cout << "Time   : " << T / 60 << " minutes " << T % 60 << " secs" << endl;
    cout << "Score  : " << 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT)) << " points" << endl;
    return 0;
}
// CUT end
