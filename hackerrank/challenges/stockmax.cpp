#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int T;
    cin>>T;
    while(T--){
        int N;
        cin>>N;
        vector <long long> A(N,0);
        for(int i=0;i<N;i++) cin>>A[i];
    
        long long currMax = 0,currProfit=0;
        for(int i=N-1;i>=0;i--) {
            if(A[i]>=currMax) currMax = A[i];
            else currProfit += (currMax-A[i]);
            
        }
        cout<<currProfit<<endl;
        
    }
    return 0;
}

