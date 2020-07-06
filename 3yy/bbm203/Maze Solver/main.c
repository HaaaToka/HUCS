#include <stdarg.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>

struct Point {
    char data;
    int x,y;
    struct Point *next;
};
struct Point *top=NULL;
struct Point *bot=NULL; ///somewhere I must clean wall which I created

void pushtwo(char dt,int px,int py){
    struct Point *new=malloc(sizeof(struct Point));
    new->data=dt;
    new->x=px;
    new->y=py;
    new->next=bot;
    bot=new;
}

void push(char dt,int px,int py){ ///add something to stack
    struct Point *new=malloc(sizeof(struct Point));
    new->data=dt;
    new->x=px;
    new->y=py;
    new->next=top;
    top=new;
}

void pop(){///delete last adding Point
    if(top==NULL){
        printf("Stack is empty\n");
    }
    else{
        struct Point *died;
        died=top;
        top=top->next;
        free(died);
    }
}

int isKeyinStack(char key){  ///when we arrive door ,we must check our keys
    struct Point *temp;
    temp=top;
    while(temp!=NULL){
        if(key==temp->data){return 1;}
        temp=temp->next;
    }
    return 0;
}

int stackCount(){ /// how many are Points in stack
    struct Point *temp;
    int i=0;
    temp=top;
    while(temp!=NULL){
        i++;
        temp=temp->next;
    }
    return i;
}

int stackPathCount(){ ///path size it means how many steps we are out from the maze. I use this function to reverse stack of path
    struct Point *temp;
    int i=0;
    temp=top;
    while(temp!=NULL){
        i++;
        if((temp->data >= 'a' && temp->data<='z')||(temp->data>='A' && temp->data<='Z')){i++;}
        temp=temp->next;
    }
    return i;
}

void printPath(FILE *output){ /// printing exit path
    struct Point *temp;
    temp=top;
    int xDif,yDif;
    int stPc=stackPathCount();
    int stc=stackCount();
    char path[stPc];
    int i;

    fputs("Start  ",output);
    while(stc-- > 0){
        xDif=temp->x-temp->next->x;
        yDif=temp->y-temp->next->y;

        if(((temp->data>='a' && temp->data<='z')||(temp->data>='A' && temp->data<='Z')) && temp->data!='E'){
            path[stPc--]=temp->data;
        }

        ///which direction
        if(xDif==0 && yDif==1){path[stPc--]='E';}
        else if(xDif==0 && yDif==-1){path[stPc--]='W';}
        else if(xDif==1 && yDif==0){path[stPc--]='S';}
        else if(xDif==-1 && yDif==0){path[stPc--]='N';}


        if(stc>1){temp=temp->next;}
    }

    for(i=4;i<stackPathCount()+1;i++){
        fputc(path[i],output);
        fputc(' ',output);
    }

    fputs("  Exit",output);
}

void doOrginalOnes(char** one){ ///return to orginal maxtrix form
    struct Point *temp;
    temp=bot;
    while(temp!=NULL){
        one[temp->x][temp->y]='0';
        temp=temp->next;
    }
}

void doOrginal(char** tdA,int count){  ///return to orginal maxtrix form
    int i,k;
    for(i=1;i<count+1;i++){
        for(k=1;k<count+1;k++){
            if(tdA[i][k]=='X'){tdA[i][k]='0';}
        }
    }
    doOrginalOnes(tdA);
}

/****************************************************************************/

int solution(char** maze,int currentX,int currentY,int coo){///my solution for this problem

    if ( maze[currentX][currentY] == 'E' ){push('E',currentX,currentY);return 1;} ///Final place

    if ( maze[currentX][currentY] != 'S' && maze[currentX][currentY] != '0' ){///if it is not  Start point and free space
        if(maze[currentX][currentY]>='a' && maze[currentX][currentY]<='z'){///if it is key
            doOrginal(maze,coo);
            goto jump; ///this my escape way :)
        }
        else{
            if(!isKeyinStack((char) tolower(maze[currentX][currentY]))){///checking have you a key
                return 0;
            }
        }
    }
    jump:

    push(maze[currentX][currentY],currentX,currentY);
    maze[currentX][currentY] = 'X'; ///do not going same path

    if ( solution(maze,currentX+1,currentY,coo) == 1 ){return 1;}
    if ( solution(maze,currentX,currentY+1,coo) == 1 ){return 1;}
    if ( solution(maze,currentX-1,currentY,coo) == 1 ){return 1;}
    if ( solution(maze,currentX,currentY-1,coo) == 1 ){return 1;}


    char temp;
    temp=maze[currentX][currentY];

    maze[currentX][currentY] = '1';///for dead end
    pushtwo('1',currentX,currentY);
    if((temp>='a' && temp <='z') || (temp>='A' && temp <='Z')){maze[currentX][currentY]=temp;}
    pop();

    return 0;
}

/***************************************************************************/
int main(int argc, char *argv[]) {
    FILE *inputFile;
    FILE *outputFile;
    outputFile=fopen(argv[2],"w");

    char tp,tempp[30];///maximum 30x30 matrix
    char *temp;
    char **met;

    int  i,k;
    int x = 1, y = 1,count=0;
    int startX=1,startY =0;

    inputFile=fopen(argv[1],"r");

    temp=tempp;
    while(1){ ///I don't know nXn matrix. count is "n"
        tp=(char) fgetc(inputFile);
        if(tp=='\n'){break;}
        else{
            *(temp+count)=tp;
            count++;
            if(tp=='S'){startY =count;}
        }
    }

    met = malloc((count+2)*sizeof*met); ///the famous maze :)
    for(i=0;i<count+2;i++){
        met[i]=malloc((count+2)* sizeof(met[i]));
    }
    for(i=0;i<count+2;i++){///put walls around the maze
        if(i==0 || i==count+1){
            for(k = 0;k<count+2;k++){
                met[i][k]= '1';
            }
        }
        else{
            met[i][0]=met[i][count+1]= '1';
        }
    }

    for(i=0;i<count;i++){
        met[x][i+1]=*(temp+i);
    }
    x++;
    while(1){ ///file reading
        tp=(char) fgetc(inputFile);
        if(tp!='\n'){
            met[x][y]=tp;
            y++;
        }
        else{
            x++;y=1;
        }
        if(feof(inputFile)){ break;}
    }


    met[count][count+1]='1';
    met[count+1][1]='1';

    if(solution(met,startX,startY,count)){
        printPath(outputFile); ///print finded path
    } else{
        printf("I cannot find path to go out from the maze :(");
    }

    fclose(inputFile);
    fclose(outputFile);
    return 0;
}