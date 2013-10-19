#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT */
  int T;
  cin>>T;
  for(int i=0;i<T;i++) {
    int w=0;
    int sum=0;
    int N,C,M;
    cin>>N>>C>>M;
    sum+=N/C;w=N/C;
    if(w<M) {cout<<sum<<endl;}
    else {
      while(w>=M) {
        sum+=(w/M);
        w=w%M + (w/M);
      }
      cout<<sum<<endl;
    }
  }
  return 0;
}
