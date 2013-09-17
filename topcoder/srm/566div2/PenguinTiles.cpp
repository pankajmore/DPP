#line 2 "PenguinTiles.cpp"

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

class PenguinTiles
        {
        public:
        int minMoves(vector <string> tiles)
            {
		int m=SZ(tiles);
		int n=SZ(tiles[0]);
		if(tiles[m-1][n-1] == '.') return 0;
		for(int i=0;i<n;i++) {
		    if((tiles[m-1][i] == '.') || (tiles[i][n-1] == '.'))
			{
			    return 1;
			}
		}
		return 2;
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arr0[] = {"PP",
 "P."}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 0; verify_case(0, Arg1, minMoves(Arg0)); }
	void test_case_1() { string Arr0[] = {"PPPPPPPP",
 ".PPPPPPP"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(1, Arg1, minMoves(Arg0)); }
	void test_case_2() { string Arr0[] = {"PPP",
 "P.P",
 "PPP"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; verify_case(2, Arg1, minMoves(Arg0)); }
	void test_case_3() { string Arr0[] = {"P.",
 "PP",
 "PP",
 "PP"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(3, Arg1, minMoves(Arg0)); }
	void test_case_4() { string Arr0[] = {".PPP",
 "PPPP",
 "PPPP",
 "PPPP"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; verify_case(4, Arg1, minMoves(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        PenguinTiles ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
