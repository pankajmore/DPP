#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>
#include <utility>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n,k,i,x;
    cin>>n>>k;
    vector <int> a(n);
    for(i=0;i<n;i++) cin>>a[i];

    sort(a.begin(),a.end());
    set <pair<int,int> > p;
    for(i=0;i<n;i++) {
        if(binary_search(a.begin(),a.end(),a[i]-k))
            p.insert(make_pair(a[i]-k,a[i]));
        if(binary_search(a.begin(),a.end(),a[i]+k))
            p.insert(make_pair(a[i],a[i]+k));

    }
    cout<<p.size()<<endl;
    return 0;
}
