#include<iostream>
#include<algorithm>
#include<vector>
#include<utility>
#include<math.h>
#include<assert.h>
using namespace std;
typedef struct racer R;
typedef struct bucket B;
struct racer{
  int id;
  long long start;
  long long end;
};
struct bucket {
  int count;
  vector <R> rs;
  long long start;
};
R newRacer(int id,int s,int e){
  //R r = (R)malloc(sizeof(R));
  R r;
  r.id = id;
  r.start = s;
  r.end = e;
  return r;
}
B newBucket(int count,long long start){
  //B b = (B)malloc(sizeof(B));
  B b;
  b.count = count;
  b.start = start;
  return b;
}
bool byEndTime(R x, R y){
  return (x.end < y.end);
}
int main(int argc, char *argv[])
{
  int n;
  cin>>n;
  vector <int> a(n);
  vector <long long int> b(n);
  vector <long long int> c(n);
  for(int i=0;i<n;i++) {
    cin>>a[i]>>b[i]>>c[i];
  }
  vector <R> l(n);
  for(int i=0;i<n;i++) {
    l[i] = newRacer(a[i],b[i],c[i]);
  }
  sort(b.begin(),b.end());
  sort(c.begin(),c.end());
  // optimal number of buckets sqrt(n) - total running time n*sqrt(n)
  int k = floor(sqrt(n));
  vector <B> bc;
  for(int i=0;i<n;i+=ceil((n/k))+1){
    bc.push_back(newBucket(0,b[i]-1));
  }
  // for(int i=0;i<k;i++) cout<<bc[i].start<<" ";
  // cout<<endl;
  //sort racers in order of end-times
  sort(l.begin(),l.end(),byEndTime);
  //for(int i=0;i<n;i++) cout<<l[i].id<<endl;
  vector <pair<int,int> > res;
  for(int i=0;i<n;i++){
    // find bucket index where l[i] should go
    int index=k-1;
    //int index = (lower_bound(b.begin(),b.end(),l[i].start) - b.begin())/k;
    for (int j=0;j<k-1;j++){
      if((bc[j].start < l[i].start) && (bc[j+1].start > l[i].start)) {index = j;break;}
    }
    //assert((bc[index].start < l[i].start) && (bc[index+1].start > l[i].start));

    //cout<<index<<endl;
    int count = 0;
    for(int j=index+1;j<k;j++) {count+= bc[j].count;}
    for(int k=0;k<(bc[index].rs).size();k++) {
      if(bc[index].rs[k].start > l[i].start) count++;
    }
    bc[index].rs.push_back(l[i]);
    bc[index].count++;
    res.push_back(make_pair(count,l[i].id));
  }
  //assert(bc.size()==2);
  sort(res.begin(),res.end());
  for(int i=0;i<res.size();i++) cout<<res[i].second<<" "<<res[i].first<<endl;
  // cout<<"Buckets"<<endl;
  // for(int i=0;i<bc.size();i++) {
  //   cout << "Bucket "<<i<<" "<<bc[i].start<<endl;
  //   for(int j=0;j<bc[i].rs.size();j++) cout<<bc[i].rs[j].id<<" ";
  //   cout<<endl;
  // }
  return 0;
}
