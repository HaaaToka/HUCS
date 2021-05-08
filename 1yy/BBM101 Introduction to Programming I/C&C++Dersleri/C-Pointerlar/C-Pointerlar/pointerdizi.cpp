#include <iostream>
using namespace std;
int main2() {
    int *c;
    int length;
    int *p;
    p=(int *) malloc(5*sizeof(int));
    c= (int *) malloc(20 * sizeof(int));
    c[5]=15;
    c[2]=20;
    cout<<c[5]<<endl;
    cout<<*(c+2)<<endl;
    cout<<"Metnin Uzunlugunu Giriniz : "<<endl;
    cin>>length;
    p=(int *)realloc(p,length*sizeof(int));
    cout<<"Sayilari Giriniz : "<<endl;
    for(int i=0;i<length;i++) {
        cin >> p[i];
        cout << p[i]<<endl;
    }
    return 0;
}
