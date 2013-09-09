#line 2 "TheSwapsDivTwo.cpp"

#include <algorithm>
#include <list>
#include <stack>
#include <map>
#include <string>
#include <cstdio>
#include <iostream>
#include <ostream>
#include <utility>
#include <cstring>
#include <istream>
#include <queue>
#include <set>
#include <vector>
#include <cmath>
#include <deque>
#include <limits>
#include <sstream>

using namespace std;

typedef vector<int> VI;
typedef vector<string> VS;
typedef pair<int,int> PII;

#define SZ(x) ((int)((x).size()))

class TheSwapsDivTwo
        {
        public:
        int find(vector <int> sequence)
            {
		set <vector <int> > a;
		for(int i=0;i<SZ(sequence);i++) {
		    for(int j=i+1;j<SZ(sequence);j++) {
			swap(sequence[i],sequence[j]);
			a.insert(sequence);
			swap(sequence[i],sequence[j]);
		    }
		}
		return SZ(a);
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arr0[] = {4, 7, 4}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 3; verify_case(0, Arg1, find(Arg0)); }
	void test_case_1() { int Arr0[] = {1, 47}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(1, Arg1, find(Arg0)); }
	void test_case_2() { int Arr0[] = {9, 9, 9, 9}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(2, Arg1, find(Arg0)); }
	void test_case_3() { int Arr0[] = {22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 319; verify_case(3, Arg1, find(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        TheSwapsDivTwo ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
