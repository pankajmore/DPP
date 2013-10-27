#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int anagram(string s){
    int N=s.size();
    if(N%2==0) {
        int i=0;
        vector <int> A(26,0);
        for(;i<N/2;i++) {
            int index=s[i]-'a';
            A[index]++;
        }
        for(;i<N;i++) {
            int index=s[i]-'a';
            if(A[index]>0) A[index]--;
        }
        int sum=0;
        for(int i=0;i<26;i++) sum+=A[i];
        return sum;
    }
    else return -1;
}

int main() {
    int T;
    string s;
    cin>>T;
    for(int i=0;i<T;i++){
        cin>>s;
        cout<<anagram(s)<<endl;
    }
    return 0;
}
