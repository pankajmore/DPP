#include <cstdio>
#include <set>
#include <assert.h>
int main(int argc, char *argv[])
{
    int n,i,j,k,count=0;
    scanf("%d",&n);
    for(j=1,k=n*n;count < n*n;j++,k--) {
	printf("%d %d ",j,k);count +=2;
	if (count % n == 0) printf("\n");
    }
    return 0;
}
