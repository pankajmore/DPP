#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
#include <map>
#include <assert.h>
using namespace std;

int ncc(vector <vector <int> >& A,vector <bool>& V,int u) {
    queue<int> Q;
    int c=0;
    Q.push(u);
    V[u]=1;
    c++;
    while(!Q.empty()){
        int t=Q.front();Q.pop();
        //V[t]=1;
        //c++;
        for(int i=0;i<A[t].size();i++){
            if(V[A[t][i]]!=1) {
                V[A[t][i]]=1;
                Q.push(A[t][i]);
                c++;
            }
        }
    }
    //cout<<"For dfs from "<<u<<" = "<<c<<endl;
    return c;
}

int main() {
  int N,M,u,v;
  long long res=0;
  cin>>N>>M;
    vector <bool> V(N,0);
    vector <vector <int> > A(N);
    for(int i=0;i<M;i++) {
        cin>>u>>v;
        A[u].push_back(v);
        A[v].push_back(u);
    }
    //for(int i=0;i<N;i++) {
    //    cout<<i<<" : ";
    //    for(int j=0;j<A[i].size();j++) cout<<A[i][j]<<" ";
    //    cout<<endl;
    //}
    map <long long,long long> Z;
    vector <pair<long long,long long> > C;
    for(int i=0;i<N;i++) {
        if(V[i]!=1) {
            int m=ncc(A,V,i);
            if(m==N) {cout<<0<<endl;exit(0);}
            else Z[m]++;
            //cout<<"Visited Status: ";
            //for(int i=0;i<N;i++) cout<<V[i]<<" ";
            //cout<<endl;
        }
    }

    for(map<long long,long long>::iterator it=Z.begin();it!=Z.end();it++) C.push_back(make_pair(it->first,it->second));
    // cout<<"NCC : ";
    // int sum=0;
    // for(int i=0;i<Z.size();i++) {sum+=Z[i];cout<<Z[i]<<" ";}
    // cout<<endl;
    // assert(sum==N);
    for(int i=0;i<C.size();i++) {
      //cout<<C[i].first<<" "<<C[i].second<<endl;
      res+=(C[i].second*(C[i].second-1)*C[i].first*C[i].first)/2;
    }

    for(int i=0;i<C.size();i++) {
      for(int j=i+1;j<C.size();j++) res+=(C[i].first*C[i].second*C[j].first*C[j].second);
    }
    cout<<res<<endl;
    return 0;
}
