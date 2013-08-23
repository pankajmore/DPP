// BEGIN CUT HERE

// END CUT HERE
#line 5 "TeamsSelection.cpp"
#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;
class TeamsSelection {
	public:
	string simulate(vector <int> preference1, vector <int> preference2) {
	    set <int> already;
	    string cstr (preference1.size(),'0');
	    int i1=0,i2=0;
	    int n = preference1.size();
	    while(true) {
		if(already.size() == n) break;
		while(true) {
		    if(i1 == n) break;
		    if(already.find(preference1[i1]) == already.end()) {
			already.insert(preference1[i1]);
			cstr[preference1[i1]-1] = '1';
			break;
		    }
		    else i1++;
		}
		if(already.size() == n) break;
		while(true) {
		    if(i2 == n) break;
		    if(already.find(preference2[i2]) == already.end()) {
			already.insert(preference2[i2]);
			cstr[preference2[i2]-1] = '2';
			break;
		    }
		    else i2++;
		}
	    }
	    return cstr;
	}
};
