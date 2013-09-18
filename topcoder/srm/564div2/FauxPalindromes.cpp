#line 2 "FauxPalindromes.cpp"

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

class FauxPalindromes
        {
        public:
	    bool is_palindrome(string word) {
		int i=0,j=SZ(word)-1;
		while(i<=j) if (word[i++] != word[j--]) return false;
		return true;
	    }
        string classifyIt(string word)
            {
		if(is_palindrome(word)) return "PALINDROME";
		string s;
		REP(i,SZ(word)) {
		    if(word[i+1] == word[i]) continue;
		    s.PB(word[i]);
		}
		//cout<<s<<endl;
		if(is_palindrome(s)) return "FAUX";
		else return "NOT EVEN FAUX";
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); if ((Case == -1) || (Case == 5)) test_case_5(); if ((Case == -1) || (Case == 6)) test_case_6(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arg0 = "ANA"; string Arg1 = "PALINDROME"; verify_case(0, Arg1, classifyIt(Arg0)); }
	void test_case_1() { string Arg0 = "AAAAANNAA"; string Arg1 = "FAUX"; verify_case(1, Arg1, classifyIt(Arg0)); }
	void test_case_2() { string Arg0 = "LEGENDARY"; string Arg1 = "NOT EVEN FAUX"; verify_case(2, Arg1, classifyIt(Arg0)); }
	void test_case_3() { string Arg0 = "XXXYTYYTTYX"; string Arg1 = "FAUX"; verify_case(3, Arg1, classifyIt(Arg0)); }
	void test_case_4() { string Arg0 = "TOPCOODEREDOOCPOT"; string Arg1 = "PALINDROME"; verify_case(4, Arg1, classifyIt(Arg0)); }
	void test_case_5() { string Arg0 = "TOPCODEREDOOCPOT"; string Arg1 = "FAUX"; verify_case(5, Arg1, classifyIt(Arg0)); }
	void test_case_6() { string Arg0 = "XXXXYYYYYZZXXYYY"; string Arg1 = "NOT EVEN FAUX"; verify_case(6, Arg1, classifyIt(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        FauxPalindromes ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
