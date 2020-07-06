#include "linkedlist.h"

linkedList * emptylist(){
  linkedList * list = (linkedList *)malloc(sizeof(linkedList));
  list->head = NULL;
  return list;
}

void printlinkedList(linkedList * list) {
  if(list->head==NULL) {return;}
  Node * current = list->head;
  if(list->head == NULL)
    return;
  while(current != NULL){
    printf("%s (%d) ", current->data, current->counter);
    current = current->next;
  }
}


int isThere(char *search,linkedList * lis){
  /*
      return 0 is mean there is no searched item
   */
  //struct node *temp;
  Node *temp;
  temp = lis->head;
  while(temp!=NULL){
    if(strcmp(temp->data,search)==0){
         temp->counter++;
         return 1;
     }
    temp=temp->next;
  }
  return 0;
}

void addNode(char *data, linkedList * list){

  Node *nw = (Node *) malloc(sizeof(Node));
  nw->data=data;
  nw->next=NULL;
  nw->counter=1;
  if(!isThere(data,list)){
    nw->next=list->head;
    list->head=nw;
  }
}
