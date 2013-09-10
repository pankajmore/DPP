#line 2 "SkiResortsEasy.cpp"

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


#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))

class SkiResortsEasy
        {
        public:
	    int minCost(vector <int> altitude)
            {
		int n = altitude.size();
		int sum=0;
		int i;
		for(i=1;i<=n-1;i++) {
		    if(altitude[i] > altitude[i-1]) {
			sum += (altitude[i]-altitude[i-1]);
			altitude[i] = altitude[i-1];
		    }
		    else continue;
		}
		return sum;
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arr0[] = {30, 20, 20, 10}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 0; verify_case(0, Arg1, minCost(Arg0)); }
	void test_case_1() { int Arr0[] = {5, 7, 3}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; verify_case(1, Arg1, minCost(Arg0)); }
	void test_case_2() { int Arr0[] = {6, 8, 5, 4, 7, 4, 2, 3, 1}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 6; verify_case(2, Arg1, minCost(Arg0)); }
	void test_case_3() { int Arr0[] = {749, 560, 921, 166, 757, 818, 228, 584, 366, 88}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2284; verify_case(3, Arg1, minCost(Arg0)); }
	void test_case_4() { int Arr0[] = {712, 745, 230, 200, 648, 440, 115, 913, 627, 621, 186, 222, 741, 954, 581, 193, 266, 320, 798, 745}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 6393; verify_case(4, Arg1, minCost(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        SkiResortsEasy ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
