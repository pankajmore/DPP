#line 5 "Quipu.cpp"
#include <string>
#include <vector>
#include <cstdlib>
#include <iostream>
using namespace std;
class Quipu {
	public:
	int readKnots(string knots) {
	    int i,d;
	    string num;
	    for(i=1;i<knots.length();) {
		d=0;
		if(knots[i]=='X') { d=1;
		    while(knots[++i]=='X') d++;
		}
		num.append(1,(char)d + '0');
		d=0;
		if(knots[i]=='-') {
		    while(knots[++i]=='-')
		    num.append(1,(char)0 + '0');
		}

		//		cout<<num<<endl;
	    }
	    return atoi(num.c_str());
	}
};


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
