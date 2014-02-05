#include <iostream>
#include <cstring>
typedef unsigned long long ULL;
const int N=1000000;
using namespace std;
ULL foo(ULL y);
ULL cycle(ULL n);
ULL A[N+1];
ULL foo(ULL y){
    if(y <= N) {
	if(A[y]==0) {
	    A[y] = 1 + cycle(y);
	}
	return A[y];
    }
    else{
	return 1+cycle(y);
    }
}

ULL cycle(ULL n){
    if(n==1) return 1;
    ULL y;
    if(n%2==1){
	y = 3*n+1;
    }
    else {
	y = n/2;
    }
    return foo(y);
}
ULL max(int i,int j){
    if(j<i) {
	i = i^ j;
	j = i ^ j;
	i = i ^ j;
    }
    int m = i;
    ULL v=A[i];
    for(int k=i;k<=j;k++){
	if(A[k]>v) {
	    v = A[k];
	    m = k;
	}
    }
    return v;
}
int main(int argc, char *argv[])
{
    memset(A,0,sizeof(A));
    A[0] = 0;
    A[1] = 1;
    for(int i=2;i<=N;i++){
	if(A[i]==0) {
	    cycle(i);
	}
    }
    int i,j;
    while(cin>>i>>j){
	cout<<i<<" "<<j<<" "<<max(i,j)<<endl;
    }
    return 0;
}
