// User function Template for Java

class Solution {
    public Node insertAtBegining(Node head, int x) {
        // Code here
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
            return head;
        }
        Node oldHead=head;
        head=newNode;
        head.next=oldHead;
        return head;
    }
}
