#include <iostream>
using namespace std;
class Basitclass{
private:
    string b;
    int a;
public:
    Basitclass(string bd,int ad):b(bd),a(ad){};
    void printclass();
    void seta(int c){
        a=c;
    }
};
void Basitclass::printclass() {
    cout<<"String : "<<b<<"  Integer : "<<a<<endl;
}
int mafsdfds() {

    Basitclass class1("CLass1",1);
    Basitclass class2(class1);
    Basitclass class3 = class1;
    class2.seta(2);
    class3.seta(3);
    class1.printclass();
    class2.printclass();
    class3.printclass();
    return 0;
}