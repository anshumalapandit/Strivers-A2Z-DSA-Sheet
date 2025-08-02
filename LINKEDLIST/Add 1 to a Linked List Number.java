/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
        Node cur=head;
        Node prev=null;
        while(cur!=null){
            Node Next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Next;
        }
        return prev; // u cant update head here bcoz when u back to main fxn it value will remain unchanged.
    }
    public Node addOne(Node head) {
        // code here.
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        int lastValue=temp.data;
        int sum=lastValue+1;
        if(sum<=9){
        temp.data=sum;
        return head;
        }else{
        // reverse original value;
        head=reverse(head);
         // carry needed
        int carry=1;
        Node cur=head;
        Node prev=null; // to track cur prev sometimes total count of no. inc while adding
        // now add 1 to it
        while(carry>0 && cur!=null){
            int sum2=cur.data+carry;
            int ld=sum2%10;
            cur.data=ld;
            carry=sum2/10;
            prev=cur; // imp step; very very imp
            cur=cur.next;
        }
        if(carry>0){
            Node newNode=new Node(carry);
            prev.next=newNode;
        }
        // now reverse the list again to regain answer
        head=reverse(head);
        //return head;
    }
     return head;
    }
}
