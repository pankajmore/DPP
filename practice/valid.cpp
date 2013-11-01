#include <iostream>
#include <cmath>
#include <vector>
#include<set>
using namespace std;
typedef vector<int> VI;
VI v;
void valid(int d,int c,int i,long n){
  if(c==0) {cout<<n<<endl;v.push_back(n);}
  else {
    for(int j=i;j<=10-c;j++) {
      valid(d,c-1,j,(n+(long)(j*pow(10,d-c))));
    }
  }
}
int main(int argc, char *argv[])
{
  int d;
  cin>>d;
  valid(d,d,0,0);
  cout<<v.size()<<endl;
  set <int> s(v.begin(),v.end());
  cout<<(s.size()==v.size())<<endl;
  return 0;
}
