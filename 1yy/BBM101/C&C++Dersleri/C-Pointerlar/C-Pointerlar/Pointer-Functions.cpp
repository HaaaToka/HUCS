#include <iostream>
using namespace std;
int degistir2(int a,int b){
    a=b;
    return 0;
}

int degistir(int *a,int b){
    *a=b;
    return 0;
}
int *carp(int c, int d,int *p){
    *p=c*d;
    return p;

}
int main4() {
    int c=0;
    int d;
    int *p;
    p=&c;
    cout<<c<<endl;
    cout<<"Degistirilecek miktari giriniz : "<<endl;
    cin>>d;
    degistir(p,d);
    cout<<c<<endl;
    cout<<"Degistirilecek miktari giriniz : "<<endl;
    cin>>d;
    degistir2(c,d);
    cout<<c<<endl;
    p=carp(5,8,p);
    cout<<*p;

    return 0;
}