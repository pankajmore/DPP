#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(int argc, char *argv[])
{
    int T;
    cin>>T;
    while(T--){
	int N,K;
	cin>>N>>K;
	vector<int> B(N),G(N);
	for(int i=0;i<N;i++) cin>>G[i];
	for(int i=0;i<N;i++) cin>>B[i];
	sort(G.begin(),G.end());
	sort(B.rbegin(),B.rend());
	int c=0;
	for(int i=0;i<N;i++) c+=(G[i]*B[i]);
	//cout<<c<<endl;
	if(c<=K) cout<<"YES"<<endl;
	else cout<<"NO"<<endl;
    }
    return 0;
}
