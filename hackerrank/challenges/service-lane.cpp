#include<iostream>
#include<vector>

using namespace std;

int main(){
    int i,r,j,N,T;
    cin>>N>>T;
    vector<int> A(N,0);
    for(int i=0;i<N;i++) cin>>A[i];
    while(T--){
	cin>>i>>j;
	r = 3;
	for(int k=i;k<=j;k++){
	    r = (r > A[k])?A[k]:r;
	}
	cout<<r<<endl;
    }
    return 0;
