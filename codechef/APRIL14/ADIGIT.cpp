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

// Input macros
#define s(n)                        scanf("%d",&n)
#define sc(n)                       scanf("%c",&n)
#define sl(n)                       scanf("%lld",&n)
#define sf(n)                       scanf("%lf",&n)
#define ss(n)                       scanf("%s",n)

// Useful constants
#define INF                         (int)1e9
#define EPS                         1e-9

// Useful hardware instructions
#define bitcount                    __builtin_popcount
#define gcd                         __gcd

// Useful container manipulation / traversal macros
#define forall(i,a,b)               for(int i=a;i<b;i++)
#define foreach(v, c)               for( typeof( (c).begin()) v = (c).begin();  v != (c).end(); ++v)
#define all(a)                      a.begin(), a.end()
#define in(a,b)                     ( (b).find(a) != (b).end())
#define pb                          push_back
#define fill(a,v)                    memset(a, v, sizeof a)
#define sz(a)                       ((int)(a.size()))
#define mp                          make_pair

// Some common useful functions
#define maX(a,b)                     ( (a) > (b) ? (a) : (b))
#define miN(a,b)                     ( (a) < (b) ? (a) : (b))
#define checkbit(n,b)                ( (n >> b) & 1)
#define DREP(a)                      sort(all(a)); a.erase(unique(all(a)),a.end())
#define INDEX(arr,ind)               (lower_bound(all(arr),ind)-arr.begin())

#ifdef DEBUG
#define debug(args...)            {dbg,args; cerr<<endl;}
#else
#define debug(args...)              // Just strip off all debug tokens
#endif

struct debugger
{
    template<typename T> debugger& operator , (const T& v)
    {
        cerr<<v<<" ";
        return *this;
    }
} dbg;

template <typename T1, typename T2>
    inline std::ostream& operator << (std::ostream& os, const std::pair<T1, T2>& p)
    {
        return os << "(" << p.first << ", " << p.second << ")";
    }

    template<typename T>
    inline std::ostream &operator << (std::ostream & os,const std::vector<T>& v)
    {
        bool first = true;
        os << "[";
        for(unsigned int i = 0; i < v.size(); i++)
        {
            if(!first)
                os << ", ";
            os << v[i];
            first = false;
        }
        return os << "]";
    }

    template<typename T>
    inline std::ostream &operator << (std::ostream & os,const std::set<T>& v)
    {
        bool first = true;
        os << "[";
        for (typename std::set<T>::const_iterator ii = v.begin(); ii != v.end(); ++ii)
        {
            if(!first)
                os << ", ";
            os << *ii;
            first = false;
        }
        return os << "]";
    }

    template<typename T1, typename T2>
    inline std::ostream &operator << (std::ostream & os,const std::map<T1, T2>& v)
    {
        bool first = true;
        os << "[";
        for (typename std::map<T1, T2>::const_iterator ii = v.begin(); ii != v.end(); ++ii)
        {
            if(!first)
                os << ", ";
            os << *ii ;
            first = false;
        }
        return os << "]";
    }



int main(int argc, char *argv[])
{
    int n,m;
    cin>>n>>m;
    vector <int> B(n,0);
    int A[10][n+1];
    memset(A, 0 , sizeof A);
    for(int i=0;i<n;i++) {
	char ch;
	cin>>ch;
	B[i] = ch - '0';
	for(int j=0;j<10;j++) A[j][i+1] = A[j][i];
	A[B[i]][i+1] += 1;
    }
    // for(int i=0;i<n;i++) cout<<B[i]; cout<<endl;
    // for(int i=0;i<10;i++) {
    // 	for(int j=0;j<=n;j++) cout<<A[i][j]; cout<<endl;
    // }
    while(m--){
	int x,xx;
	cin>>x;
	x --;
	xx = B[x];
	int sum=0;
	for(int i=0;i<10;i++) {
	    sum += (A[i][x] * abs(xx - i));
	}
	cout<<sum<<endl;
    }
    return 0;
}
