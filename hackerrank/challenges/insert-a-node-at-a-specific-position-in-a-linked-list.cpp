#include <iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct Node
{
	int data;
	Node *next;
};/*
  Insert Node at a given position in a linked list
  The linked list will not be empty and position will always be valid
  First element in the linked list is at position 0
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* InsertNth(Node *head, int data, int position)
{
    Node * n = (Node *)malloc(sizeof(Node *));
    n -> data = data;
    n -> next = NULL;
    Node * p = head;
    if (position == 0) {
        n -> next = head;
        return n;
    }
    while(--position){
        p = p -> next;
    }
    Node * q = p -> next;
    p -> next = n;
    n -> next = q;
    return head;
}void Print(Node* head)
{
	while(head != NULL)
	{
		cout<<head->data;
		head=head->next;
	}
}

int main()
{
	int t;
	cin>>t;
	    Node *head = NULL;
		 head = new Node();
		 head->data = 2;
		 head->next = NULL;
	while(t-- >0){
		int x,n; cin>>x>>n;
		 head = InsertNth(head,x,n);
	}
	 Print(head);
	   cout<<"\n";

}
