#line 2 "ThePalindrome.cpp"

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

bool is_palindrome(string s) {
  string r=s;
  reverse(r.begin(),r.end());
  return (s==r);
}

class ThePalindrome
        {
        public:
        int find(string s)
            {
              string x=s;
              int n=x.size();
              for(int i=0;i<n;i++) {
                string x=s;
                string y=x.substr(0,i);
                reverse(y.begin(),y.end());
                x += y;
                //cout<<x<<endl;
                if(is_palindrome(x)) return n+i;
              }
              return -1;
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arg0 = "abab"; int Arg1 = 5; verify_case(0, Arg1, find(Arg0)); }
	void test_case_1() { string Arg0 = "abacaba"; int Arg1 = 7; verify_case(1, Arg1, find(Arg0)); }
	void test_case_2() { string Arg0 = "qwerty"; int Arg1 = 11; verify_case(2, Arg1, find(Arg0)); }
	void test_case_3() { string Arg0 = "abdfhdyrbdbsdfghjkllkjhgfds"; int Arg1 = 38; verify_case(3, Arg1, find(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        ThePalindrome ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
