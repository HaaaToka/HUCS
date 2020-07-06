#include <iostream>
using namespace std;
struct node{
    int data;
    node *nextnode;
};
int main() {
    int uzunluk;
    int sayi;
    int index;
    int yenieleman;
    node *root;
    root=(node *) malloc(sizeof(node));
    node *currentnode;
    cout<<"Listenin eleman sayisini giriniz :"<<endl;
    cin>>uzunluk;
    cout<<"Listenin elemanlarini giriniz : "<<endl;
    currentnode=root;
    for(int i=0;i<uzunluk;i++){
        cin>>sayi;
        currentnode->data=sayi;
        currentnode->nextnode = (node *) malloc(sizeof(node));
        currentnode=currentnode->nextnode;
    }
    currentnode=root;
    for (int i=0;i<uzunluk;i++){
        cout<<currentnode->data<<endl;
        currentnode=currentnode->nextnode;
    }
    cout<<"Elemanin eklenecegi indexi giriniz"<<endl;
    cin>>index;
    cout<<"Elamanin degerini giriniz"<<endl;
    cin>>yenieleman;
    currentnode=root;
    for(int i=0;i<index-1;i++){
        currentnode=currentnode->nextnode;

    }
    node *newone = (node *) malloc(sizeof(node));
    node *temp;
    temp=currentnode->nextnode;
    newone->nextnode=temp;
    newone->data=yenieleman;
    currentnode->nextnode=newone;
    currentnode=root;
    for (int i=0;i<uzunluk+1;i++){
        cout<<currentnode->data<<endl;
        currentnode=currentnode->nextnode;
    }

    return 0;
}
