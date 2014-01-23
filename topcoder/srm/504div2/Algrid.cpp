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

class Algrid {
    public:
    vector<string> makeProgram(vector<string> output) {
	int w = output[0].size(), h = output.size();
	for(int i=h-2;i>=0;i--){
	    for(int j=w-2;j>=0;j--){
		char a = output[i][j], b = output[i][j+1];
		char &c = output[i+1][j], &d = output[i+1][j+1];
		if(a=='B' && b=='B'){
		    swap(c,d);
		} else if (a == 'B' && b=='W'){
		    if(c == 'W' || d == 'W') {
			return vector<string>(0);
		    } else {
			c = d = '?';
		    }
		} else if(a == 'W' && b == 'B') {
		    if(c == 'B' || d == 'B') {
			return vector<string>(0);
		    } else {
			c = d = '?';
		    }
		}
	    }
	    replace(output[i+1].begin(),output[i+1].end(),'?','B');
	}

        return output;
    }
};

// CUT begin
// Array to vector converter
template <typename T> vector<T> vector_wrapper(T arr[], int n) { return vector<T>(arr, arr + n); }
#define to_vector(arr) vector_wrapper(arr, sizeof(arr) / sizeof(arr[0]))

template <typename T> string pretty_print(T t) { stringstream s; typeid(T) == typeid(string) ? s << "\"" << t << "\"" : s << t; return s.str(); }

// Vector print
template <typename T> ostream &operator << (ostream &out, vector<T> arr) {
    out << "{ ";
    for (int i = 0; i < arr.size(); ++i) out << (i == 0 ? "" : ", ") << pretty_print(arr[i]);
    out << " }";
    return out;
}

bool do_test(vector<string> output, vector<string> __expected, int caseNo) {
    cout << "  Testcase #" << caseNo << " ... ";

    time_t startClock = clock();
    Algrid *instance = new Algrid();
    vector<string> __result = instance->makeProgram(output);
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
            string output[] = {
                "WWWWWWW",
                "WWWWWWB",
                "BBBBBWW"
            };
            string __expected[] = {
                "WWWWWWW",
                "WWWWWWB",
                "BBBBBBB"
            };
            return do_test(to_vector(output), to_vector(__expected), __no);
        }
        case 1: {
            string output[] = {
                "BBBBB",
                "WBWBW"
            };
            string __expected[] = {
                "BBBBB",
                "WWBWB"
            };
            return do_test(to_vector(output), to_vector(__expected), __no);
        }
        case 2: {
            string output[] = {
                "BBBB",
                "BBBB",
                "BBWB",
                "WWBB",
                "BWBB"
            };
            string __expected[] = {
            };
            return do_test(to_vector(output), to_vector(__expected), __no);
        }
        case 3: {
            string output[] = {
                "WWBBBBW",
                "BWBBWBB",
                "BWBBWBW",
                "BWWBWBB"
            };
            string __expected[] = {
                "WWBBBBW",
                "BBBBBWB",
                "BBBBBBB",
                "BBBWBBB"
            };
            return do_test(to_vector(output), to_vector(__expected), __no);
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
    cout << "Algrid (1000 Points)" << endl << endl;

    int nPassed = 0, nAll = 0;
    if (argc == 1)
        for (int i = 0; i < 4; ++i) nAll++, nPassed += run_testcase(i);
    else
        for (int i = 1; i < argc; ++i) nAll++, nPassed += run_testcase(atoi(argv[i]));
    cout << endl << "Passed : " << nPassed << "/" << nAll << " cases" << endl;

    int T = time(NULL) - 1390473174;
    double PT = T / 60.0, TT = 75.0;
    cout << "Time   : " << T / 60 << " minutes " << T % 60 << " secs" << endl;
    cout << "Score  : " << 1000 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT)) << " points" << endl;
    return 0;
}
// CUT end
