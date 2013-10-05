/* Sample program illustrating input/output */
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(void){



//Helpers for input and output

   int i,c,sum,N, K;
   cin >> N >> K;
   vector <int> C(N);
   for(int i = 0; i < N; i++){
      cin >> C[i];
   }

   sort(C.rbegin(),C.rend());
    sum=0;
    for(i=0;i<N;i++) {
        c = (i/K) + 1;
        C[i] *= c;
        sum += C[i];
    }
   int result=sum;
   cout << result << "\n";

   return 0;
}
