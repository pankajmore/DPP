#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int v,n,i,x,r;
    cin>>v>>n;
    for(i=0;i<n;i++) {cin>>x;if(x==v) r=i;}
    cout<<r<<endl;
    return 0;
}
