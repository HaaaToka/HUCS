#include "specialLL.h"
#include "linkedlist.h"


size_t strlen(const char *string);
char *strrev(char *str);
char* itoa(int i, char b[]);



specialLL * SPemptylist(){
    specialLL *list = (specialLL *)malloc(sizeof(specialLL));
    list->head = NULL;
    return list;
}

void SPprint( specialLL *list) {
    specialNode * current = list->head;
    if(current == NULL){return;}
    while(current != NULL){
        if(current==list->head) printf("head CURRENT");
        printf(" %s (%d) --> ", current->data, current->counter);
        printlinkedList(current->after);
        printf("\n" );
        current = current->next;
    }

}



int SPisThere( char *search,char *aft,specialLL *lis){
    /*
        return 0 is mean there is no searched item
     */
    specialNode *temp;
    temp = lis->head;
    while(temp!=NULL){
        if(strcmp(temp->data,search)==0){
            temp->counter++;
            if(strcmp(aft,"filtresizbomonti")!=0){
                char *xx=string_copy(aft);
                addNode(xx,temp->after);
                }

            return 1;
        }
        temp=temp->next;
    }
    return 0;
}

void SPaddNode( char *data, char *aft, specialLL * list){
    if(strcmp(data,"filtresizbomonti")==0){return;}
    specialNode *nw = (specialNode *) malloc(sizeof(specialNode));
    nw->data=data;
    nw->next=NULL;
    nw->after=emptylist();
    char *xxx=string_copy(aft);
    addNode(xxx,nw->after);
    nw->counter=1;
    if(!SPisThere(data,xxx, list)) {
        nw->next = list->head;
        list->head = nw;
    }
}





void SPreverse(specialLL *list){
    specialNode *reverse = NULL;
    specialNode *current = list->head;
    specialNode *temp = NULL;
    while(current != NULL){
        temp = current;
        current = current->next;
        temp->next = reverse;
        reverse = temp;
    }
    list->head = reverse;
}


void bubbleSort(specialLL *list) {
    int flag = 1;


    specialNode *current = list->head;
    specialNode *nextOne = list->head->next;
    specialNode *temp = NULL;
    specialNode *prev=NULL;

    if (list->head == NULL || nextOne == NULL) { return; }

    while (flag) {

        flag = 0;

        current = list->head;
        prev=current;
        nextOne=current->next;

        while(nextOne!=NULL){
            if(current->counter > nextOne->counter){
                if(current == list->head){
                    temp=nextOne->next;
                    nextOne->next = current;
                    current->next=temp;
                    list->head=nextOne;
                    prev=list->head;
                    specialNode *abc=list->head->next;

                }
                else{
                    prev->next=nextOne;
                    current->next=nextOne->next;
                    nextOne->next=current;
                    prev=nextOne;
                }
                flag++;
            }
            else{
                current=current->next;
                while(prev->next!=current){prev=prev->next;}
            }
            nextOne=current->next;
        }
    }
}



void SPappend(specialLL *list,char *data,int counter){


//BAS VE SON EKLEME

    specialNode *temp;
    temp = list->head;
    while(temp!=NULL){
        if(strcmp(temp->data,data)==0){
            temp->counter=temp->counter+counter;
            SPreverse(list);
            bubbleSort(list);
            SPreverse(list);
            return;
        }
        temp=temp->next;
    }

    specialNode *nw = (specialNode *)malloc(sizeof(specialNode));
    nw->data=data;
    nw->next=NULL;
    nw->counter=counter;
    nw->after=emptylist();

    if(list->head->counter >= nw->counter){
        specialNode *current=list->head;
        specialNode *nextNode=list->head->next;

        while(nw->counter <= nextNode->counter && nextNode!=NULL){
            current=current->next;
            nextNode=nextNode->next;
        }

        current->next=nw;
        nw->next=nextNode;
    }
    else{
        nw->next=list->head;
        list->head=nw;
    }
}

void SPfirsts(specialLL *list){

    specialNode *current=list->head;
    specialNode *nextOne=list->head->next;
    int tempCount=list->head->counter;

    printf(" %s-%s\n",current->data,current->after->head->data);
    int kalan = 2;
    while(nextOne!=NULL && kalan > 0){
        if(current->counter != nextOne->counter ){
            printf(" %s-%s\n",nextOne->data,nextOne->after->head->data );
            kalan--;
        }
        current=current->next;
        nextOne=nextOne->next;
    }
}


void SPdelete(char *data, specialLL * list){


  specialNode * current = list->head;
  specialNode * previous = list->head;
  int i=0;
  while(current != NULL){
    if(strcmp(current->data,data)==0){
      if(current == list->head){list->head = current->next;}
      else{previous->next=current->next;}

      free(current);
      return;
    }
    current=current->next;
    if(i!=0){previous=previous->next;}
    i=1;
  }
}



void SPcosinusOnlyTwo(specialLL *one,specialLL *two){

    int i,j,lengthofLine=1;
    char ***met = (char ***)malloc(3 * sizeof(char **));
    for(i=0; i<3 ; i++){
        met[i] = (char **)malloc(40*sizeof(char *));
    }

    specialNode *temp = one->head;

    met[1][0]=string_copy("d1");

    for(i=1; i<11;i++){
        if(temp!=NULL){
            met[0][i]=string_copy(temp->data);
            printf("met[0][%d]  %s\n",i,met[0][i] );
            lengthofLine++;
        }
        else{break;}
        temp=temp->next;
    }
lengthofLine--;
    met[2][0]=string_copy("d2");
    temp=two->head;
    int flag;
    for(i=0;i<10;i++){
        j=1;
        flag=0;
        if(temp!=NULL){
            while(j<=lengthofLine && !flag){
                if(strcmp(met[0][j],temp->data)==0){
                    flag=1;
                }
                j++;
            }
        }else{break;}
        if(!flag){

            met[0][++lengthofLine]=string_copy(temp->data);
        }
        temp=temp->next;
    }
int k;

for(j=1;j<=lengthofLine;j++){

    k=whatIsItCounter(met[0][j],one);
    printf("i %d   met[0][%d]%s\n",k,j,met[0][j]);
    met[1][j]=string_copy((char *)&k);

    i=whatIsItCounter(met[0][j],two);
    printf("i %d   met[0][%d]%s\n",i,j,met[0][j]);
    met[2][j]=string_copy((char *)&i);
}


for(i=0;i<3;i++){
    j=1;
    while(met[i][j]!=NULL){
        printf("%s\t",met[i][j++]);
    }
    printf("\n");
}
for(i=1;i<3;i++){
    j=1;
    while(met[i][j]!=NULL){
        printf("%d\t",*met[i][j++]);
    }
    printf("\n");
}


    double ab=0;
    double a=0;
    double b=0;
    double cosineSimilarity=0;

    for(i = 1; i<=lengthofLine ; i++){
        ab = ab + ((*met[1][i]) * (*met[2][i]));
        a = a + ((*met[1][i]) * (*met[1][i]));
        b = b + ((*met[2][i]) * (*met[2][i]));
    }
    a=sqrt(a);
    b=sqrt(b);
    printf("number of differen word %d\n", lengthofLine);
    if(a==0 || b==0){printf("ERROR Divide by Zero\n");}
    else{
        printf("dot product of doc 1 and doc 2 is =%f\n",ab);
        printf("vect product of doc 1 and doc 2 is =%f\n",a*b);
        cosineSimilarity=ab/(a*b);
    }
    printf("cos sim of d1 and d2 %f\n",cosineSimilarity );
}

int whatIsItCounter(char *search,specialLL *list){
    specialNode *temp = list->head;
    printf("bunu arıyorum %s   \n", search);
    while(temp!=NULL){
        if(strcmp(temp->data,search)==0){
            printf("BUNU RETURNLUYOM  %d  \n",temp->counter );
            return temp->counter;
        }
        temp=temp->next;
    }
    return 0;
}





char *string_copy(const char *from){
    char* ptr = from;
    int originalSize = 0;
    char* previous = NULL;
    while (*ptr++ != '\0')
        originalSize++;
    previous = (char*) malloc((originalSize+1) * sizeof(char));
    previous[originalSize] = '\0';
    ptr = &from[0];
    int idx = 0;
    while (*ptr != '\0')
        previous[idx++] = *ptr++;
    return previous;
}
