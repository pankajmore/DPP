#include <cstdio>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
    int i,n,beauty,now;
    vector <int> a,cur,ans;
    scanf("%d",&n);
    a.resize(n);
    for(i=0;i<n;i++) scanf ("%d",&a[i]);

    for(beauty=29;beauty>-1;beauty--) {
	now=(1<<30) - 1;
	cur.clear();
	for(i=0;i<n;i++) {
	    if(a[i] & (1<<beauty)) {
		cur.push_back(a[i]);
		now &= a[i];
	    }
	}
	if (now % (1<<beauty) == 0) {
	    ans=cur;
	    break;
	}
    }
    printf("%d\n",ans.size());
    for(i=0;i<ans.size();i++) printf("%d ",ans[i],"\n"[i == ans.size() - 1]);
    return 0;
}
