#include <stdio.h>

int faktoryel(int sayi){
    if(sayi==0) {
        return 1;
    }
    else {
        return sayi*faktoryel((sayi-1));
    }
}

int maw() {
    int sayi;
    scanf("%d",&sayi);
    printf("%d",faktoryel(sayi));
    return 0;
}