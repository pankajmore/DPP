#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int i,n;
    string s;
    cin>>n;
    vector <int> a(n);
    vector <int> c(100,0);
    for(i=0;i<n;i++) {
        cin>>a[i]>>s;
        c[a[i]]++;
    }
    int count=0;
    for(i=0;i<100;i++) {
        if(c[i]>0) {count+=c[i];}
        cout<<count<<" ";
    }
    cout<<endl;
    return 0;
}
