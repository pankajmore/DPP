#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT */
  int i,j,k,f=0,x,T,N,K;
  vector <int> A,B;
  cin>>T;
  for(i=0;i<T;i++) {
    f=0;
    A.erase(A.begin(),A.end());
    B.erase(B.begin(),B.end());
    cin>>N>>K;
    for(j=0;j<N;j++) {cin>>x;A.push_back(x);}
    for(j=0;j<N;j++) {cin>>x;B.push_back(x);}

    sort(A.begin(),A.end());
    sort(B.rbegin(),B.rend());
    for(j=0;j<N;j++) {
      if(A[j]+B[j] < K) {f=1;break;}
    }
    if(f==1) cout<<"NO\n"; else cout<<"YES\n";

  }
  return 0;
}
