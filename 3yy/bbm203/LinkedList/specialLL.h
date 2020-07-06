#ifndef sll
#define sll

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

#include "linkedlist.h"

typedef struct speacialnode {
    char *data;
    int counter;
    struct specialnode *next;
    linkedList *after;
} specialNode;

typedef struct splist {
    specialNode *head;
} specialLL;


specialLL * SPemptylist();
int SPisThere(char *search,char *aft, specialLL *lis);
void SPaddNode(char *data,char *aft, specialLL *list);

void SPprint(specialLL *list);
void SPreverse(specialLL *list);

void bubbleSort(specialLL *list);
void SPappend(specialLL *list,char *data,int counter);
void SPfirsts(specialLL *list);
void SPdelete(char *data, specialLL * list);
void SPcosinusOnlyTwo(specialLL *one,specialLL *two);


char *string_copy(const char *from);

#endif
