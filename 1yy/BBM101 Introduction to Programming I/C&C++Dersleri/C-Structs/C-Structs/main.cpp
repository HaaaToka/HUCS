#include <iostream>
using namespace std;

struct ogrenci{
    int ortalama;
    int sinif;
    string isim;
};



int asd() {
    ogrenci ogrenci1,ogrenci2;
    cout<<"Birinci Ogrencinin ortalamasini sinifini ve ismini sirayla giriniz : "<<endl;
    cin>>ogrenci1.ortalama>>ogrenci1.sinif>>ogrenci1.isim;
    cout<<"Ikinci Ogrencinin ortalamasini sinifini ve ismini sirayla giriniz : "<<endl;
    cin>>ogrenci2.ortalama>>ogrenci2.sinif>>ogrenci2.isim;
    cout<<"Ortalama : "<<ogrenci1.ortalama<<" Sinif : "<<ogrenci1.sinif<<" Isim : "<<ogrenci1.isim<<endl;
    return 0;
}