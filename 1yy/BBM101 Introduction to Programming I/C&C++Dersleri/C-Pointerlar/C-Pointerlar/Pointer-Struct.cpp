#include <iostream>
using namespace std;
struct emlaklar{
    int fiyat;
    string isim;
};
int main3() {
    int sayi;
    cout<<"Emlak Sayısını Giriniz "<<endl;
    cin>>sayi;
    emlaklar *emlakp=(emlaklar *) malloc(sizeof(emlaklar)*sayi);
    for(int i=0;i<sayi;i++){
        cout<<"Emlak Detaylarini fiyat ve isim sirasiyla giriniz"<<endl;
        cin>>emlakp[i].fiyat;
        cin>>emlakp[i].isim;
    }
    for(int i=0;i<sayi;i++){

        cout<<emlakp[i].fiyat<<endl;
        cout<<emlakp[i].isim<<endl;
    }
    // en pahali emlagi bulcak algoritmayı birine yazdır
    return 0;
}


