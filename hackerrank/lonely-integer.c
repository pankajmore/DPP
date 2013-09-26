#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <cstdlib>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;
/* Head ends here */
int lonelyinteger(vector < int > a) {
    if(a.size() == 1) return a[0];
    sort(a.begin(),a.end());
    if(a[0] != a[1]) return a[0];
    for(int i=1;i<a.size();i++) {
        if((a[i] != a[i-1]) && (a[i] != a[i+1])) return a[i];
    }
    return a[a.size()-1];

}
/* Tail starts here */
int main() {
    int res;

    int _a_size;
    cin >> _a_size;
    cin.ignore (std::numeric_limits<std::streamsize>::max(), '\n');
    vector<int> _a;
    int _a_item;
    for(int _a_i=0; _a_i<_a_size; _a_i++) {
        cin >> _a_item;
        _a.push_back(_a_item);
    }

    res = lonelyinteger(_a);
    cout << res;

    return 0;
}
