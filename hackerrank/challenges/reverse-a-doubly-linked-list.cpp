#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;
struct Node
{
	int data;
	Node* next;
	Node* prev;
};/*
   Reverse a doubly linked list, input list may also be empty
   Node is defined as
   struct Node
   {
     int data;
     Node *next;
     Node *prev
   }
*/
Node* Reverse(Node* head)
{
    if(head==NULL) return NULL;
    Node* p = head;
    Node* q = p->next;
    while(p->next != NULL){
        q = p->next;
        p->next = p->prev;
        p->prev = q;
        p = p->prev;
    }
    p->next = p->prev;
    p->prev = NULL;
    return p;
}Node* Insert(Node *head, int data)
{
	Node *temp = new Node();
	temp->data = data; temp->prev = NULL; temp->next = NULL;
	if(head == NULL) return temp;
	head->prev = temp;
	temp->next = head;
	return temp;
}
void Print(Node *head) {
	if(head == NULL) return;
	while(head->next != NULL){ cout<<head->data<<" "; head = head->next;}
	cout<<head->data<<" ";
	while(head->prev != NULL) { cout<<head->data<<" "; head = head->prev; }
	cout<<head->data<<"\n";
}
int main()
{
	int t; cin>>t;
	Node *head = NULL;
	while(t--) {
	   int n; cin>>n;
           head = NULL;
	   for(int i = 0;i<n;i++) {
		   int x; cin>>x;
		   head = Insert(head,x);
	   }
	   head = Reverse(head);
	   Print(head);
	}
}
