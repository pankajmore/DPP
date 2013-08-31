#line 2 "BusinessTasks.cpp"

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

typedef long long ll;
typedef unsigned int ui;

using namespace std;
class BusinessTasks
        {
        public:
        string getTask(vector <string> list, int n)
            {
		int count=0,tc=0,m;
		m = list.size();
		for(vector<string>::iterator it=list.begin();;) {
		    if(it == list.end()) it = list.begin();
		    count++;
		    if(count == n) {it = list.erase(it);count=0;tc++;}
		    else it++;

		    if(tc == m - 1) break;
		}
		return list[0];
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); if ((Case == -1) || (Case == 5)) test_case_5(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arr0[] = {"a","b","c","d"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; string Arg2 = "a"; verify_case(0, Arg2, getTask(Arg0, Arg1)); }
	void test_case_1() { string Arr0[] = {"a","b","c","d","e"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 3; string Arg2 = "d"; verify_case(1, Arg2, getTask(Arg0, Arg1)); }
	void test_case_2() { string Arr0[] = {"alpha","beta","gamma","delta","epsilon"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; string Arg2 = "epsilon"; verify_case(2, Arg2, getTask(Arg0, Arg1)); }
	void test_case_3() { string Arr0[] = {"a","b"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1000; string Arg2 = "a"; verify_case(3, Arg2, getTask(Arg0, Arg1)); }
	void test_case_4() { string Arr0[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
"u","v","w","x","y","z"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 17; string Arg2 = "n"; verify_case(4, Arg2, getTask(Arg0, Arg1)); }
	void test_case_5() { string Arr0[] = {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
"qgcxjbfx","my","mlhy","bt","bo","q"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 9000000; string Arg2 = "fxjqzznvg"; verify_case(5, Arg2, getTask(Arg0, Arg1)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        BusinessTasks ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
