#include <cstdio>
#include <set>
#include <iostream>
#include <sstream>
using namespace std;
int main(int argc, char *argv[])
{
    int i,T;
    string str;
    set<string> niceset;
    i=0;
    while(getline(cin,str)){
	niceset.clear();
	istringstream iss(str);
	while(iss)  {
	    string sub;
	    iss >> sub;
	    niceset.insert(sub);
	}
	if(i==0) {i++;continue;}
	printf("%d\n",niceset.size()-1);
    }
    return 0;
}
