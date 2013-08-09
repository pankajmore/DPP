#include <cstdio>
#include <stdlib.h>
int main(int argc, char *argv[])
{
    int x,y,r;
    scanf("%d %d",&x,&y);
    r = abs(x) + abs(y);
    if (x > 0 && y > 0) printf("%d %d %d %d\n",0,r,r,0);
    if (x > 0 && y < 0) printf("%d %d %d %d\n",0,-r,r,0);
    if (x < 0 && y < 0) printf("%d %d %d %d\n",-r,0,0,-r);
    if (x < 0 && y > 0) printf("%d %d %d %d\n",-r,0,0,r);
    return 0;
}
