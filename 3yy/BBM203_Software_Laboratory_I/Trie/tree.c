#include "tree.h"

struct node * createNode(int data){
    struct node *nw = (struct node *)malloc(sizeof(struct node));
    nw->data=data;
    nw->childCount=0;
    nw->children=(struct node **)malloc(sizeof(struct node*));
    return nw;
}

struct tree * emptyTree(){
    struct tree * mytree = (struct tree *)malloc(sizeof(struct tree));
    mytree->root=NULL;
    return mytree;
}

void addNode(struct node *addthis,int data){
    addthis->children[addthis->childCount]=(struct node*)malloc(sizeof(struct node));
    addthis->children[addthis->childCount++]=createNode(data);
}

struct node * findNode(struct node *giveRoot,int data){
    if(giveRoot->data==data){
        return giveRoot;
    }
    struct node *tmp=(struct node*)malloc(sizeof(struct node));
    tmp=createNode(-1);
    int i=0;
    while (i++ < giveRoot->childCount){
        tmp=findNode(giveRoot->children[i-1],data);
        if (tmp->data==data) {
            break;
        }
    }
    return tmp;
}

void preOrder(struct node * giveMeNode,FILE *a,int f){
    int i=0;
    if(f){fprintf(a,"%d",giveMeNode->data);}
    else{fprintf(a,",%d",giveMeNode->data);}
    while (i++ < giveMeNode->childCount){
        preOrder(giveMeNode->children[i-1],a,0);
    }
}

void preOrderPrint(struct tree *giveMeTree, int data, FILE *a){
    struct node *t=findNode(giveMeTree->root,data);
    if(t->data==-1){return;}
    preOrder(t,a,1);
    fputc('\n',a);
}


struct node *findParentNode(struct node *giveMeNode, int searching){
    int i=0,k=0,flag=0;
    while ( i++ < giveMeNode->childCount){
        if(giveMeNode->children[i-1]->data==searching){
            return giveMeNode;
        }
    }
    struct node *tmp=createNode(0);
    i=0;
    while (i++ < giveMeNode->childCount){
        tmp=findParentNode(giveMeNode->children[i-1],searching);
        flag=0;
        k=0;
        while ( k++ < tmp->childCount){
            if(tmp->children[k-1]->data==searching){
                flag=1;
                break;
            }
        }
        if(flag){ break;}
    }
    return tmp;
}

void operationDelete(struct tree *giveMeTree, int deleteData){
    int  i;
    struct node *willDelete = findNode(giveMeTree->root,deleteData);
    if(willDelete->data==-1){return;}

    if(willDelete==giveMeTree->root){

        struct node *first = (struct node *)malloc(sizeof(struct node));
        first=giveMeTree->root->children[0];

        for (i = 1; i < willDelete->childCount; i++) {
            first->children[first->childCount++]=willDelete->children[i];
            willDelete->children[i]=createNode(-1);
        }
        free(giveMeTree->root);
        giveMeTree->root=willDelete->children[0];
    }
    else{

        struct node *parent = (struct node *)malloc(sizeof(struct node));
        parent=findParentNode(giveMeTree->root,deleteData);

        int whereIsDelete=0;
        int parentCC=parent->childCount,deleteCC=willDelete->childCount;

        while (whereIsDelete++<parentCC){
            if(parent->children[whereIsDelete-1]->data==deleteData){
                whereIsDelete--;
                break;
            }
        }

        if(deleteCC==1){
            parent->children[whereIsDelete]=willDelete->children[0];
            free(willDelete);
        }
        else if(deleteCC==0){
            //printf("\n GIRDIM %d sagladi  where %d   %d \n",willDelete->data,whereIsDelete,parentCC-whereIsDelete);
            free(parent->children[whereIsDelete]);
            for(i=whereIsDelete;i<parentCC;i++){
                //printf("parent[%d]\n",i);
                parent->children[i]=parent->children[i+1];
            }
            parent->childCount--;
        }
        else{

            if(whereIsDelete==0){
                for(i=1;i<parentCC;i++){
                    parent->children[parentCC+deleteCC-1-i]=parent->children[parentCC-i];
                }
                for(i=deleteCC-1;i>=0;i--){
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
