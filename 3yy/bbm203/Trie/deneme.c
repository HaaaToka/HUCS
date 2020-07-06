#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <string.h>


struct node{
    int data;
    int childCount;
    struct node **children;
};

struct tree{
    struct node * root;
};


struct node * createNode(int data){
    struct node *nw = (struct node *)malloc(sizeof(struct node));
    nw->data=data;
    nw->childCount=0;
    nw->children=(struct node **)malloc(sizeof(struct node*));
    /*int i;
    for(i=0;i<256;i++){
        nw->children[i]=(struct node *)malloc(sizeof(struct node));
        nw->children[i]=NULL;
    }*/
    return nw;
}

struct tree * emptyTree(){
    struct tree * mytree = (struct tree *)malloc(sizeof(struct tree));
    mytree->root=NULL;//dont forget change root data
    return mytree;
}

void addNode(struct node *addthis,int data){
    //printf("\t addNODE  %d bunodaa  ",addthis->data);
    //printf("  %d bunu ekliyom\n",nw->data);
    //addthis->children[addthis->childCount++]=(struct node *)malloc(sizeof(struct node));
    addthis->children[addthis->childCount]=(struct node*)malloc(sizeof(struct node));
    addthis->children[addthis->childCount++]=createNode(data);
}

struct node * findNode(struct node *giveRoot,int data){
    //printf("Aranan %d --  Suanki node  %d\n",data,giveRoot->data );
    if(giveRoot->data==data){
        return giveRoot;
    }
    struct node *tmp=(struct node*)malloc(sizeof(struct node));
    //struct node *tmp=createNode(0);
    int i=0;
    while (i++ < giveRoot->childCount){
        tmp=findNode(giveRoot->children[i-1],data);
        if (tmp->data==data) {
            break;
        }
    }
    return tmp;
}

void preOrder(struct node * giveMeNode){
    int i=0;
    printf("-->> %d %d\n",giveMeNode->data,giveMeNode->childCount);
    while (i++ < giveMeNode->childCount){
        preOrder(giveMeNode->children[i-1]);
    }

}


void preOrderPrint(struct node *giveMeNode, int data){
    printf("\n\n\t PRE ORDER\n\n");
    preOrder(findNode(giveMeNode,data));
}

struct node *findParentNode(struct node *giveMeNode, int searching){
    //printf("Aranan %d --  Suanki node  %d\n",searching,giveMeNode->data );
    int i=0,k=0,flag=0;
    while ( i++ < giveMeNode->childCount){
        //printf("\t Aranan %d --  Suanki node  %d\n",searching,giveMeNode->children[i-1]->data);
        if(giveMeNode->children[i-1]->data==searching){
            return giveMeNode;
        }
    }
    struct node *tmp=createNode(0);
    i=0;
    while (i++ < giveMeNode->childCount){
        //printf("\t\t Aranan %d --  Suanki node  %d\n",searching,giveMeNode->children[i-1]->data);
        tmp=findParentNode(giveMeNode->children[i-1],searching);
        //printf("\t\t %d\n",tmp->childCount);
        flag=0;
        k=0;
        while ( k++ < tmp->childCount){
            //printf("\t\t\t Aranan %d --  Suanki node  %d\n",searching,tmp->children[k-1]->data);
            if(tmp->children[k-1]->data==searching){
                //printf("\t\t\t ANANANA \n");
                flag=1;
                break;
            }
            //printf("\t\t\t Aranan %d --  Suanki node  %d\n",searching,giveMeNode->children[k-1]->data);
        }
        if(flag){ break;}
    }
    return tmp;
}

void operationDelete(struct tree *giveMeTree, int deleteData){
    int  i;
    struct node *willDelete = findNode(giveMeTree->root,deleteData);

    if(willDelete==giveMeTree->root){

        struct node *first = (struct node *)malloc(sizeof(struct node));
        first=giveMeTree->root->children[0];

        for (i = 1; i < willDelete->childCount; i++) {
            first->children[first->childCount++]=willDelete->children[i];
            willDelete->children[i]=createNode(-1);
        }
        free(willDelete);
        free(giveMeTree->root);
        giveMeTree->root=willDelete->children[0];
    }
    else{

        struct node *parent = (struct node *)malloc(sizeof(struct node));
        parent=findParentNode(giveMeTree->root,deleteData);
        printf("   Parent %d,  silinecek %d\n",parent->data,willDelete->data);

        int whereIsDelete=0;
        int parentCC=parent->childCount,deleteCC=willDelete->childCount;

        while (whereIsDelete++<parentCC){
            if(parent->children[whereIsDelete-1]->data==deleteData){
                whereIsDelete--;
                break;
            }
        }
        printf("where %d   deleteCC %d\n",whereIsDelete,deleteCC);


        if(deleteCC==1){
            parent->children[whereIsDelete]=willDelete->children[0];
            free(willDelete);
        }
        else if(deleteCC==0){
            free(parent->children[whereIsDelete]);
            for(i=whereIsDelete;i<parentCC-whereIsDelete;i++){
                printf(" %d \n",i);
                parent->children[i]=parent->children[i+1];
            }
            parent->childCount--;
        }
        else{

            if(whereIsDelete==0){
                for(i=1;i<parentCC;i++){
                    printf("\n\t %d nereye   %d nerden",parentCC+deleteCC-1-i,parentCC-i);
                    parent->children[parentCC+deleteCC-1-i]=parent->children[parentCC-i];
                    //free(parent->children[parentCC-i]);
                }
                for(i=deleteCC-1;i>=0;i--){
                    printf("\n  %d i",i);
                    parent->children[i]=willDelete->children[i];
                }
            }
            else if(whereIsDelete==parentCC-1){
                for(i=0;i<deleteCC;i++){
                    parent->children[parentCC+i-1]=willDelete->children[i];
                }
            }
            else{
                int tt=willDelete->childCount;
                for(i=0;i<parentCC-whereIsDelete-1;i++){
                    parent->children[parentCC+deleteCC-2-i] = parent->children[parentCC-i-1];
                }
                for(i=0;i<deleteCC;i++){
                    parent->children[whereIsDelete+deleteCC-1-i] = willDelete->children[deleteCC-1-i];
                }
            }
            parent->childCount=parentCC+deleteCC-1;
        }
    }
}


int main(){

    struct tree * mytree = (struct tree *)malloc(sizeof(struct tree));
    mytree->root=createNode(2);

    addNode(mytree->root,1);
    addNode(mytree->root,92);
    addNode(mytree->root,19);
    addNode(mytree->root,127);
    addNode(mytree->root,7);

    addNode(mytree->root->children[4],25);
    addNode(mytree->root->children[4],23);
    addNode(mytree->root->children[2],5);
    addNode(mytree->root->children[2],13);
    addNode(mytree->root->children[2],75);

    addNode(mytree->root->children[2]->children[0],11);
    addNode(mytree->root->children[2]->children[1],8);
    addNode(mytree->root->children[2]->children[0],14);



    addNode(mytree->root->children[0],3);
    addNode(mytree->root->children[0],4);
    addNode(mytree->root->children[3],21);
    addNode(mytree->root->children[3],22);


    preOrder(mytree->root);
    printf("%d",mytree->root->children[0]->children[1]);
    printf("DNENE\n\n");


    operationDelete(mytree,19);
    addNode(mytree->root,99);
    addNode(mytree->root->children[4],77);
    printf("\n\n\tOKAN\n");
    preOrder(mytree->root);
    printf("\tALAN\n");

    return 0;
}