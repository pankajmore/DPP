#include <stdio.h>
int main() {
    int i,n,x,y;
    scanf("%d",&n);
    for(i=1;i<=n;i++) {
	scanf("%d %d",&x,&y);
	if (x == y){
	    if ( x%2 == 0) printf("%d\n",2*y);
	    else printf("%d\n",2*y - 1);
	}
	else if (x == y + 2) {
	    if (x%2 == 0) printf ("%d\n",2*y + 2);
	    else printf ("%d\n",2*y + 1);
	}
	else printf ("No Number\n");
    }

return 0;
}
