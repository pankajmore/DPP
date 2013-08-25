#line 5 "YahtzeeScore.cpp"
#include <string>
#include <vector>
#include <cstdio>
using namespace std;
class YahtzeeScore {
	public:
	int maxPoints(vector <int> toss) {
	    vector <int> sum (6,0);
	    int i;
	    for(i=0;i<5;i++)
		sum[toss[i]-1] += toss[i];
	    int max=sum[0];

	    for(i=0;i<6;i++) if (sum[i] > max){max = sum[i];}
	    return max;
	}
};


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
