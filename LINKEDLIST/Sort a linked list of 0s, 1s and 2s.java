/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        // dummy nodes
        Node zero=new Node(-1);
        Node one=new Node(-1);
        Node two=new Node(-1);
        // pointer for each
        Node p0=zero;
        Node p1=one;
        Node p2=two;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                p0.next=temp;
                p0=p0.next;
            }else if(temp.data==1){
                p1.next=temp;
                p1=p1.next;
            }else{
                p2.next=temp;
                p2=p2.next;
            }
            temp=temp.next;
        }
        p0.next = one.next != null ? one.next : two.next;
        p1.next = two.next;
        p2.next = null;
         return zero.next;   // new head of the final list

    }
}
