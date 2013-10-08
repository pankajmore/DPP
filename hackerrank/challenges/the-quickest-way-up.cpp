#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <utility>
#include <queue>
#include <map>
#include <set>
using namespace std;

int path_length(vector <int> path,vector <int> ladder) {
    sort(path.begin(),path.end());
    sort(ladder.begin(),ladder.end());
    vector <int> c;
    //cout<<"Path :";
    //for(int i=0;i<path.size();i++) cout<<path[i]<<" ";
    //cout<<endl;

    //cout<<"Ladder : ";
    //for(int i=0;i<ladder.size();i++) cout<<ladder[i]<<" ";
    //cout<<endl;

    set_intersection(path.begin(),path.end(),ladder.begin(),ladder.end(),back_inserter(c));

    //cout<<"c size: "<<c.size()<<endl;
    return path.size()-c.size()-1;
}
pair<int,int> parse(string s) {
    int i=s.find(',');
    string x=s.substr(0,i);
    string y=s.substr(i+1);
    return make_pair(atoi(s.substr(0,i).c_str()),atoi(s.substr(i+1).c_str()));
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int T;
    cin>>T;
    for(int i=0;i<T;i++) {
        int L,S,u,v;
        vector <int> LD;
        string s;
        cin>>s;L=parse(s).first;S=parse(s).second;
        vector <bool> V(100,0);
        vector <vector <int> > A (100,vector<int>(0));
        map <int,vector<int> > path;
        for(int i=0;i<L;i++) {
            cin>>s;u=parse(s).first;v=parse(s).second;
            //cout<<"u : "<<u<<" v : "<<v<<endl;
            LD.push_back(u-1);
            A[u-1].push_back(v-1);
            //cout<<"u-1: ";
            //for(int i=0;i<A[u-1].size();i++) cout<<A[u-1][i]<<" ";
            //cout<<endl;
        }
        for(int i=0;i<S;i++) {
            cin>>s;u=parse(s).first;v=parse(s).second;
            A[u-1].push_back(v-1);
        }
        for(int i=0;i<100;i++) {
            //cout<<i;cout<<" - ";
            if(A[i].size()==0) {
                for(int j=1;j<=6;j++) {
                    A[i].push_back(i+j);
                    //cout<<i+j;cout<<" ";
                }
            }
            //cout<<endl;
        }

        //bfs
        queue<int> Q;

        //V[0]=1;
        path[0].push_back(0);
        Q.push(0);
        while(!Q.empty()) {
            int t = Q.front();Q.pop();
            if(t==99) {cout<<path_length(path[t],LD)<<endl;break;}
            for(int i=0;i<A[t].size();i++) {
                int u=A[t][i];
                if(path.find(u)==path.end()) {
                    path[u]=path[t];
                    path[u].push_back(u);
                    //cout<<"Path "<<u<<" : ";
                    //for(int i=0;i<path[u].size();i++) cout<<path[u][i]<<" ";
                    //cout<<endl;
                    Q.push(u);
                }
                //Q.push(u);


            }

        }
    }
    return 0;
}
