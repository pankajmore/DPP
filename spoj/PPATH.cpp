#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <cstdio>
#include <cmath>
#include <algorithm>
using namespace std;

int one_diff(int x,int y) {
  char ax[5],ay[5];
  sprintf(ax,"%d",x);
  sprintf(ay,"%d",y);
  int d=0;
  for(int i=0;i<4;i++) {
    if(ax[i]!=ay[i]) d++;
  }
  return d;
}

int f(vector<int> P,int x) {
  int pos= (find(P.begin(),P.end(),x) - P.begin());
  return pos;
}

int sp(vector <vector <int> > A,int u, int v) {
  queue<int> Q;
  map <int,vector<int> > path;
  Q.push(u);
  path[u].push_back(u);
  while(!Q.empty()) {
    int t=Q.front();Q.pop();
    if(t==v) {return path[t].size()-1;}
    for(int i=0;i<A[t].size();i++){
      int u=A[t][i];
      if(path.find(u)==path.end()){
        path[u]=path[t];
        path[u].push_back(u);
        Q.push(u);
      }
    }
  }
  return -1;
}

int main(int argc, char *argv[])
{
  int T,x,y;
  vector <int> P;
  for(int i=1001;i<=9999;i++) {
    int flag=0;
    for(int j=2;j<=sqrt(i);j++) {
      if(i%j==0) {flag=1;break;}
    }
    if(flag==0) {P.push_back(i);}
  }
  //for(int i=0;i<P.size();i++) cout<<P[i]<<" ";
  //cout<<endl;
  vector <vector <int> > A(P.size());
  for(int i=0;i<P.size();i++) {
    for(int j=1+1;j<P.size();j++) {
      if(one_diff(P[i],P[j])==1) {
        A[i].push_back(j);
        A[j].push_back(i);
      }
    }
  }
  // for(int i=0;i<A.size();i++) {
  //   cout<<P[i]<<" : ";
  //   for(int j=0;j<A[i].size();j++) cout<<P[A[i][j]]<<" ";
  //   cout<<endl;
  // }
  cin>>T;
  for(int i=0;i<T;i++) {
    cin>>x>>y;
    int u=f(P,x);
    int v=f(P,y);
    int s=sp(A,u,v);
    if(s==-1) cout<<"Impossible";
    else cout<<s<<endl;
  }
  return 0;
}
