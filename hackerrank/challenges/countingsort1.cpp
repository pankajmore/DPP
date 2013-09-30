#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n;
    cin>>n;
    int a[n];
    int i;
    vector <int> b(100,0);
    for(i=0;i<n;i++) {
        cin>>a[i];
        b[a[i]]++;
    }
    for(i=0;i<100;i++) cout<<b[i]<<" ";
    cout<<endl;
    return 0;
}
