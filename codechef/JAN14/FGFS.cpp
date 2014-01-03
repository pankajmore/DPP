#include<iostream>
#include<vector>
#include<map>
#include<utility>
#include<algorithm>
#include<cstdio>
using namespace std;
int main(int argc, char *argv[])
{
  int T,N,K,s,f,p;
  cin>>T;
  while(T--){
    map<int,vector <pair<int,int> > > d;
    scanf("%d %d",&N,&K);
    while(N--){
      scanf("%d %d %d",&s,&f,&p);
      d[p].push_back(make_pair(f,s));
    }
    int c = 0;
    for(auto& x:d) {
      int ff = 0;
      sort(x.second.begin(),x.second.end());
      for(auto& v:x.second) {
        if (v.second >= ff) {
          c++;
          ff = v.first;
          //cout<<v.second<<v.first<<endl;
        }
      }
    }
    cout<<c<<endl;
  }
  return 0;
}
