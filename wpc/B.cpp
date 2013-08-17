#include<cstdio>
long long gcd ( long long a, long long b )
{
    long long c;
    while ( a != 0 ) {
	c = a; a = b%a;  b = c;
    }
    return b;
}
long long foo(long long n){
    long long x = n/2;
    while(x>0) {
	if(gcd(n,x) == 1) return x;
	else x--;
    }
}
int main(int argc, char *argv[])
{
    int i,T;
    long long n;
    scanf("%d",&T);
    for(i=0;i<T;i++) {
	scanf("%lld",&n);
	printf("%lld\n",foo(n));
    }
    return 0;
}
