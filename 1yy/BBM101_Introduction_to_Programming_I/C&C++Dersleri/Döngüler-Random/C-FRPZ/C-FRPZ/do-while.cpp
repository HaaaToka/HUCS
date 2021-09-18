#include <stdio.h>
int deneme2() {
    int i=1;
    int sayi;
    int faktoryel=1;
    printf("Faktoryeli Alinacak Sayiyi Giriniz : ");
    scanf("%d",&sayi);
    do{
        faktoryel=faktoryel*i;
        i++;
    }
    while(i<sayi);
    printf("%d! = %d",sayi,faktoryel);



    return 0;
}

