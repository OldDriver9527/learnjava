#include <stdio.h>
#include <stdlib.h>

#define MAX_SEQLIST_LENGTH 100

typedef struct
{
    char seqList[MAX_SEQLIST_LENGTH];
    int length;
}seqList;

/*
    创建顺序表
    使用malloc申请内存空间，返回结构体指针
*/
seqList * create(){
    seqList *pointer = malloc(sizeof(seqList));
    if(pointer == NULL){
        return NULL;
    }
    pointer->length = 0;
    return pointer;
}

/*
    销毁顺序表
*/
void destroyt(seqList *pointer){
    free(pointer);
}

/*
    清空顺序表
*/
void clear(seqList *pointer){
    pointer->length = 0;
}

/*
    获取顺序表长度
*/
int length(seqList *pointer){
    return pointer->length;
}

/*
    获取顺序表指定位置元素
*/
char get(seqList *pointer,int index){
    if(index < 0 || index > pointer->length){

    }
    return *(pointer->seqList+index);
}

/*
    移除顺序表中元素
*/
int remove(seqList *pointer){
    if(seqList->length == 0){
        return 0;
    }

    seqList->length--;
    return 1;
}

/*
    查找指定字符在表中位置
*/
int indexOf(seqList *pointer,char target){
    int i = 0;
    for( i = 0; i < pointer->length ;i++){
        if(pointer->seqList[i] == target){
            break;
        }
    }

    if(i < pointer->length){
        return i;
    }else{
        return -1;
    }
}

int main(int argc , char *argv[]){
    exit(0);
}