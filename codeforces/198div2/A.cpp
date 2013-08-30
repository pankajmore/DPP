#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <memory.h>
#include <cstdio>

using namespace std;

int gcd(int a, int b)
{
    for (;;)
	{
	    if (a == 0) return b;
	    b %= a;
	    if (b == 0) return a;
	    a %= b;
	}
}

int main(int argc, char *argv[])
{
    int x,y;
    long long a,b;
    cin >> x >> y >> a >> b;

    long long lcm = (x * y)/gcd(x,y);
    long long n1 = floor((long double)b/(double)lcm);
    long long n2 = ceil((long double)a/(double)lcm);
    long long t = n1 - n2 + 1;
    if (t < 0) t = 0;
    cout << t << endl;
    return 0;
}
