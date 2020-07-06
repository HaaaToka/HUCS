#include<stdio.h>
#include<math.h>
int main(){
    int i;
    int isP=1;
    int sayi;
    printf("Asal Olup Olmadigini Merak Ettiginiz Sayiyi Giriniz : ");
    scanf("%d",&sayi);
    for(i=2;i<sayi;i++){
        if(sayi%i==0){
           isP=0;
            break;
        }
    }
    /*
     * for(i=2;i<=sayi/2;i++)
     * for(i=2;i<=sqrt(sayi);i++)
     */
    if(isP==1){
        printf("%d Asaldir",sayi);
    }
    else{
        printf("%d Asal Degildir",sayi);
    }
    return 0;
}