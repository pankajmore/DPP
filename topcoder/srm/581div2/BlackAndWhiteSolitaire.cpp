#line 2 "BlackAndWhiteSolitaire.cpp"

#include <algorithm>
#include <complex>
#include <exception>
#include <list>
#include <stack>
#include <bitset>
#include <csetjmp>
#include <fstream>
#include <locale>
#include <stdexcept>
#include <cassert>
#include <csignal>
#include <functional>
#include <map>
#include <cctype>
#include <cstdarg>
#include <iomanip>
#include <memory>
#include <streambuf>
#include <cerrno>
#include <cstddef>
#include <ios>
#include <new>
#include <string>
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <ostream>
#include <climits>
#include <cstring>
#include <istream>
#include <queue>
#include <valarray>
#include <clocale>
#include <ctime>
#include <iterator>
#include <set>
#include <vector>
#include <cmath>
#include <deque>
#include <limits>
#include <sstream>

using namespace std;

typedef long long LL;
typedef long double LD;
typedef vector<int> VI;
typedef vector<VI> VII;
typedef vector<string> VS;
typedef pair<int,int> PII;

#define SZ(x) ((int)((x).size()))

class BlackAndWhiteSolitaire
        {
        public:
        int minimumTurns(string cardFront)
            {
		int bc=0,wc=0;
		string b(cardFront);
		string w(cardFront);
		if (cardFront[0] == 'B') {w[0] = 'W';wc++;}
		else {b[0] = 'B';bc++;}
		for(int i=1;i< SZ(b);i++) {
		    if(b[i] == 'B' && b[i-1] == 'B') {
			b[i] = 'W';bc++;
		    }
		    if(b[i] == 'W' && b[i-1] == 'W') {
			b[i] = 'B';bc++;
		    }
		    if(w[i] == 'B' && w[i-1] == 'B') {
			w[i] = 'W';wc++;
		    }
		    if(w[i] == 'W' && w[i-1] == 'W') {
			w[i] = 'B';wc++;
		    }

		}
		return min(bc,wc);
            }


        };



// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
