#include <cstdio>
#include <algorithm>
using namespace std;
int gcd ( int a, int b )
{
  int c;
  while ( a != 0 ) {
     c = a; a = b%a;  b = c;
  }
  return b;
}
int main(int argc, char *argv[])
{
    int a,b,c,d,p,q,g,r;
    scanf("%d %d %d %d",&a,&b,&c,&d);
    g = gcd(a,b);
    a /= g; b/=g;
    g = gcd(c,d);
    c/= g; d/=g;
    if ((a*d) - (b*c) > 0) {
	if ( b > d) { p = (a*d) - (c*b); q = a * d;}
	else { p = (a*b) - (c*d); q = a*b;}
    }
    else {
	if ( a > c) { p = (a*b) - (c*d); q = a*b;}
	else { p = (b*c) - (a*d); q = b*c;}
    }
        g = gcd(p,q);
    p/=g;q/=g;
    printf("%d/%d\n",p,q);
    return 0;
}
