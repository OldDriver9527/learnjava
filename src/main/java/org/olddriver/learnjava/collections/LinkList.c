#include <stdio.h>
#include <stdlib.h>

typedef struct node_st
{
    char *data;
    struct node_st *next;
}node;

/*
链表结构体中嵌套节点结构体
*/
typedef struct linkList_st
{
    int size;
    struct node_st *head;
}linkList;


int main(int argc,char *argv[]){
    exit(0);
}