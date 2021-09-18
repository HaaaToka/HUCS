#include "linkedlist.h"

struct slist * emptyList(){
    struct slist *dlist = (struct slist *)malloc(sizeof(struct slist));
    dlist->count=0;
    dlist->head=NULL;
    return dlist;
}

struct sicim *createSicim(struct node * gvN){
    struct sicim *nw = (struct sicim*)malloc(sizeof(struct sicim));
    nw->nd=gvN;
    nw->next=NULL;
    return nw;
}

void addSicim(struct slist *giveMeList,struct node *giveMeNode){
    struct sicim*nw = createSicim(giveMeNode);
    giveMeList->count++;
    if(giveMeList->head==NULL){
        giveMeList->head=nw;
        return;
    }
    nw->next=giveMeList->head;
    giveMeList->head=nw;
}

void refreshList(struct slist *giveMeList){
    struct sicim *temp = giveMeList->head;
    while(temp!=NULL){
        int i = temp->nd->childCount;
        while (i--){
            struct sicim *nw = (struct sicim *)malloc(sizeof(struct sicim));
            nw = createSicim(temp->nd->children[i]);
            nw->next=temp->next;
            temp->next=nw;
        }
        temp=temp->next;
    }
}

void deleteSicim(struct slist * list){

    struct sicim * current = list->head;
    struct sicim * previous = list->head;

    while(current != NULL){
        if(current->nd->childCount!=0){
            if(current==list->head){
                previous=previous->next;
                //free(list->head);
                list->head=list->head->next;
                current=list->head;
                continue;
            }
            else{
                previous->next=current->next;
                free(current);
                current=previous->next;
                continue;
            }
        }
        if(current==previous){
            current=current->next;
        }
        else{
            current=current->next;
            previous=previous->next;
        }
    }
}


void reverse(struct slist *list){
    struct sicim * reversed=NULL;
    struct sicim * current=list->head;
    struct sicim * temp = NULL;
    while(current!=NULL){
        temp=current;
        current=current->next;
        temp->next=reversed;
        reversed=temp;
    }
    list->head=reversed;
}

void LLprint(struct slist *giveMeList){
    printf("\n\t LLPRINT \n\n");
    struct sicim *tmp = giveMeList->head;
    if(tmp==NULL){return;}
    while (tmp!=NULL){
        printf("%d ",tmp->nd->data);
        tmp=tmp->next;
    }
    printf("\n");
}
