#include<iostream>
#include<string>
using namespace std;
bool feedback(string s) {
  if(s.length() < 3) return false;
  for(int i=0;i<s.length()-2;i++) {
    if((s[i]=='0' && s[i+1]=='1' && s[i+2]=='0') || (s[i]=='1' && s[i+1] == '0' && s[i+2]=='1')) {
      return true;
    }
  }
  return false;
}

int main(int argc, char *argv[])
{
  int T;
  string s;
  cin>>T;
  while(T--){
    cin>>s;
    if(feedback(s)) cout<<"Good"<<endl;
    else cout<<"Bad"<<endl;
  }
  return 0;
}
