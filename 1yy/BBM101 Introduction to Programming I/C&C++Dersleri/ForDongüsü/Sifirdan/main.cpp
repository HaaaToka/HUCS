#include <stdio.h>

int main(){
    int i;
    int a[5];
    int leng;
    leng=5;
    for(i=0;i<leng;i++){
        a[i]=i+1;
    }
    for(i=0;i<leng;i++){
        printf("(%d),",a[i]);
    }
    return 0;
}
