#include <iostream>
#include <malloc.h>
using namespace std;
void spiral(int M,int N,int ** A) {
  int min=M;
  if(min > N) min=N;
  for(int s=0;s<min/2;s++) {
    int i=s;
    int j=s;
    for(;j<N-1-s;j++) cout<<A[i][j]<<" ";
    for(;i<M-1-s;i++) cout<<A[i][j]<<" ";
    for(;j>s;j--) cout<<A[i][j]<<" ";
    for(;i>s;i--) cout<<A[i][j]<<" ";
  }
  cout<<endl;
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
  spiral(M,N,A);
  return 0;
}
