#include <stdio.h>
#include <stdlib.h>

struct Point{
    char data;
    struct Point *next;
};

typedef struct{
    int stcount;
    int maxi;
    struct Point *top;
}stack;
typedef struct{
    int quecount;
    int maxim;
    struct Point *rear;
    struct Point *front;
}queue;

typedef struct{
    stack s;
    queue q;
    queue history;
}cOs;


void addHistory(queue *hist,char dd);
void printHistories(queue *hist,FILE *out);
void push(cOs *mach,char dd);
void pop(cOs *mach, cOs *server,int isServer);
void enqueue(cOs *mach,char dd);
void dequeue(cOs *mach,cOs *server,int isServer);


int main(int argc, char *argv[]){
    FILE *inputFile1;
    FILE *inputFile2;
    FILE *outputFile;

    int i;
    int count;
    int cliser;
    int operationCount;
    int sc,qc;

    char ttt[255],tttt[255];
    char op[255];
    char o,g1[count],g2;

    inputFile1=fopen(argv[1],"r");
    inputFile2=fopen(argv[2],"r");
    outputFile=fopen(argv[3],"w");

    fscanf(inputFile1,"%s\n",ttt); ///how many are there client and server
    count=atoi(ttt);

    cOs *machines=(cOs *) malloc(count*sizeof(cOs));

    for(i=0;i<count;i++){  /// create server and clients
        fscanf(inputFile1,"%s %s",ttt,tttt);
        sc=atoi(tttt);qc=atoi(ttt);
        fgetc(inputFile1);
        machines[i].q.maxim=qc;
        machines[i].q.quecount=0;
        machines[i].s.maxi=sc;
        machines[i].s.stcount=0;
        machines[i].history.maxim=1;
        machines[i].history.quecount=0;
    }

    fgets(op,255,inputFile2);
    operationCount = atoi(op);
    for(i=0;i<operationCount;i++){ ///read input2.txt for operations
        o=fgetc(inputFile2);
        fscanf(inputFile2," %s ",g1);
        g2=fgetc(inputFile2);
        fgetc(inputFile2);
        cliser=atoi(g1);
        switch(o){
            case 'A':
                enqueue(&machines[cliser-1],g2);
                break;
            case 'I':
                push(&machines[cliser-1],g2);
                break;
            case 'S':
                if(machines[cliser-1].s.stcount>0){
                    pop(&machines[cliser-1],&machines[count-1],0);
                }
                else{
                    dequeue(&machines[cliser-1],&machines[count-1],0);
                }
                break;
            case 'O':
                if(machines[count-1].s.stcount>0){
                    pop(&machines[count-1],&machines[count-1],1);
                }
                else{
                    dequeue(&machines[count-1],&machines[count-1],1);
                }
                break;
            default:
                printf("I didnt find true location :)\n");
                break;
        }
    }

    for(i=0;i<count;i++){ ///print logging histories
        printHistories(&machines[i].history,outputFile);
    }

    fclose(inputFile1);
    fclose(inputFile2);
    fclose(outputFile);
    return 0;
}

void push(cOs *mach,char dd){ ///add new Point to stack
    if(mach->s.stcount < mach->s.maxi){
        struct Point *new = malloc(sizeof(struct Point));
        new->data=dd;
        new->next=mach->s.top;
        mach->s.top=new;
        mach->s.stcount++;
    }
    else{addHistory(&mach->history,'2');}
}

void pop(cOs *mach, cOs *server,int isServer){ ///delete last Point in stack
    if(mach->s.stcount==0){
        if(mach->q.quecount==0){addHistory(&mach->history,'3');}
    }
    else{
        struct Point *died;
        died=mach->s.top;
        if(!isServer) enqueue(server,died->data);
        addHistory(&mach->history,died->data);
        mach->s.top=mach->s.top->next;
        free(died);
        mach->s.stcount--;
    }
}

void enqueue(cOs *mach,char dd){ ///add new Point to squeue
    if(mach->q.quecount < mach->q.maxim){
        struct Point *new = malloc(sizeof(struct Point));
        new->data=dd;
        if(mach->q.quecount==0){mach->q.front=new; mach->q.rear=new; mach->q.front->next=mach->q.rear; mach->q.quecount++;}
        else{
            mach->q.rear->next=new;
            mach->q.rear=new;
            mach->q.quecount++;
        }}
    else addHistory(&mach->history,'1');
}

void dequeue(cOs *mach,cOs *server,int isServer){ ///delete first Point in queue
    if(mach->q.quecount==0){if(mach->s.stcount==0) addHistory(&mach->history,'3');}
    else{
        struct Point *died;
        died=mach->q.front;
        if(!isServer) enqueue(server,died->data);
        addHistory(&mach->history,died->data);
        mach->q.front=mach->q.front->next;
        free(died);
        mach->q.quecount--;
    }
}

void addHistory(queue *hist,char dd){ ///add new log
    struct Point *new = malloc(sizeof(struct Point));
    new->data=dd;
    if(hist->quecount==0){hist->front=new; hist->rear=new; hist->front->next=hist->rear; hist->quecount++;}
    else{
        hist->rear->next=new;
        hist->rear=new;
        hist->quecount++;
    }
}

void printHistories(queue *hist,FILE *out){ ///print logging history
    while(hist->quecount){
        struct Point *died;
        died=hist->front;
        fputc(died->data,out);
        fputc(' ',out);
        hist->front=hist->front->next;
        free(died);
        hist->quecount--;
    }
    fputc('\n',out);
}
