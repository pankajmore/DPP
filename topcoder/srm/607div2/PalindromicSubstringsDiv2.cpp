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

class PalindromicSubstringsDiv2 {
    public:
    int count(vector<string> S1, vector<string> S2) {
	string s = "";
	for(int i=0;i<S1.size();i++) s+= S1[i];
	for(int i=0;i<S2.size();i++) s+= S2[i];
	int c = s.length();
	//cout<<s<<endl;
	for(int i=1;i<s.length()-1;i++){
	    int j=i-1,k=i+1;
	    while(j>=0 && k<s.length()){
		if(s[j] == s[k]) {
		    c++;j--;k++;
		}
		else break;
	    }
	}
	for(int i=0;i<s.length()-1;i++){
	    int j=i,k=i+1;
	    while(j>=0 && k<s.length()){
		if(s[j] == s[k]) {
		    c++;j--;k++;
		}
		else break;
	    }
	}

        return c;
    }
};

// CUT begin
// Array to vector converter
template <typename T> vector<T> vector_wrapper(T arr[], int n) { return vector<T>(arr, arr + n); }
#define to_vector(arr) vector_wrapper(arr, sizeof(arr) / sizeof(arr[0]))

template <typename T> string pretty_print(T t) { stringstream s; typeid(T) == typeid(string) ? s << "\"" << t << "\"" : s << t; return s.str(); }

bool do_test(vector<string> S1, vector<string> S2, int __expected, int caseNo) {
    cout << "  Testcase #" << caseNo << " ... ";

    time_t startClock = clock();
    PalindromicSubstringsDiv2 *instance = new PalindromicSubstringsDiv2();
    int __result = instance->count(S1, S2);
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
            string S1[] = {
                "a",
                "a",
                ""
            };
            string S2[] = {
                "a"
            };
            int __expected = 6;
            return do_test(to_vector(S1), to_vector(S2), __expected, __no);
        }
        case 1: {
            string S1[] = {
                "zaz"
            };
            string S2[] = {
            };
            int __expected = 4;
            return do_test(to_vector(S1), to_vector(S2), __expected, __no);
        }
        case 2: {
            string S1[] = {
                "top"
            };
            string S2[] = {
                "coder"
            };
            int __expected = 8;
            return do_test(to_vector(S1), to_vector(S2), __expected, __no);
        }
        case 3: {
            string S1[] = {
            };
            string S2[] = {
                "daata"
            };
            int __expected = 7;
            return do_test(to_vector(S1), to_vector(S2), __expected, __no);
        }

        // Your custom testcase goes here
        case 4:
            break;
        default: break;
    }
    return 0;
}

int main(int argc, char *argv[]) {
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(2);
    cout << "PalindromicSubstringsDiv2 (500 Points)" << endl << endl;

    int nPassed = 0, nAll = 0;
    if (argc == 1)
        for (int i = 0; i < 4; ++i) nAll++, nPassed += run_testcase(i);
    else
        for (int i = 1; i < argc; ++i) nAll++, nPassed += run_testcase(atoi(argv[i]));
    cout << endl << "Passed : " << nPassed << "/" << nAll << " cases" << endl;

    int T = time(NULL) - 1391429163;
    double PT = T / 60.0, TT = 75.0;
    cout << "Time   : " << T / 60 << " minutes " << T % 60 << " secs" << endl;
    cout << "Score  : " << 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT)) << " points" << endl;
    return 0;
}
// CUT end
