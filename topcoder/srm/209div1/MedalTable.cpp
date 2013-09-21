#line 2 "MedalTable.cpp"

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
#include <iterator>

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
#define TR(c,i) for(typeof((c).begin()) i = (c).begin(); i != (c).end(); i++)
#define present(c,x) ((c).find(x) != (c).end())
#define cpresent(c,x) (find(all(c),x) != (c).end())

bool mycomp(string a,string d) {
  VS x;VS y;
  istringstream aa(a);
  copy(istream_iterator<string>(aa),
       istream_iterator<string>(),
       back_inserter<vector<string> >(x));
  //  REP(i,SZ(x)) cout<<x[i]<<endl;
  istringstream bb(d);
  copy(istream_iterator<string>(bb),
       istream_iterator<string>(),
       back_inserter<vector<string> >(y));
  int g,b,s;
  g=atoi(x[1].c_str()) - atoi(y[1].c_str());
  s=atoi(x[2].c_str()) - atoi(y[2].c_str());
  b=atoi(x[3].c_str()) - atoi(y[3].c_str());
  if(g>0) return true;
  if(g==0 && s>0) return true;
  if(g==0 && s==0 && b>0) return true;
  if(g==0 && s==0 && b==0 && (x[0] < y[0])) return true;
  return false;
}

class MedalTable
        {
        public:
        vector <string> generate(vector <string> results)
            {
              set<string> c;
              REP(i,SZ(results)) {
                c.insert(results[i].substr(0,3));
                c.insert(results[i].substr(4,3));
                c.insert(results[i].substr(8,3));
              }
              //                            TR(c,i) cout<<*i<<endl;
              VS cc;
              for(set<string>::iterator i=c.begin();i!=c.end();i++) cc.PB(*i);
              VS rt;
              int g=0,s=0,b=0;
              REP(i,SZ(cc)) {
                g=0;s=0;b=0;
                REP(j,SZ(results)) {
                  if(results[j].substr(0,3)==cc[i]) g++;
                  if(results[j].substr(4,3)==cc[i]) s++;
                  if(results[j].substr(8,3)==cc[i]) b++;
                }
                // char* z[50];
                // sprintf(z,"%d %d %d",g,s,b);
                // string zz(z);
                rt.PB(cc[i]+" "+std::to_string(static_cast<long long>(g))+" "+std::to_string(static_cast<long long>(s))+" "+std::to_string(static_cast<long long>(b)));
              }
              sort(rt.begin(),rt.end(),mycomp);
              return rt;
            }



        };



// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
