#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int i,n,m;
    cin>>n;
    vector <int> A(n);
    for(i=0;i<n;i++) cin>>A[i];
    cin>>m;
    vector <int> B(m);
    for(i=0;i<m;i++) cin>>B[i];
    int min= *min_element(B.begin(),B.end());
    vector <int> C(100,-1);
    for(i=0;i<m;i++) C[B[i]-min]++;
    for(i=0;i<n;i++) C[A[i]-min]--;
    vector <int> ans;
    for(i=0;i<100;i++) {
        if(C[i] <= -1) continue;
        if(C[i] >= 0) ans.push_back(i+min);
    }
    sort(ans.begin(),ans.end());
    for(i=0;i<ans.size();i++) cout<<ans[i]<<" ";
    cout<<endl;
    return 0;
}
