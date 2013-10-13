#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <utility>
#include <set>
#include <queue>

using namespace std;

int count(vector <vector <int> > A,int u) {
    queue<int> Q;
    int N = A.size();
    vector<bool> V(N,0);
    int c=0;
    Q.push(u);
    V[u]=1;
    while(!Q.empty()) {
        int t=Q.front();Q.pop();
        //cout<<t+1<<" ";
        for(int i=0;i<N;i++) {
            if(A[t][i]==1) {
                if(V[i]==0) {
                    //cout<<"Vextex :"<<i<<" ";
                    V[i]=1;
                    Q.push(i);
                }
            }
        }
    }
    for(int i=0;i<N;i++) {if(V[i]==1) c++;}
    //cout<<" - Count : "<<c<<endl;
    return c;
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int N,M,u,v,c=0;

    cin>>N>>M;
    vector <vector <int> > A(N,vector <int>(N,0));
    vector <pair <int,int> > E;
    for(int i=0;i<M;i++) {cin>>u>>v;A[u-1][v-1]=1;A[v-1][u-1]=1;E.push_back(make_pair(u-1,v-1));}

    for(int i=0;i<M;i++) {
        u=E[i].first;
        v=E[i].second;
        A[u][v]=0;
        A[v][u]=0;
        //cout<<count(A,u)<<" ";
        if (count(A,u)%2==0) c++; else {A[u][v]=1;A[v][u]=1;}
    }
    cout<<c<<endl;
    return 0;
}
