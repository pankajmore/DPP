// BEGIN CUT HERE

// END CUT HERE
#line 5 "BettingMoney.cpp"
#include <string>
#include <vector>
using namespace std;
class BettingMoney {
	public:
	int moneyMade(vector <int> amounts, vector <int> centsPerDollar, int finalResult) {
	    int n = amounts.size();
	    int i,count=0;
	    for(i=0;i<n;i++) count+=amounts[i];
	    count = count - amounts[finalResult];
	    count = (count*100) - (amounts[finalResult]*centsPerDollar[finalResult]);
	    return count;
	}
};
