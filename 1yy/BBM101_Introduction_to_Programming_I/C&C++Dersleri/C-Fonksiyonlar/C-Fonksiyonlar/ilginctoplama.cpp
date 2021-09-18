#include <stdio.h>

int artir(int a,int b){
    int i;
    for(i=0;i<b;i++){
        a+=1;
    }
    return a;
}
int topla(int a,int b){
   return artir(a,b);
}

int bilge() {
    int toplam;
    toplam=topla(3,5);
    printf("%d",toplam);
    return 0;
}