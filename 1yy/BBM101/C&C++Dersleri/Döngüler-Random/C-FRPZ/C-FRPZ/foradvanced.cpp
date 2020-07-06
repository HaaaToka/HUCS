#include<stdio.h>
#include<math.h>
int denem123(){
    int sayi;
    int i=2;
    int k;
    int j;
    int counter=0;
    int isP;
    int primes[100];
    printf("'a Kadar Asallari Yazdirmak İstediğiniz Sayiyi Giriniz : ");
    scanf("%d",&sayi);
    while(i<=sayi){
        isP=1;
        for(j=2;j<=sqrt(sayi);j++){
            if(i%j==0) {
                isP = 0;
            }
        }
        if(isP==1){
            primes[counter]=i;
            counter+=1;

        }
    i++;
    }
    for(k=0;k<counter;k++){
        printf("%d Asaldir \n",primes[k]);
    }




    return 0;
}