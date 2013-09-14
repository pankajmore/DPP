#include <algorithm>
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

typedef vector<int> VI;
#define REP(k,a) for(int k=0; k < (a); ++k)
#define SZ(x) ((int)((x).size()))
#define ALL(c) (c).begin(), (c).end()
#define PB push_back
#define MP make_pair
#define TR(c,i) for(typeof((c).begin() i = (c).begin(); i != (c).end(); i++)
#define present(c,x) ((c).find(x) != (c).end())
#define cpresent(c,x) (find(all(c),x) != (c).end())

int main(int argc, char *argv[])
{
    int a,b,c,m;
    int ab=0,bc=0,ca=0;
    cin>>a>>b>>c;
    m = max(a,b);
    m = max(m,c);
    if(m == c) {
	for(int i=0;i<=a;i++) {
	    ca = i;
	    if(c-ca<=b) bc = c - ca;
	    else continue;
	    if(a-ca == b-bc) {ab = a - ca;}
	    if((ca+ab==a) && (bc+ab == b) && (ca+bc==c)) {cout<<ab<<" "<<bc<<" "<<ca<<endl;exit(0);}
	}
    }
    if(m== b) {
	for(int i=0;i<=a;i++) {
	    ab = i;
	    if(b-ab<=c) bc = b-ab;
	    else continue;
	    if(a-ab == c-bc) {ca = a - ab;}
	    if((ca+ab==a) && (bc+ab == b) && (ca+bc==c)) {cout<<ab<<" "<<bc<<" "<<ca<<endl;exit(0);}
	}
    }
    if(m == a) {
	for(int i=0;i<=b;i++) {
	    ab = i;
	    if(a-ab<=c) ca = a-ab;
	    else continue;
	    if(b-ab == c-ca) {bc = b - ab;}
	    if((ca+ab==a) && (bc+ab == b) && (ca+bc==c)) {cout<<ab<<" "<<bc<<" "<<ca<<endl;exit(0);}
	}
    }
    cout<<"Impossible"<<endl;
    return 0;
}
