// BEGIN CUT HERE

// END CUT HERE
#line 5 "LISNumberDivTwo.cpp"
#include <string>
#include <vector>
using namespace std;
class LISNumberDivTwo {
	public:
	int calculate(vector <int> seq) {
	    int i,count=1;
	    for(i=1;i<seq.size();i++) {
		if(seq[i] > seq[i-1]) continue;
		else count++;
	    }
	    return count;
	}
};
