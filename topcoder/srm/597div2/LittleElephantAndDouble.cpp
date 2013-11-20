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

class LittleElephantAndDouble {
    public:
    string getAnswer(vector<int> A) {
      int max = 0;
      for (int i=0;i<A.size();i++) {
        if(max < A[i]) max = A[i];
      }
      for(int i=0;i<A.size();i++) {
        if(max == A[i]) continue;
        if(max%A[i]==0){
          int n = max/A[i];
          if(n & (n-1)){
            return "NO";
          }
        }
        else{
          return "NO";
        }
      }
      return "YES";
    }
};

// CUT begin
// Array to vector converter
template <typename T> vector<T> vector_wrapper(T arr[], int n) { return vector<T>(arr, arr + n); }
#define to_vector(arr) vector_wrapper(arr, sizeof(arr) / sizeof(arr[0]))

template <typename T> string pretty_print(T t) { stringstream s; typeid(T) == typeid(string) ? s << "\"" << t << "\"" : s << t; return s.str(); }

bool do_test(vector<int> A, string __expected, int caseNo) {
    cout << "  Testcase #" << caseNo << " ... ";

    time_t startClock = clock();
    LittleElephantAndDouble *instance = new LittleElephantAndDouble();
    string __result = instance->getAnswer(A);
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
            int A[] = {
                1, 2
            };
            string __expected = "YES";
            return do_test(to_vector(A), __expected, __no);
        }
        case 1: {
            int A[] = {
                1, 2, 3
            };
            string __expected = "NO";
            return do_test(to_vector(A), __expected, __no);
        }
        case 2: {
            int A[] = {
                4, 8, 2, 1, 16
            };
            string __expected = "YES";
            return do_test(to_vector(A), __expected, __no);
        }
        case 3: {
            int A[] = {
                94, 752, 94, 376, 1504
            };
            string __expected = "YES";
            return do_test(to_vector(A), __expected, __no);
        }
        case 4: {
            int A[] = {
                148, 298, 1184
            };
            string __expected = "NO";
            return do_test(to_vector(A), __expected, __no);
        }
        case 5: {
            int A[] = {
                7, 7, 7, 7
            };
            string __expected = "YES";
            return do_test(to_vector(A), __expected, __no);
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
    cout << "LittleElephantAndDouble (250 Points)" << endl << endl;

    int nPassed = 0, nAll = 0;
    if (argc == 1)
        for (int i = 0; i < 6; ++i) nAll++, nPassed += run_testcase(i);
    else
        for (int i = 1; i < argc; ++i) nAll++, nPassed += run_testcase(atoi(argv[i]));
    cout << endl << "Passed : " << nPassed << "/" << nAll << " cases" << endl;

    int T = time(NULL) - 1384955711;
    double PT = T / 60.0, TT = 75.0;
    cout << "Time   : " << T / 60 << " minutes " << T % 60 << " secs" << endl;
    cout << "Score  : " << 250 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT)) << " points" << endl;
    return 0;
}
// CUT end
