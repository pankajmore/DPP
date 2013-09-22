#line 2 "CucumberMarket.cpp"

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
#define ALL(c) (c).begin(), (c).end()

class CucumberMarket
        {
        public:
        string check(vector <int> price, int budget, int k)
            {
              sort(price.rbegin(),price.rend());
              int s=0;
              REP(i,k) {s+=price[i];}
              if(s>budget) return "NO";
              else return "YES";
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { int Arr0[] = {1000,1,10,100}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1110; int Arg2 = 3; string Arg3 = "YES"; verify_case(0, Arg3, check(Arg0, Arg1, Arg2)); }
	void test_case_1() { int Arr0[] = {1000,1,10,100}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1109; int Arg2 = 3; string Arg3 = "NO"; verify_case(1, Arg3, check(Arg0, Arg1, Arg2)); }
	void test_case_2() { int Arr0[] = {33,4}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 33; int Arg2 = 1; string Arg3 = "YES"; verify_case(2, Arg3, check(Arg0, Arg1, Arg2)); }
	void test_case_3() { int Arr0[] = {1,1,1,1,1,1}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; int Arg2 = 4; string Arg3 = "NO"; verify_case(3, Arg3, check(Arg0, Arg1, Arg2)); }
	void test_case_4() { int Arr0[] = {1000,1000,1000,1000,1000,1000,1000,1000,1000}; vector <int> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 10000; int Arg2 = 9; string Arg3 = "YES"; verify_case(4, Arg3, check(Arg0, Arg1, Arg2)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        CucumberMarket ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
