#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void print(vector<int>& A) {
  for(int i=0;i<A.size();i++) cout<<A[i]<<" ";
  cout<<endl;
}

int partition(vector<int>& A,int left,int right,int pi) {
  int pv=A[pi];
  swap(A[pi],A[right]);
  int j=left;
  for(int i=left;i<right;i++) {
    if(A[i]<pv) swap(A[i],A[j++]);
  }
  swap(A[j],A[right]);
  return j;
}

int select(vector<int>& A,int left,int right,int k){
  if(left==right) return A[left];
  int pi=left;
  int pni=partition(A,left,right,pi);
  //print(A);
  int d=pni-left+1;
  //cout<<pni<<" "<<d<<" "<<k<<endl;
  if(d==k) return A[pni];
  else if(d>k) return select(A,left,pni-1,k);
  else return select(A,pni+1,right,k-d);
}

int main() {
  int N;
  cin>>N;
  vector <int> A(N);
  for(int i=0;i<N;i++) cin>>A[i];

  cout<<select(A,0,N-1,(N+1)/2);
  return 0;
}
