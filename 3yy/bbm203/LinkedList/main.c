#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"
#include "specialLL.h"


int main(){
    int i,j,k=0,flag;

     specialLL **bigList = (specialLL **)malloc(100*sizeof(specialLL *));
       int bLcount=0;
       char **ninerde=(char **)malloc(256*sizeof( char *));




       char *command = (char *)malloc(sizeof(char));
       printf("command enter please: \n" );
       gets(command);
       char *cmd;
       char *Tcmd;
       char *backupTcmd;
       char *token;
       token=strtok(command," ");


       while(token[1]!='q'){

           if(token[1]=='r'){

               token=strtok(NULL," ");

                cmd=string_copy(token);
               Tcmd=strtok(cmd," /");
               while(Tcmd!=NULL){
                   backupTcmd=string_copy(Tcmd);
                   Tcmd=strtok(NULL, " /");
               }
               flag=0;
               i=0;
               while(bLcount>i){
                   if(strcmp(ninerde[i],backupTcmd)==0){
                       flag=1;
                       break;
                   }
                   i++;
               }
               if(flag){
                   printf("You have already read this file\n" );
                   continue;
               }
               else{

                   ninerde[bLcount]=string_copy(backupTcmd);
               }


               FILE *inputFile;
               FILE *sorry;
               inputFile=fopen(token,"r");
               sorry=fopen("sorry.txt","w");
               char ch;

               while(!feof(inputFile)){
                   ch=fgetc(inputFile);
                   ch=tolower(ch);
                   if(isalnum(ch)){fputc(ch,sorry);}
                   else{
                       //for last character from files
                       if(ch=='\n'){fputs(" filtresizbomonti ", sorry);}
                       else{fputc(' ',sorry);}
                   }

               }
               i=0;
               fclose(sorry);
               sorry=fopen("sorry.txt","r");
                j=0;


                char *word=(char *)malloc(sizeof(char));
                char *aft=(char *)malloc(sizeof(char));

                while(!feof(sorry)){
                    if(i++==0){
                        fscanf(sorry,"%s", word);
                    }
                    fscanf(sorry,"%s", aft);
                    //printf("word %s  aft %s\n",word,aft);
                    SPaddNode(word, aft,&bigList[bLcount]);
                    word=string_copy(aft);

                }

               SPreverse(&bigList[bLcount]);
               bubbleSort(&bigList[bLcount]);
               SPreverse(&bigList[bLcount]);
               SPprint(&bigList[bLcount]);

               bLcount++;
               fclose(sorry);
               fclose(inputFile);


           }



           else if(token[1]=='a'){
               printf("\n\nAPPEND\n\n" );
               i=0;
               token=strtok(NULL," ");
               char *data = string_copy(token);
               while(data[i++]!='\0'){
                   data[i-1]=tolower(data[i-1]);
               }

               token=strtok(NULL," ");
               int counter=atoi(token);

               token=strtok(NULL," ");
               char *which=string_copy(token);

               i=0;
               flag=0;
               while(bLcount>i){
                   if(strcmp(ninerde[i],which)==0){
                       flag=1;
                       break;
                   }
                   i++;
               }
               if(!flag){
                   printf("You have not read %s file\n",which );
                   continue;
               }
               else{
                   SPappend(&bigList[i], data, counter);
               }
               SPprint(&bigList[i]);

           }



           else if(token[1]=='n'){
               printf("\n\nFIRSTSSSSSS\n\n" );

               token=strtok(NULL," ");
               char *which=string_copy(token);
               printf("%s\n",which);
               i=0;
               flag=0;
               while(bLcount>i){
                   if(strcmp(ninerde[i],which)==0){
                       flag=1;
                       break;
                   }
                   i++;
               }
               if(!flag){
                   printf("You have not read %s file\n",which );
                   continue;
               }
               else{
                   SPfirsts(&bigList[i]);
               }
               printf("\n\n" );

           }


           else if(token[1]=='d'){
               printf("\n\nDLETETEE\n\n" );

               token=strtok(NULL," ");
               char *data=string_copy(token);

               token=strtok(NULL," ");
               char *which=string_copy(token);

               i=0;
               flag=0;
               while(bLcount>i){
                   if(strcmp(ninerde[i],which)==0){
                       flag=1;
                       break;
                   }
                   i++;
               }
               if(!flag){
                   printf("You have not read %s file\n",which );
                   continue;
               }
               else{
                   SPdelete(data, &bigList[i]);
               }
               SPprint(&bigList[i]);
               printf("\n\n" );

           }


           else if(token[1]=='s'){
               printf("\n\nCOSUNUSSS\n\n" );

               token=strtok(NULL," ");
               char *which1=string_copy(token);

               token=strtok(NULL," ");
               char *which2=string_copy(token);


               flag=0;i=0;
               while(bLcount>i){
                   if(strcmp(ninerde[i],which1)==0){
                       flag=1;
                       break;
                   }
                   i++;
               }
               if(!flag){
                   printf("You have not read %s file\n",which1 );
                   continue;
               }
               else{
                    j=0;flag=0;
                    while(bLcount>j){
                        if(strcmp(ninerde[j],which2)==0){
                           flag=1;
                           break;
                        }
                        j++;
                    }
                    if(!flag){
                        printf("You have not read %s file\n",which2 );
                        continue;
                    }
                    else{
                        SPcosinusOnlyTwo(&bigList[i],&bigList[j]);
                    }
               }
               printf("\n\n" );
           }



           while(token!=NULL){token=strtok(NULL," ");}

           printf("\nAnother command enter please: \n" );
           gets(command);
           token=strtok(command," ");
       }



  return 0;
}
