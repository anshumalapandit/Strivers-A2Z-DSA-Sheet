/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int findLength(Node slow,Node fast){
        int count=1;
        fast=fast.next;
        while(fast!=slow){
            count++;
            fast=fast.next;
        }
        return count;
    }
    public int countNodesinLoop(Node head) {
        // code here.
        // first i will try to find cycle
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                // yes cycle detcetd now find length
                return findLength(slow,fast);
            }
        }
        return 0;
    }
}
