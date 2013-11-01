#include <iostream>
#include <malloc.h>
#include <cmath>
using namespace std;
void walk(int M,int N,int ** A) {
  int ** B;
  B = (int **)malloc(M * sizeof(*B));
  for(int i=0;i<M;i++) B[i] = (int *)malloc(N*sizeof(B[i]));
  for(int i=0;i<M;i++) {B[i][0] = 1;B[0][i] = 1;}
  for(int i=1;i<M;i++) {
    for(int j=1;j<N;j++) {
      B[i][j]=1;
      if(abs(A[i][j-1] - A[i][j]) == 1) if(B[i][j]<(A[i][j-1]+1)) B[i][j]=A[i][j-1]+1;
      if(abs(A[i-1][j] - A[i][j]) == 1) if(B[i][j]<(A[i-1][j]+1)) B[i][j]=A[i][j-1]+1;
    }
  }
  int max=0;
  for(int i=0;i<M;i++) {
    for(int j=0;j<N;j++) {
      if(max<A[i][j]) max=A[i][j];
    }
  }
  cout<<max<<endl;
}

int main(int argc, char *argv[])
{
  int N,M;
  cin>>M>>N;
  int ** A;
  A = (int **)malloc(M * sizeof(*A));
  for(int i=0;i<M;i++) A[i] = (int *)malloc(N*sizeof(A[i]));
  for(int i=0;i<M;i++) {
    for(int j=0;j<N;j++) cin>>A[i][j];
  }
  walk(M,N,A);
  return 0;
}
