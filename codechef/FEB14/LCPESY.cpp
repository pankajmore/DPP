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

int main(int argc, char *argv[])
{
    int T;
    cin>>T;
    while(T--){
	string A,B;
	cin>>A>>B;
	int AA[128],BB[128];
	memset(AA,0,128*sizeof(*AA));
	memset(BB,0,128*sizeof(*BB));
	for(int i=0;i<A.length();i++){
	    AA[A[i]] += 1;
	}
	for(int i=0;i<B.length();i++){
	    BB[B[i]] += 1;
	}
	int sum=0;
	for(int i=0;i<127;i++){
	    sum+= (AA[i]<BB[i])?AA[i]:BB[i];
	}
	cout<<sum<<endl;
    }
    return 0;
}
