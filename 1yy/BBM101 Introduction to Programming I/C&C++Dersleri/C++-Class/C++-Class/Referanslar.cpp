#include <iostream>
using namespace std;
void artir(int &b,int c){
    b+=c;
}
void artir(int *array,int c){
    array[0]=c;
}
int jhjkfkgf() {
    int a=5,b=10;
    artir(a,b);
    cout<<a<<endl<<b<<endl;
    int *array=(int *)malloc(sizeof(int)*9999);
    array[0]=1;
    artir(array,20);
    cout<<array[0]<<endl;
    return 0;
}