#line 2 "WolfDelaymaster.cpp"

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


class WolfDelaymaster
        {
        public:
        string check(string str)
            {
              int i,N,wc=0;
              N = SZ(str);
              //if(N%4!=0) return "INVALID";
              while(N>0) {
                wc=0;
                if(str[0] != 'w') break;
                for(i=0;i<N;i++) {
                  if(str[i]=='w') wc++;
                  else break;
                }
                string s;
                for(i=0;i<wc;i++) {s+='w';}
                for(i=0;i<wc;i++) {s+='o';}
                for(i=0;i<wc;i++) {s+='l';}
                for(i=0;i<wc;i++) {s+='f';}
                if(str.substr(0,(wc*4)) == s) {
                  str=str.substr(wc*4);//cout<<str<<endl;
                  N=SZ(str);
                }
                else return "INVALID";
              }
              if(N==0) return "VALID";
              else return "INVALID";
            }

// BEGIN CUT HERE
	public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); }
	private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const string &Expected, const string &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arg0 = "wolf"; string Arg1 = "VALID"; verify_case(0, Arg1, check(Arg0)); }
	void test_case_1() { string Arg0 = "wwolfolf"; string Arg1 = "INVALID"; verify_case(1, Arg1, check(Arg0)); }
	void test_case_2() { string Arg0 = "wolfwwoollffwwwooolllfffwwwwoooollllffff"; string Arg1 = "VALID"; verify_case(2, Arg1, check(Arg0)); }
	void test_case_3() { string Arg0 = "flowolf"; string Arg1 = "INVALID"; verify_case(3, Arg1, check(Arg0)); }

// END CUT HERE

        };

    // BEGIN CUT HERE
    int main()
        {
        WolfDelaymaster ___test;
        ___test.run_test(-1);
        }
    // END CUT HERE
