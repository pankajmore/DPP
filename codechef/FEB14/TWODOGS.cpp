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

typedef unsigned long long ULL;
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
const int Z = 1000000+1;

int main(int argc, char *argv[])
{
    int N,K,m;
    cin>>N>>K;
    m = N;
    vector <int> A(N,0);
    vector <int> L(Z,-1),R(Z,-1);
    for(int i=0;i<N;i++) {
	cin>>A[i];
	if(L[A[i]] == -1) {L[A[i]] = i;R[A[i]] = i;}
	else R[A[i]] = i;
    }
    vector <int> S(A);
    sort(S.begin(),S.end());
    for(int i=0;i<S.size();i++){
	if(2*S[i] != K && binary_search(S.begin(),S.end(),K-S[i])){
	    int lx,rx,ly,ry;
	    lx = L[S[i]];rx=R[S[i]];ly=L[K-S[i]];ry=R[K-S[i]];
	    vector <int> mm;
	    mm.PB(max(lx+1,ly+1));
	    mm.PB(max(N-rx,N-ry));
	    mm.PB(max(lx+1,N-ry));
	    mm.PB(max(N-rx,ly+1));
	    m = min(m,*min_element(mm.begin(),mm.end()));
	}
    }
    if(m==N) cout<<-1<<endl;
    else cout<<m<<endl;
    return 0;
}
