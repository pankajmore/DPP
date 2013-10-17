#line 2 "ShorterSuperSum.cpp"

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

class ShorterSuperSum
        {
        public:
        int calculate(int k, int n)
            {
              int sum;
              vector <int> s(n);
              for(int i=0;i<n;i++) s[i]=i+1;
              for(int i=0;i<k;i++){
                sum=0;
                for(int j=0;j<n;j++) {
                  sum+=s[j];
                  s[j]=sum;
                }
              }
              return s[n-1];
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arg0 = 1; int Arg1 = 3; int Arg2 = 6; verify_case(0, Arg2, calculate(Arg0, Arg1)); }
	void test_case_1() { int Arg0 = 2; int Arg1 = 3; int Arg2 = 10; verify_case(1, Arg2, calculate(Arg0, Arg1)); }
	void test_case_2() { int Arg0 = 4; int Arg1 = 10; int Arg2 = 2002; verify_case(2, Arg2, calculate(Arg0, Arg1)); }
	void test_case_3() { int Arg0 = 10; int Arg1 = 10; int Arg2 = 167960; verify_case(3, Arg2, calculate(Arg0, Arg1)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        ShorterSuperSum ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
