#line 2 "EasyHomework.cpp"

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

#define FOR(k,a,b) for(typeof(a) k=(a); k <= (b); ++k)
#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))
#define ALL(c) (c).begin(), (c).end()

class EasyHomework
        {
        public:
        string determineSign(vector <int> A)
            {
		int count=0;
		REP(i,SZ(A)) {
		    if (A[i] == 0) return "ZERO";
		    else if (A[i] < 0) count++;
		}
		if(count %2 == 0) return "POSITIVE";
		else return "NEGATIVE";
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); if ((Case == -1) || (Case == 5)) test_case_5(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arr0[] = {5, 7, 2}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "POSITIVE"; verify_case(0, Arg1, determineSign(Arg0)); }
	void test_case_1() { int Arr0[] = {-5, 7, 2}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "NEGATIVE"; verify_case(1, Arg1, determineSign(Arg0)); }
	void test_case_2() { int Arr0[] = {5, 7, 2, 0}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "ZERO"; verify_case(2, Arg1, determineSign(Arg0)); }
	void test_case_3() { int Arr0[] = {3, -14, 159, -26}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "POSITIVE"; verify_case(3, Arg1, determineSign(Arg0)); }
	void test_case_4() { int Arr0[] = {-1000000000}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "NEGATIVE"; verify_case(4, Arg1, determineSign(Arg0)); }
	void test_case_5() { int Arr0[] = {123, -456, 789, -101112, 131415, 161718, 192021, 222324, 252627, 282930, 313233, 343536, 373839, 404142, 434445, 464748, 495051, 525354, 555657}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); string Arg1 = "POSITIVE"; verify_case(5, Arg1, determineSign(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        EasyHomework ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
