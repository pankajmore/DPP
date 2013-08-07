#include <cstdio>
int last(int a) {
    return a%10;
}
int lastdig(int a,long b) {
    if (b==0) return 1;
    a = last(a);
    int r;
    switch (a) {
    case 0:
	return 0;
    case 1:
	return 1;
    case 2:
	r = b%4;
	if (r==0) return 6;
	if (r==1) return 2;
	if (r==2) return 4;
	if (r==3) return 8;
    case 3:
	r = b%4;
	if (r==0) return 1;
	if (r==1) return 3;
	if (r==2) return 9;
	if (r==3) return 7;
    case 4:
	r = b%2;
	if (r==0) return 6;
	if (r==1) return 4;
    case 5:
	return 5;
    case 6:
	return 6;
    case 7:
	r = b%4;
	if (r==0) return 1;
	if (r==1) return 7;
	if (r==2) return 9;
	if (r==3) return 3;
    case 8:
	r = b%4;
	if (r==0) return 6;
	if (r==1) return 8;
	if (r==2) return 4;
	if (r==3) return 2;
    case 9:
	r = b%2;
	if (r==0) return 1;
	if (r==1) return 9;
    }
}
int main(int argc, char *argv[])
{
    int t,i,a;
    long b;
    scanf("%d",&t);
    for(i=0;i<t;i++) {
	scanf("%d %ld",&a,&b);
	printf("%d\n",lastdig(a,b));
    }
    return 0;
}
