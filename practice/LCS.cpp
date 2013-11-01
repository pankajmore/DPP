#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int LCS(string aa,string bb){

  string a = string("x") + aa;
  string b = string("y") + bb;
  int N=a.size();
  vector <vector <int> > A(N,vector <int>(N,0));
  for(int i=0;i<N;i++) {
    A[i][0] = 0;
    A[0][i] = 0;
  }
  for(int i=1;i<N;i++) {
    for(int j=1;j<N;j++){
      if(a[i]==b[j]) A[i][j] = A[i-1][j-1] + 1;
      else A[i][j] = max(A[i-1][j],A[j-1][i]);
    }
  }
  return A[N-1][N-1];
}

int main() {
  string a,b;
  cin>>a>>b;
  cout<<LCS(a,b)<<endl;
  return 0;
}
