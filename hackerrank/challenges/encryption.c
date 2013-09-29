#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    string s;
    cin>>s;

    int l = s.size();
    int i;
    int r = floor(sqrt((double)l));
    int c = ceil(sqrt((double)l));
    vector <string> e(c);
    for(i=0;i<l;i++) {
        e[i%c] += s[i];
    }
    for(i=0;i<c;i++) cout<<e[i]<<" ";
    cout<<endl;
    return 0;
}
