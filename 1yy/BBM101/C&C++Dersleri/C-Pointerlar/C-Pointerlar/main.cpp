#include <iostream>
using namespace std;
int main1() {
    int a=5;
    int *p;
    int b=20;
    a=b;
    b=5;
    cout<<a<<endl;
    p=&a;
    *p=10;
    cout<<a<<endl;
    return 0;
}