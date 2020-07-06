
#ifndef treey
#define treey


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


struct tree * emptyTree();
struct node * createNode(int data);
void addNode(struct node *addthis,int data);
void preOrderPrint(struct tree *giveMeTree, int data,FILE *a);
void operationDelete(struct tree *giveMeTree, int deleteData);

#endif
