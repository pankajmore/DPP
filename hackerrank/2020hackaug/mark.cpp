#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int i,n,tmp;
    long long k;
    scanf("%d %lld\n",&n,&k);
    long long ar[n];
    for(i = 0; i < n; i++)
	scanf("%lld",&ar[i]);
    tmp = 0;
    std::sort(ar,ar+n);
    for(i = 0; i < n; i++) {
	if (k >= ar[i]) {
	     tmp = 1 + tmp;
	     k -= ar[i];
	}
    }
    printf("%d",tmp);
    return 0;
}
