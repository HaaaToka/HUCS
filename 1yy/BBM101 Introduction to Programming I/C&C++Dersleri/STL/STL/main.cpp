#include <iostream>
namespace yeninamespace{
    void func1(std::string c){
        std::cout<<c<<std::endl;
    }
}
namespace dahayeninamespace{
    void func1(std::string c){
        std::cout<<c<<" Bu daha yeni"<<std::endl;
    }
    class Deneme{
    private:
        int sayi;
    public:
        Deneme(int sayd):sayi(sayd){
            std::cout<<sayd<<"'li class yaratildi"<<std::endl;
        }
        int getSayi() {
            return sayi;
        }
        void setSayi(int sayd);
        void showSayi();
    };
}
void dahayeninamespace::Deneme::setSayi(int sayd) {
    sayi=sayd;
}
void dahayeninamespace::Deneme::showSayi() {
    std::cout<<sayi<<std::endl;
}
namespace nestedone{
    namespace nested2{
        void func1(std::string c){
            std::cout<<c<<" Buda Nested"<<std::endl;
        }
    }
   void func1(std::string c){
       std::cout<<c<<" Buda nestedin disi"<<std::endl;
   }
}
namespace budakullanmalik{
    void func1(std::string c){
        std::cout<<c<<" Kullanmalik"<<std::endl;
    }
}
using namespace budakullanmalik;
int kjgkjgkg() {
    yeninamespace::func1("Selam");
    dahayeninamespace::func1("Selam");
    dahayeninamespace::Deneme class1(10);
    class1.setSayi(20);
    class1.showSayi();
    class1.setSayi(class1.getSayi()+10);
    class1.showSayi();
    nestedone::func1("Selam");
    nestedone::nested2::func1("Selam");
    func1("Selam");
    return 0;
}