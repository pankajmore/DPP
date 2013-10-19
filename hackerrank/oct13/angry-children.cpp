#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT */
  int N,K;
  cin>>N>>K;
  vector <int> A(N);
  for(int i=0;i<N;i++) cin>>A[i];
  sort(A.begin(),A.end());
  int min=A[K-1]-A[0];
  for(int i=0;i<N-K;i++) {
    int curr=A[i+K-1]-A[i];
    if(min>curr) min=curr;

  }
  cout<<min<<endl;
  return 0;
}
