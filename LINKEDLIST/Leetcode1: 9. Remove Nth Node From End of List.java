/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int findSize(ListNode head){
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int idx=1;
        int size=findSize(head);
        int reached=size-n;
        if(reached==0){
            head=head.next;
            return head;
        }
        while(idx<reached){
            temp=temp.next;
            idx++;
        }
        if(temp.next==null){
            temp=null;
            return head;
        }
        temp.next=temp.next.next;
        return head;
    }
}
