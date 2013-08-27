// BEGIN CUT HERE

// END CUT HERE
#line 5 "PassingGrade.cpp"
#include <string>
#include <vector>
#include <cmath>
using namespace std;
class PassingGrade {
	public:
	int pointsNeeded(vector <int> pointsEarned, vector <int> pointsPossible, int finalExam) {
	    int tP=0,tE=0,i;
	    for(i=0;i<pointsEarned.size();i++){
		tE += pointsEarned[i];
		tP += pointsPossible[i];
	    }
	    tP += finalExam;
	    int pass = ceil(0.65*tP);
	    int needed = pass - tE;
	    if (needed > finalExam) return -1;
	    else if (needed < 0) return 0;
	    else return needed;
	}
};
