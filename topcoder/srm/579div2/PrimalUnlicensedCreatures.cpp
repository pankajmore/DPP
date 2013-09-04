#line 2 "PrimalUnlicensedCreatures.cpp"

#include <algorithm>
#include <string>
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <ostream>
#include <utility>
#include <climits>
#include <cstring>
#include <set>
#include <vector>
#include <cmath>
#include <deque>
#include <limits>
#include <sstream>

using namespace std;

typedef vector<string> VS;
typedef pair<int,int> PII;

#define FOR(k,a,b) for(typeof(a) k=(a); k <= (b); ++k)
#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))
#define ALL(c) (c).begin(), (c).end()

class PrimalUnlicensedCreatures
        {
        public:
        int maxWins(int initialLevel, vector <int> grezPower)
            {
		int count=0,p=initialLevel;
		sort(ALL(grezPower));
		REP(i,SZ(grezPower)) {
		    if(grezPower[i] < p) {
			p+=(grezPower[i]/2);
			count++;
		    }
		}
		return count;
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arg0 = 31; int Arr1[] = {10, 20, 30}; vector <int> Arg1(Arr1, Arr1 + (sizeof(Arr1) / sizeof(Arr1[0]))); int Arg2 = 3; verify_case(0, Arg2, maxWins(Arg0, Arg1)); }
	void test_case_1() { int Arg0 = 20; int Arr1[] = {24, 5, 6, 38}; vector <int> Arg1(Arr1, Arr1 + (sizeof(Arr1) / sizeof(Arr1[0]))); int Arg2 = 3; verify_case(1, Arg2, maxWins(Arg0, Arg1)); }
	void test_case_2() { int Arg0 = 20; int Arr1[] = {3, 3, 3, 3, 3, 1, 25 }; vector <int> Arg1(Arr1, Arr1 + (sizeof(Arr1) / sizeof(Arr1[0]))); int Arg2 = 6; verify_case(2, Arg2, maxWins(Arg0, Arg1)); }
	void test_case_3() { int Arg0 = 4; int Arr1[] = {3, 13, 6, 4, 9}; vector <int> Arg1(Arr1, Arr1 + (sizeof(Arr1) / sizeof(Arr1[0]))); int Arg2 = 5; verify_case(3, Arg2, maxWins(Arg0, Arg1)); }
	void test_case_4() { int Arg0 = 7; int Arr1[] = {7, 8, 9, 10}; vector <int> Arg1(Arr1, Arr1 + (sizeof(Arr1) / sizeof(Arr1[0]))); int Arg2 = 0; verify_case(4, Arg2, maxWins(Arg0, Arg1)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        PrimalUnlicensedCreatures ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
