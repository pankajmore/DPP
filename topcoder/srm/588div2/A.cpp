#include<vector>
#include <cstdio>
using namespace std;

class KeyDungeonDiv2 {
  public:
    int countDoors(vector <int> doorR, vector <int> doorG, vector <int> keys) {
	int i,ww,count=0;
	for(i=0;i<doorR.size();i++) {
	    ww = min(keys[0]+keys[2] - doorR[i],keys[2]);
	    if (ww >= 0) {
		if (ww + keys[1] >= doorG[i]) {
		    count++;
		}
		else continue;
	    }
	    else continue;
	}
	return count;
    }
};
