#include <iostream>
#include <unordered_set>
#include <vector>
#include <cstdio>

using namespace std;

vector <int> seqSum(vector <int> A,int sum){
  int N = A.size();
  vector <int> S(N,0);
  vector <int> res;
  S[0] = A[0];//cout<<S[0]<<endl;
  for(int i=1;i<N;i++) {S[i] = S[i-1]+A[i];}
  unordered_set <int> B;
  for(int i=0;i<N;i++) B.insert(S[i]+sum);
  int i;
  for(i=0;i<N;i++) {
    if(B.find(S[i]) != B.end()) {
      res.push_back(i);
      break;
    }
  }
  int j;
  for(j=0;j<=N;j++) {
    if(S[res[0]] - S[j] == sum) {
      res.push_back(j);
      break;
    }
  }
  //cout<<res[1]<<" "<<res[0]<<endl;
  return res;
}

int main(int argc, char *argv[])
{
  int N;
  cin>>N;
  vector <int> A(N);
  for(int i=0;i<N;i++) cin>>A[i];
  int sum;
  cin>>sum;
  vector <int> res(seqSum(A,sum));
  //cout<<res[1]<<" "<<res[0]<<endl;
  for(int i=res[1]+2;i<=res[0]+1;i++) cout<<i<<" ";
  cout<<endl;
  return 0;
}
