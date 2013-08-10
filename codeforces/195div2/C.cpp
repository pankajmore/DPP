#include <cstdio>
#include <cmath>
int logbase2(long long n) {
    int r=0;
    while (n >>= 1) // unroll for more speed...
	{
	    r++;
	}
    return r;
}
int main(int argc, char *argv[])
{
    int i,n,num,x=0,p=0,k=0;
    scanf("%d",&n);
    long long a[n];
    for(i=0;i<n;i++) {
	scanf("%I64d",&a[i]);
	num = a[i];
	x = logbase2(num);
	if (p < x) p = x;
    }
    num = pow(2,p);
    for(i=0;i<n;i++) {
	if (a[i] >= num) k++;
    }
    printf("%d\n",k);
    for(i=0;i<n;i++) {
	if (a[i] >= num) printf("%I64d ",a[i]);
    }
    printf("\n");
    return 0;
}
