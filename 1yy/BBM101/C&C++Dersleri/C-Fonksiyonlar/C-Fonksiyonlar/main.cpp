#include <stdio.h>

void HelloWorld(){
    printf("HelloWorld\n");
}
int toplama(int a,int b){
    return a+b;
}

int mai() {
    int toplam;
    HelloWorld();
    toplam=toplama(3,5);
    printf("%d",toplam);
    return 0;
}