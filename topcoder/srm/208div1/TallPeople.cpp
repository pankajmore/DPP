#line 2 "TallPeople.cpp"

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
#include <cfloat>
#include <cstdio>
#include <iosfwd>
#include <numeric>
#include <typeinfo>
#include <ciso646>
#include <cstdlib>
#include <iostream>
#include <ostream>
#include <utility>
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

typedef long long ll;
typedef unsigned int ui;

using namespace std;
class TallPeople
        {
        public:
        vector <int> getPeople(vector <string> people)
            {
		int i,j,n=people.size(),curr,x=0;
		vector <int> shortest,tallest;
		for(i=0;i<n;i++) {
		    vector<string> tokens;
		    copy(istream_iterator<string>(people[i]),
			 istream_iterator<string>(),
			 back_inserter<vector<string> >(tokens));
		    transform(begin(tokens), std::end(tokens), atoi);
		    shortest.push_back(*min_element())
		    }
		    x++;
		} x=0;
		for(j=0;j<people[0].length();j=j+2) {
		    tallest.push_back(atoi(&people[0][j]));
		    for(i=0;i<n;i++) {
			curr = atoi(&people[i][j]);
			if (tallest[x] < curr) tallest[x] = curr;
		    }
		    x++;
		}
		vector <int> res;
		res.push_back(*max_element(shortest.begin(),shortest.end()));
		res.push_back(*min_element(tallest.begin(),tallest.end()));
		return res;
            }


        };



// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessor
