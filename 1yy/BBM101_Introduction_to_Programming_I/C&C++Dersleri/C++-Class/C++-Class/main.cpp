#include <iostream>
using namespace std;
float topla(float a,float b){
    return a+b;
}
int topla(int a,int b){
    return a+b;
}
int carpim(int b,int c,int d){
    return b*c*d;
}
int carpim(int b,int c=1){
    return b*c;
}
int asdfasdfasdg() {
    int a=5,b=10;
    float c=5.5,d=1.05;
    cout<<topla(a,b)<<endl<<topla(c,d)<<endl;
    cout<<carpim(a,b)<<endl<<carpim(a,b,c);
    return 0;
}