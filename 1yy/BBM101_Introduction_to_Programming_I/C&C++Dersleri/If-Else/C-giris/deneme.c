#include <stdio.h>

int main(){
    int yas;
    printf("Yasinizi Giriniz : ");
    scanf("%d",&yas);
    if(yas<18){
        printf("Resit Degil");
    }
    else if(18<=yas && yas<=30){
        printf("Genc");
    }
    else if(30<=yas && yas<=50){
        printf("Orta Yasli");
    }
      else{
        printf("Yasli");
    }



    return 0;
}
