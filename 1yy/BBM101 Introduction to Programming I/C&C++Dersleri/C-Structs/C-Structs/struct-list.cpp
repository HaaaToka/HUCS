#include <iostream>
using namespace std;

struct ogrenci{
    float ortalama;
    int yas;
    string isim;
};



int asdfasdfasdf() {
    int ogrencisayisi=3;
    float ortalamatoplam=0.0;
    float yastoplam=0.0;
    float ortort;
    float ortyas;
    cout<<"Ogrencilerin bilgilerini sirasiyla ortalama yas ve isim olarak giriniz"<<endl;
    ogrenci ogrenciler[3];

    for(int i=0;i<ogrencisayisi;i++){
        cout<<i+1<<". Ogrencinin Bilgilerini Giriniz : "<<endl;
        cin>>ogrenciler[i].ortalama>>ogrenciler[i].yas>>ogrenciler[i].isim;

    }
    for(int i=0;i<ogrencisayisi;i++){
        ortalamatoplam+=ogrenciler[i].ortalama;
        yastoplam+=ogrenciler[i].yas;
    }
    ortort=ortalamatoplam/ogrencisayisi;
    ortyas=yastoplam/ogrencisayisi;
    cout<<"Ogrencilerin Not Ortalamasi : "<<ortort<<" Ogrencilerin Yas Ortalamasi : "<<ortyas<<endl;

    return 0;
}