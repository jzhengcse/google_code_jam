
#include <iostream>
#include <string>
#include <math.h>
#define pi 3.1415926
using namespace std;

int main() {
  int T;
  long long r;
  long double t;
  long long count;
  long double A;
  cin>>T;
  for(int i=0;i<T;i++) {
    cin>>r>>t;
    count=0;
    A=2*r+1;
    while(t>=A) {
      t=t-A;
      count++;
      r=r+2;

      A=2*r+1;
    }
    printf("Case #%d : %lld\n",i+1,count);
  }

  return 0;
}
