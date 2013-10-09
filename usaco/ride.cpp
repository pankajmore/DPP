/*
  ID: pankajm2
  PROG: ride
  LANG: C++
*/
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
  ofstream fout ("ride.out");
  ifstream fin ("ride.in");
  int a=1,b=1;
  string c,g;
  fin>>c>>g;
  //cout<<c<<" "<<g<<endl;
  for(int i=0;i<c.size();i++) {
    a*=(c[i]-'A'+1);
  }
  for(int i=0;i<g.size();i++) {
    b*=(g[i]-'A'+1);
  }
  //cout<<a<<" "<<b<<endl;
  //cout<<a%47<<" "<<b%47<<endl;
  if((a%47) == (b%47)) fout<<"GO\n";
  else fout<<"STAY\n";
  return 0;
}
