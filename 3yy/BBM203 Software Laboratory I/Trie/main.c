#include "tree.h"
#include "linkedlist.h"


int main(int argc, char *argv[]){


    FILE *inputFile1;
    FILE *inputFile2;
    FILE *outputFile;

    struct tree *treem = (struct tree *)malloc(sizeof(struct tree));
    //struct slist *lasts = emptyList();
    struct slist *lasts = (struct slist *)malloc(sizeof(struct slist));


    char in1[256],in2[256];
    printf("Input 1 path: ");
    scanf("%255s",in1);
    inputFile1=fopen(in1,"r");
    printf("Input 2 path: ");
    scanf("%255s",in2);
    inputFile2=fopen(in2,"r");
    outputFile=fopen("output.txt","w");


    int i,j;
    int *ignoreCount=(int *)malloc(sizeof(int)*100);
    int a,b,temp,howmanyline=1;

    while (!feof(inputFile1)){
        fscanf(inputFile1,"%d %d",&a,&temp);
        howmanyline++;
    }
    howmanyline--;
    //printf("%d hownmaynLine\n\n",howmanyline);
    fclose(inputFile1);


    inputFile1=fopen(in1,"r");
    i=0;j=0;

    int nodeData;

    fscanf(inputFile1,"%d %d\n",&nodeData,&b);
    if(howmanyline>0) {
        ignoreCount[i++] = b;
        howmanyline = howmanyline - b;
    }
   // printf("%d %d \n",nodeData,b);

    treem->root=createNode(nodeData);
    lasts->head=createSicim(treem->root);

    struct sicim *traveler = lasts->head;

    while (!feof(inputFile1)){
        ignoreCount[j]--;
        fscanf(inputFile1,"%d %d\n",&nodeData,&b);
        //printf("%d %d\n",nodeData,b);
        addNode(traveler->nd,nodeData);

        if(howmanyline>=0) {
            ignoreCount[i++] = b;
            howmanyline=howmanyline-b;
        }
        if(!ignoreCount[j]){
            refreshList(lasts);
            deleteSicim(lasts);
            traveler=lasts->head;
            j++;
            continue;
        }

        if(traveler->next!=NULL){traveler=traveler->next;}
        else{traveler=lasts->head;}

    }


    //preOrderPrint(treem,1);
printf("\n");
    char op;
    while(!feof(inputFile2)){
        fscanf(inputFile2,"%c %d\n",&op,&b);
        //printf("%c %d\n",op,b);
        if(op=='l'){
            preOrderPrint(treem,b,outputFile);
        }
        else{
            operationDelete(treem,b);
           /* printf("\n%d   PREPPRE\n",b);
            preOrderPrint(treem,treem->root->data);
            printf("   PREPREE\n");*/
        }
    }

    fclose(inputFile1);
    fclose(inputFile2);
    fclose(outputFile);

    return 0;
}
