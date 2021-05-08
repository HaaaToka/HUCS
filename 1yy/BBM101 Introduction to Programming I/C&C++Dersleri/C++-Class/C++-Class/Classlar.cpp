#include <iostream>
using namespace std;
class Karakter{
private:
    int can;
    int saldirihasari;
    int y;
public:
    int erismesikolay;
    Karakter(int cand,int shd):can(cand),saldirihasari(shd){};
    Karakter(int cand,int shd,int erismesikolayd):can(cand),saldirihasari(shd),erismesikolay(erismesikolayd){
        cout<<"Bu Sefer Full Parametreliyim :)"<<endl;
    };
    void saldir(Karakter &k3){
        k3.setCan(k3.getCan()-getSaldirihasari());
    }
    void setCan(int cand){
        can=cand;
    }
    int getCan(){
        return can;
    }
    int getSaldirihasari(){
        return saldirihasari;
    }
    void canigoster(){
        cout<<"Caniniz :"<<can<<endl;
    }
    int& sety(){
        return y;
    }
    void showY();

};
void Karakter::showY(){
    cout<<"Y : "<<y<<endl; }

int main() {
    int shd,can;
    cout<<"Karakterin saldiri hasari ve canini sirasiyla giriniz : "<<endl;
    cin>>shd>>can;
    Karakter k1(can,shd);
    cout<<"Karakterin saldiri hasari ve canini sirasiyla giriniz : "<<endl;
    cin>>shd>>can;
    Karakter k2(can,shd);
    k1.saldir(k2);
    k2.saldir(k1);
    k1.canigoster();
    k2.canigoster();
    k1.sety()=25;
    k1.showY();
    k1.erismesikolay=500;
    cout<<k1.erismesikolay<<endl;
    Karakter k4(2000,2000,10);
    cout<<k4.erismesikolay<<endl;
    return 0;
}
