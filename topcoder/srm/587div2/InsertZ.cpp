#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
class InsertZ {
	public:
	string canTransform(string init, string goal) {
	    goal.erase(remove(goal.begin(),goal.end(),'z'),goal.end());
	    cout<<goal<<endl;
	    if (init == goal) return "Yes";
	    else return "No";
	}
};


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
