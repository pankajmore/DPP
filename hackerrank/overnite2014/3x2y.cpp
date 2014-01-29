#include<iostream>
#define ULL unsigned long long
using namespace std;
ULL f(ULL x,ULL y){
    if(x==0 && y==0)
	return 0;
    ULL xx=x/3,yy=y/2;
    int m=x%3,n=y%2;
    if((m==0 && n==0) || (m==2 && n==0))
	return f(xx,yy);
    if((m==1 && n==0) || (m==0 && n==1) || (m==2 && n==1))
	return 1 + f(xx,yy);
    if((m==1 && n==1))
	return 2 + f(xx,yy);
}
int main(int argc, char *argv[])
{
    int T;
    cin>>T;
    while(T--){
	ULL x,y;
	cin>>x>>y;
	cout<<f(x,y)<<endl;
    }
    return 0;
}
