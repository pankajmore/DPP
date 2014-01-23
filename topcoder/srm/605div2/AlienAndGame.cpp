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

class AlienAndGame {
    public:
    int getNumber(vector<string> boar) {
	int w=boar[0].size(), h = boar.size();
	vector<vector <int> > board(h,vector<int>(w,0));
	vector<vector <int> > count(h,vector<int>(w,0));
	for(int i=0;i<h;i++){
	    for(int j=0;j<w;j++){
		//cout<<board[i][j]<<" ";
		board[i][j] = (boar[i][j]=='W') ? 0 : 1;
		count[i][j] = (j>0)?count[i][j-1]+board[i][j] : board[i][j];
	    }
	}
	int m=1;
	for(int i=0;i<h;i++){
	    for(int j=0;j<w;j++){
		for(int s=2;s<=min(h-i,w-j);s++){
		    int flag = 1;
		    for(int k=0;k<s;k++){
			int rowcount = (j>0) ? (count[i+k][j+s-1]-count[i+k][j-1]) : count[i+k][j+s-1];
			if (rowcount != 0 && rowcount != s) {
			    flag = 0;
			    break;
			}
		    }
		    if(flag==0) break;
		    m = max(m,s);
		}
	    }
	}

        return m*m;
    }
};

// CUT begin
// Array to vector converter
template <typename T> vector<T> vector_wrapper(T arr[], int n) { return vector<T>(arr, arr + n); }
#define to_vector(arr) vector_wrapper(arr, sizeof(arr) / sizeof(arr[0]))

template <typename T> string pretty_print(T t) { stringstream s; typeid(T) == typeid(string) ? s << "\"" << t << "\"" : s << t; return s.str(); }

bool do_test(vector<string> board, int __expected, int caseNo) {
    cout << "  Testcase #" << caseNo << " ... ";

    time_t startClock = clock();
    AlienAndGame *instance = new AlienAndGame();
    int __result = instance->getNumber(board);
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
            string board[] = {
                "BB",
                "WW"
            };
            int __expected = 4;
            return do_test(to_vector(board), __expected, __no);
        }
        case 1: {
            string board[] = {
                "W"
            };
            int __expected = 1;
            return do_test(to_vector(board), __expected, __no);
        }
        case 2: {
            string board[] = {
                "WBBB",
                "WBBB",
                "WWWW"
            };
            int __expected = 9;
            return do_test(to_vector(board), __expected, __no);
        }
        case 3: {
            string board[] = {
                "W",
                "B",
                "W",
                "W",
                "W"
            };
            int __expected = 1;
            return do_test(to_vector(board), __expected, __no);
        }
        case 4: {
            string board[] = {
                "BWBBWBB",
                "WWBWWBW",
                "BBBBBBW",
                "WBBBBWB",
                "BBWWWWB",
                "WWWWWWW",
                "BBWWBBB"
            };
            int __expected = 9;
            return do_test(to_vector(board), __expected, __no);
        }

        // Your custom testcase goes here
        case 5:
            break;
        default: break;
    }
    return 0;
}

int main(int argc, char *argv[]) {
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(2);
    cout << "AlienAndGame (500 Points)" << endl << endl;

    int nPassed = 0, nAll = 0;
    if (argc == 1)
        for (int i = 0; i < 5; ++i) nAll++, nPassed += run_testcase(i);
    else
        for (int i = 1; i < argc; ++i) nAll++, nPassed += run_testcase(atoi(argv[i]));
    cout << endl << "Passed : " << nPassed << "/" << nAll << " cases" << endl;

    int T = time(NULL) - 1390487011;
    double PT = T / 60.0, TT = 75.0;
    cout << "Time   : " << T / 60 << " minutes " << T % 60 << " secs" << endl;
    cout << "Score  : " << 500 * (0.3 + (0.7 * TT * TT) / (10.0 * PT * PT + TT * TT)) << " points" << endl;
    return 0;
}
// CUT end
