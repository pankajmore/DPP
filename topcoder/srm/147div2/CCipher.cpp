// BEGIN CUT HERE

// END CUT HERE
#line 5 "CCipher.cpp"
#include <string>
#include <vector>
using namespace std;
class CCipher {
	public:
	string decode(string cipherText, int shift) {
	    int i;
	    string decode;
	    for(i=0;i<cipherText.length();i++) {
		if(cipherText[i] - shift >= 65) {
		    decode.push_back((char)(cipherText[i] - shift));
		}
		else {
		    decode.push_back((char)(cipherText[i] - shift + 26));
		}
	    }
	    return decode;
	}
};
