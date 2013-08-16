#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
    int i,n,m,diff=4000;
    vector <int> a;
    scanf("%d %d",&n,&m);
    a.resize(m);
    for (i=0;i<m;i++) scanf("%d",&a[i]);
    sort(a.begin(),a.end());
    //    for(i=0;i<m;i++) printf("%d ",a[i],"\n [i==m-1]");
    for(i=0;i<m-n+1;i++) {
	diff = min(diff,a[i+n-1] - a[i]);
    }
    printf("%d\n",diff);
    return 0;
}
