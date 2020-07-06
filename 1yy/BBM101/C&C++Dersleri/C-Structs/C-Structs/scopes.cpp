#include <iostream>
using namespace std;
int a=5;
void esitle1(int sayi){

    sayi=20;
}
void esitle2(int sayi3){
    sayi3=25;
}
int esitle3(int sayi){
    int sayi3=10;
    esitle2(sayi3);
    return sayi3;
}
int main() {
    int sayi=15;
    cout<<sayi<<endl;
    esitle1(sayi);
    cout<<sayi<<endl;
    sayi=esitle3(sayi);
    cout<<sayi<<endl;
    return 0;
}