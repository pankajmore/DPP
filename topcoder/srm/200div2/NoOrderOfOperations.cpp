// BEGIN CUT HERE

// END CUT HERE
#line 5 "NoOrderOfOperations.cpp"
#include <string>
#include <vector>
#include <cstdlib>
using namespace std;
class NoOrderOfOperations {
	public:
	int evaluate(string expr) {
	    int r = atoi(&expr[0]);
	    char op;
	    int d,i;
	    for(i=1;i<expr.length();i=i+2) {
		op = expr[i];
		d = atoi(&expr[i+1]);
		if(op == '*') r*=d;
		if(op == '-') r-=d;
		if(op == '+') r+=d;
	    }
	    return r;
	}
};
