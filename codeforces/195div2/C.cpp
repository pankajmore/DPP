#include <cstdio>
#include <cmath>
int foo(int p) {
    int c;
    while(p > 0 && p%2 == 0)
	{
	    p = p/2;
	    c++;
	}
    return c;
}
int main(int argc, char *argv[])
{
    int i,n,x,num,p=0,k=0;
    scanf("%d",&n);
    int a[n];
    for(i=0;i<n;i++) {
	scanf("%d",&a[i]);
	num = a[i];
	x = pow(2,foo(num));
	if (p < x) p = x;
    }
    for(i=0;i<n;i++) {
	if(a[i]>=p) k++;
    }
    printf("%d\n",k);
    for(i=0;i<n;i++) {
	if (a[i] >= p) printf("%d ",a[i]);
    }
    printf("\n");
    return 0;
}
