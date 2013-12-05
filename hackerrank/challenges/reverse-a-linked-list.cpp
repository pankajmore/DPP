#include <iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;
struct Node
{
	int data;
	Node *next;
};/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element
  Node is defined as
  struct Node
  {
     int data;
     struct Node *next;
  }
*/
Node* Reverse(Node *head)
{
    if (head -> next == NULL) return head;
    Node * curr = head;
    Node * prev = NULL;
    Node * q;
    while(curr != NULL) {
        q = curr -> next;
        curr -> next = prev;
        prev = curr;
        curr = q;
    }
    return prev;
}Node* Insert(Node *head,int x)
{
   Node *temp = new Node();
   temp->data = x;
   temp->next = NULL;
   if(head == NULL) return temp;
   Node *temp1 = head;
   while(temp1->next != NULL)
	   temp1 = temp1->next;
   temp1->next = temp;
   return head;
}

void Print(Node* head)
{
	bool ok = true;
	while(head != NULL)
	{
		if(!ok) cout<<" ";
		else ok = false;
		cout<<head->data;
		head=head->next;
	}
}
int main()
{
	int t;
	cin>>t;
	while(t-- >0){
		Node *head = NULL;
		int x;cin>>x;
		while(x--)
		{
		  int n; cin>>n;
		  head = Insert(head,n);
		}
		head = Reverse(head);
	   Print(head);
	   cout<<"\n";

	}

}
