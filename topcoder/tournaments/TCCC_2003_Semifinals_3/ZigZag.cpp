#line 2 "ZigZag.cpp"

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

class ZigZag
        {
        public:
        int longestZigZag(vector <int> sequence)
            {
              int n=sequence.size();
              if(n==1) return 1;
              vector <int> A(sequence);
              vector <int> S(n,1);
              vector <bool> G(n,0);

              S[0]=1;
              if(A[1]==A[0]) {S[1]=1;}
              else {S[1]=2;}
              if(A[1]-A[0]>0) {G[1]=1;G[0]=0;}
              else {G[1]=0;G[0]=1;}
              for(int i=2;i<n;i++) {
                for(int j=0;j<i;j++) {
                  int x=A[i]-A[j];
                  if(((x>0 && G[j]==0) || (x<0 && G[j]==1)) && (S[j]+1>S[i])) {
                    S[i]=S[j]+1;
                    if(x>0) G[i]=1; else G[i]=0;
                  }
                }
                //cout<<S[i]<<" ";
              }
              return S[n-1];
            }


        };



// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
