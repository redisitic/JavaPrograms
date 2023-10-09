#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node{
    int data;
    struct node *next;
};
struct node *head = NULL;
struct node *current = NULL;

void printList(){
    struct node *p = head;
    printf("\n [");
    while(p != NULL){
        printf(" %d ", p -> data);
        p = p -> next;
    }
    printf("]");
}

void addAtStart(int data){
    struct node *lkl = (struct node*) malloc(sizeof(struct node));
    lkl -> data = data;
    lkl -> next = head;
    head = lkl;

}

void addAtEnd(int data){
    struct node *lkl = (struct node*) malloc(sizeof(struct node));
    lkl -> data = data;
    struct node *linkedlist = head;
    while(linkedlist -> next != NULL){
        linkedlist = linkedlist -> next;
    }
    linkedlist -> next = lkl;
    lkl -> next = NULL;
}

void addAfter(struct node *list,int data){
    struct node *lkl = (struct node*) malloc(sizeof(struct node));
    lkl -> data = data;
    lkl -> next = list -> next;
    list -> next = lkl;
}

void removeAtStart(){
    head = head -> next;
}

void removeAtEnd(){
    struct node *linkedlist = head;
    while(linkedlist -> next -> next != NULL){
        linkedlist = linkedlist -> next;
    }
    linkedlist -> next = NULL;
}

void removeNode(int key){
    struct node *temp = head, *prev;
    if(temp != NULL && temp -> data != key){
        prev = temp;
        temp = temp -> next;
    }
    if(temp == NULL) return;
    prev -> next = temp -> next;
}

int main()
{
    addAtStart(20);
    addAtStart(15);
    addAtEnd(12);
    addAfter(head, 23);
    addAfter(head -> next -> next, 67);
    removeAtStart();
    removeAtEnd();
    removeNode(20);
    printList();
    return 0;
}
