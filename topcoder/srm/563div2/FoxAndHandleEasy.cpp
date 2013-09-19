#line 2 "FoxAndHandleEasy.cpp"

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

typedef long long LL;
typedef long double LD;
typedef vector<int> VI;
typedef vector<string> VS;
typedef pair<int,int> PII;
#define FOR(k,a,b) for(typeof(a) k=(a); k <= (b); ++k)
#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))
#define ALL(c) (c).begin(), (c).end()
#define PB push_back
#define MP make_pair
#define TR(c,i) for(typeof((c).begin() i = (c).begin(); i != (c).end(); i++)
#define present(c,x) ((c).find(x) != (c).end())
#define cpresent(c,x) (find(all(c),x) != (c).end())

class FoxAndHandleEasy
        {
        public:
        string isPossible(string S, string T)
            {
		string s=S;
		REP(i,SZ(S)) {
		    s.insert(i+1,S);
		    if(s==T) return "Yes";
		    s=S;
		}
		return "No";
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); if ((Case == -1) || (Case == 5)) test_case_5(); if ((Case == -1) || (Case == 6)) test_case_6(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arg0 = "Ciel"; string Arg1 = "CieCiell"; string Arg2 = "Yes"; verify_case(0, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_1() { string Arg0 = "Ciel"; string Arg1 = "FoxCiel"; string Arg2 = "No"; verify_case(1, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_2() { string Arg0 = "FoxCiel"; string Arg1 = "FoxFoxCielCiel"; string Arg2 = "Yes"; verify_case(2, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_3() { string Arg0 = "FoxCiel"; string Arg1 = "FoxCielCielFox"; string Arg2 = "No"; verify_case(3, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_4() { string Arg0 = "Ha"; string Arg1 = "HaHaHaHa"; string Arg2 = "No"; verify_case(4, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_5() { string Arg0 = "TheHandleCanBeVeryLong"; string Arg1 = "TheHandleCanBeVeryLong"; string Arg2 = "No"; verify_case(5, Arg2, isPossible(Arg0, Arg1)); }
	void test_case_6() { string Arg0 = "Long"; string Arg1 = "LongLong"; string Arg2 = "Yes"; verify_case(6, Arg2, isPossible(Arg0, Arg1)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        FoxAndHandleEasy ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
