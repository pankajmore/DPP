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
	string s,t;
	cin>>s>>t;
	int A[26],B[26];
	memset(A,0,26*sizeof(int));
	memset(B,0,26*sizeof(int));
	int c = 1;
	A[s[0]-'a'] = 1;
	B[t[0]-'a'] = 1;
	for(int i=1;i<s.length();i++){
	    if(s[i] == s[i-1]) {
		c++;
	    }
	    else c=1;
	    if(c > A[s[i]-'a']) A[s[i]-'a'] = c;
	}
	c = 1;
	for(int i=1;i<t.length();i++){
	    if(t[i] == t[i-1]) {
		c++;
	    }
	    else c=1;
	    if(c > B[t[i]-'a']) B[t[i]-'a'] = c;
	}
	//	for(int i=0;i<26;i++) cout<<A[i]<<" ";cout<<endl;
	//	for(int i=0;i<26;i++) cout<<B[i]<<" ";cout<<endl;
	int m=0;
	for(int i=0;i<26;i++){
	    if(m < A[i]+B[i]) m = A[i]+B[i];
	}
    cout<<m<<endl;
    }
    return 0;
}
