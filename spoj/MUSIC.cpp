#include <cstdio>
#include <assert.h>
#include <vector>
using namespace std;
int main(int argc, char *argv[])
{
    int i,c=0,x,y,sum,n;
    vector <int> a;
    scanf("%d",&n);
    a.resize(n);
    for(i=0;i<n;i++) scanf("%d",&a[i]);

    for(i=0;i<n;i++) {
	if (a[i] == 0) {c=-1;break;}
	if (a[i] < 0) {
	    x = i;
	    y = x;
	    sum = 0;
	    while(a[y] < 0) {
		sum += a[y];
		y++;
	    }
	    y--;
	    assert(y >= x);
	    assert(sum < 0);
	    a[x-1] += sum;a[y+1] += sum;
	    a[x] -= sum;a[y] -= sum;
  	    // printf("x=%d,y=%d\n",x,y);
	    c++;
	    //	    i = 0;
	    if(a[i-1] < 0) i-=2;
	    else if(a[i] < 0) i-=1;
	    else ;
	}
    }
    printf("%d\n",c);

    //    for(i=0;i<n;i++) assert(a[i]>=0);
    return 0;
}
