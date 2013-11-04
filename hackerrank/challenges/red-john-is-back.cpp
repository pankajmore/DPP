#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  int T,N;
  vector <int> A(41,0);
  A[0] = 1;
  A[1] = 1;
  A[2] = 1;
  A[3] = 1;
  for(int i=4;i<=40;i++) A[i] = A[i-1] + A[i-4];
  vector <bool> P(220000,1);
  P[0] = P[1] = 0;
  for(int i=2;i< (int)sqrt((double)220000);i++) {
    if(P[i] == 1) {
      for(int j=i*i;j<220000;j+=i) {
        P[j] = 0;
      }
    }
  }
    cin>>T;
  while(T--) {
    cin>>N;
    int Z = A[N];
    int sum=0;
    for(int i=0;i<=Z;i++) {
      if(P[i]==1) sum++;
    }
    cout<<sum<<endl;
  }
  return 0;
}
