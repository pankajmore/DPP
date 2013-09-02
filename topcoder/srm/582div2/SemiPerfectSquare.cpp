#line 2 "SemiPerfectSquare.cpp"

#include <algorithm>
#include <complex>
#include <exception>
#include <list>
#include <stack>
#include <bitset>
#include <csetjmp>
#include <fstream>
#include <locale>
#include <stdexcept>
#include <cassert>
#include <csignal>
#include <functional>
#include <map>
#include <cctype>
#include <cstdarg>
#include <iomanip>
#include <memory>
#include <streambuf>
#include <cerrno>
#include <cstddef>
#include <ios>
#include <new>
#include <string>
#include <cfloat>
#include <cstdio>
#include <iosfwd>
#include <numeric>
#include <typeinfo>
#include <ciso646>
#include <cstdlib>
#include <iostream>
#include <ostream>
#include <utility>
#include <climits>
#include <cstring>
#include <istream>
#include <queue>
#include <valarray>
#include <clocale>
#include <ctime>
#include <iterator>
#include <set>
#include <vector>
#include <cmath>
#include <deque>
#include <limits>
#include <sstream>
using namespace std;

typedef long long LL;
typedef long double LD;
typedef vector<string> VS;
typedef pair<int,int> PII;

#define FOR(k,a,b) for(typeof(a) k=(a); k <= (b); ++k)
#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))
#define ALL(c) (c).begin(), (c).end()
#define PB push_back
#define MP make_pair

class SemiPerfectSquare
        {
        public:
        string check(int N)
            {
		int p;
		FOR(i,2,33) {
		    p = i*i;
		    if(N < p) return "No";
		    if(N % p == 0) {
			if((N/p) < i) return "Yes";
			else continue;
		    }
		}
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arg0 = 48; string Arg1 = "Yes"; verify_case(0, Arg1, check(Arg0)); }
	void test_case_1() { int Arg0 = 1000; string Arg1 = "No"; verify_case(1, Arg1, check(Arg0)); }
	void test_case_2() { int Arg0 = 25; string Arg1 = "Yes"; verify_case(2, Arg1, check(Arg0)); }
	void test_case_3() { int Arg0 = 47; string Arg1 = "No"; verify_case(3, Arg1, check(Arg0)); }
	void test_case_4() { int Arg0 = 847; string Arg1 = "Yes"; verify_case(4, Arg1, check(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        SemiPerfectSquare ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
