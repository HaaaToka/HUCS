#include <iostream>
using namespace std;
class Karakter{
protected:
    string isim;
    float can;
    float maxcan;
    bool isdeath;
public:
    Karakter(string isimd,float cand):isim(isimd),can(cand),maxcan(cand),isdeath(0){
        cout<<isim<<" Yaratildi."<<endl;
    };
    void setCan(float cand){
        can=cand;
        if(can<=0){
            isdeath=1;
            cout<<isim<<" Oldu"<<endl;
            can=0;
        }
    }
    float getCan() {
        return can;
    }
    float getMaxcan(){
        return maxcan;
    }
    void detaylariyazdir() {
        cout << "Ismim : " << isim <<"  Canim : "<<can<<endl;
    }
};
class Dovuscu: public Karakter {
private:
    float saldirihasari;
    float ofke;
public:
    Dovuscu(string isimd, float cand, float saldirihasarid) : saldirihasari(saldirihasarid), ofke(0),
                                                              Karakter(isimd, cand) {};
    void setCan(float cand) {
        if (isdeath == 0) {
            if (cand<can) {
                ofke = can - cand;
            } else {
                ofke = 0;
            }
            can = cand;
            if(can<=0){
                isdeath=1;
                cout<<isim<<" Oldu"<<endl;
                can=0;
            }
        }
       else{
            cout<<"Saldirmaya çalıştığınız Karakter olu saldiramazsiniz"<<endl;
        }
    }
    void saldir(Dovuscu &dovuscu1) {
        if (isdeath == 0) {
            float hasar = saldirihasari + ofke * 0.1;
            ofke = 0;
            dovuscu1.setCan(dovuscu1.getCan() - hasar);
        }
        else{
            cout<<"Karakter olu saldiramaz"<<endl;
        }
    }
};
class Sifaci:public Karakter{
private:
    float buyugucu;
public:
    Sifaci(string isimd,float cand,float buyugucud):buyugucu(buyugucud),Karakter(isimd,cand){};
    void iyilestir(Dovuscu &dovuscu1){
        if(isdeath==0){
        float iyilestirmemiktari=buyugucu*0.5;
        float suankican=dovuscu1.getCan();
        if(suankican+iyilestirmemiktari>dovuscu1.getMaxcan()){
            dovuscu1.setCan(dovuscu1.getMaxcan());
        }
        else{
            dovuscu1.setCan((suankican+iyilestirmemiktari));
        }
    }
        else{
            cout<<"Olusunuz iyilestiremezsiniz"<<endl;
        }
    }

};

int main() {
    float can;
    int c1,c2;
    int secenek;
    float maxcan;
    int dcounter=0;
    int scounter=0;
    Dovuscu* dovusculer;
    Sifaci* sifacilar;
    dovusculer=(Dovuscu *) malloc(sizeof(Dovuscu)*20);
    sifacilar=(Sifaci *) malloc(sizeof(Sifaci)*20);
    string isim;
    float saldirihasari;
    float buyugucu;
    while(1){
        cout<<"Karakter Yaratmak Icin 1 , Olan Karakterleri Listelemek Icin 2 , Bir karakteri yonlendirmek Icin 3 ,Cikmak Icin 4 Giriniz: "<<endl;
        cin>>secenek;
        if(secenek==4) {
            break;
        }
        switch(secenek){
            case 1:{
                cout<<"Dovuscu icin 1 sifaci icin 2 giriniz : "<<endl;
                cin>>secenek;
                if(secenek==1){
                    cout<<"Sirasiyla ismini canini saldirihasarini giriniz : "<<endl;
                    cin>>isim;
                    cin>>can;
                    cin>>saldirihasari;
                    dovusculer[dcounter]=Dovuscu(isim,can,saldirihasari);
                    dcounter+=1;
                }
                else{
                    cout<<"Sirasiyla ismini canini buyugucunu giriniz : "<<endl;
                    cin>>isim;
                    cin>>can;
                    cin>>buyugucu;
                    sifacilar[scounter]=Sifaci(isim,can,buyugucu);
                    scounter+=1;
                }
                break;
            }
            case 2:{
                cout<<"Dovusculer :"<<endl;
                for(int i=0;i<dcounter;i++){
                    cout<<i<<")  ";
                    dovusculer[i].detaylariyazdir();
                }
                cout<<"Sifacilar :"<<endl;
                for(int i=0;i<scounter;i++){
                    cout<<i<<")  ";
                    sifacilar[i].detaylariyazdir();
                }
                break;
            }
            case 3: {
                cout << "Dovuscuyse 1 , Sifaciysa 2 giriniz : " << endl;
                cin >> secenek;
                if (secenek == 1) {
                    cout << "Numarasini Giriniz : " << endl;
                    cin >> c1;
                    cout << "Saldircaginiz dovuscunun numarasini giriniz : " << endl;
                    cin >> c2;
                    dovusculer[c1].saldir(dovusculer[c2]);
                } else if (secenek == 2) {
                    cout << "Numarasini Giriniz : " << endl;
                    cin >> c1;
                    cout << "İyilestireceginiz dovuscunun numarasini giriniz : " << endl;
                    cin >> c2;
                    sifacilar[c1].iyilestir(dovusculer[c2]);
                }
                break;
            }

            }

        }


    return 0;
}