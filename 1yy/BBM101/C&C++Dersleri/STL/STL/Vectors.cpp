#include <iostream>
#include <vector>
using namespace std;
class myexception: public exception
{
    virtual const char* what() const throw()
    {
        return "Bir sey oldu :'(";
    }
} myex;

int adgfasdfasdf() {
    cout<<"Vectorun tum elemanlarini giriniz bitirmek icin -1 giriniz"<<endl;
    int a;
    vector<int> liste;
    while(1) {
        try {
            cin >> a;
            if(a==-1){
                break;
            }
            liste.push_back(a);

        }
        catch (exception &e) {
            cout << e.what() << endl;
            break;
        }

    }
    try{
        throw(myex);
    }
    catch(exception &e) {
       cout<< e.what() <<endl;
    }
    sort(liste.begin(),liste.end());
    for(int i=0;i<liste.size();i++){
        cout<<liste[i]<<" , ";
    }


    return 0;
}

