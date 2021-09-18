#include<iostream>
#include <map>
using namespace std;
int main(){
    map<string,int*> map1;
    int val;
    string key;
    int c[3];
    cout<<"Key value çiftlerini sirasiyla giriniz cikmak icin key e exit giriniz"<<endl;
    while(1){
        try{
            cin>>key;
            if(key=="exit"){
                break;
            }
            for (int i=0;i<3;i++){
                cin>>val;
                c[i]=val;

            }

            map1.insert(make_pair(key,c));

        }
        catch(exception &e){
           cout<< e.what()<<endl;
        }

    }
   cout<<"Erismek istediginiz value nun key ini giriniz : "<<endl;
   cin>>key;
   for (int i=0;i<3;i++){
   cout<<"Key : "<<key<<"    Value : "<<map1[key][i]<<endl;
}
    return 0;
}

