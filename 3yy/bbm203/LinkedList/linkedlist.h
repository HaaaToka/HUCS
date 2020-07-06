#ifndef linklist
#define linklist

#include <string.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
  char *data;
    int counter;
  struct node * next;
} Node;

typedef struct list {
  Node * head;
} linkedList;


linkedList * emptylist();
int isThere(char *search,linkedList * lis);
void addNode(char *data, linkedList * list);

void printlinkedList(linkedList * list);
void reverse(linkedList * list);


#endif
