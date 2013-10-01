#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <utility>
using namespace std;

void print(int x,int n) { int i;for(i=0;i<n;i++) cout<<x<<" ";}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n,i;
    cin>>n;
    vector <int> a(n);
    vector<pair<int,int> > c(100,std::make_pair(0,0));
    for(i=0;i<n;i++) {
        cin>>a[i];
        int k = a[i];
        int v = c[a[i]].second+1;
        c[a[i]] = make_pair(k,v);
    }
    sort(c.begin(),c.end());
    for(i=0;i<100;i++) {
        if(c[i].second>0) print(c[i].first,c[i].second);
    }
    cout<<endl;
    return 0;
}
