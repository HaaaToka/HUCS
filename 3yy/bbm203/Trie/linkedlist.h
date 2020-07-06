
#ifndef last
#define last

#include "tree.h"


struct sicim{
    struct node *nd;
    struct sicim *next;
};

struct slist{
    int count;
    struct sicim *head;
};

struct slist * emptyList();
struct sicim * createSicim(struct node *giveMeNode);
void addSicim(struct slist *giveMeList,struct node *giveMeNode);
void deleteSicim(struct slist *giveMeList);
void LLprint(struct slist *giveMeList);
void refreshList(struct slist *giveMeList);
void reverse(struct slist *list);
#endif
