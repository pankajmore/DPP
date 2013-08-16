#include <cstdio>
int main(int argc, char *argv[])
{
    int i,n,m,k,s,r;
    long long p;
    scanf("%d %d %d",&n,&m,&k);
    s = n/k;
    r = n - m;
    p = 0;
    for(i=1;i<=(m/k);i++) {
        p = (p+k-1);m=m - k + 1;
	if (r < s) { p = (2* (p+1)); m--;s--;}
    }
    p +=m;
    p = p % 1000000009;
    printf("%I64d\n",p);
    return 0;
}
