#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int man() {
    int boy,kere;
    printf("Zarin Boyutunu Giriniz : ");
    scanf("%d",&boy);
    printf("Kac Kere Aticaginizi Giriniz : ");
    scanf("%d",&kere);
    srand((unsigned int)(time(NULL)));
    while(kere>0){
        printf("%d Attiniz \n",rand() %boy);
        kere-=1; // kere--
    }
    return 0;
}