#include <iostream>
#include <cmath>
#include <vector>
#include<set>
using namespace std;
typedef vector<int> VI;
VI v;
void permute(int d,int c,long n){
  if(c==0) cout<<n<<" ";
  else {
    for(int i=0;i<10;i++) {
      permute(d,c-1,(n+i*pow(10,d-c)));
    }
  }
}
int main(int argc, char *argv[])
{
  int d;
  cin>>d;
  permute(d,d,0);
  cout<<v.size()<<endl;
  return 0;
}
