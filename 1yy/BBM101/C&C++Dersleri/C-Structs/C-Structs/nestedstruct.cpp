#include <iostream>
using namespace std;
struct ucbuzunluk{
    float x;
    float y;
    float z;
};

struct mobilya{
    ucbuzunluk uzunluk;
    float agirlik;
    int fiyat;
    string isim;
};
float hacimhesapla(mobilya mobilya2){
    return mobilya2.uzunluk.x*mobilya2.uzunluk.y*mobilya2.uzunluk.z;
}
float yogunlukhesapla(mobilya mobilya3){
    return mobilya3.agirlik/hacimhesapla(mobilya3);
}

int gfdgdgffd4() {
    mobilya mobilya1;
    cout<<"Mobilyanin ozelliklerini agirlik fiyat isim ve her bir boyut icin uzunlugu seklinde sirasiyla giriniz : "<<endl;
    cin>>mobilya1.agirlik>>mobilya1.fiyat>>mobilya1.isim>>mobilya1.uzunluk.x>>mobilya1.uzunluk.y>>mobilya1.uzunluk.z;
    cout<<"Mobilyanin Hacmi : "<<hacimhesapla(mobilya1)<<" Mobilyanin Yogunlugu : "<<yogunlukhesapla(mobilya1);
    return 0;
}