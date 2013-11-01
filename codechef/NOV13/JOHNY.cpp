#include <iostream>
#include <algorithm>
#include <vector>
#include <assert.h>

using namespace std;
int main(int argc, char *argv[])
{
  int T;
  cin>>T;
  for(int i=0;i<T;i++) {
    int N,K;
    cin>>N;
    vector <int> A(N);
    for(int j=0;j<N;j++) cin>>A[j];
    cin>>K;
    int X=A[K-1];
    sort(A.begin(),A.end());
    vector<int>::iterator it=find(A.begin(),A.end(),X);
    assert(*it==X);
    assert(A[it-A.begin()]==X);
    int pos = it - A.begin();
    cout<<pos+1<<endl;
  }
  return 0;
}
