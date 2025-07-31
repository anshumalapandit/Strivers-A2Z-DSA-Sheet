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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        int middle=(size/2);
        if(middle==0){
            head=head.next;
            return head;
        }
        // i will try to reach middle -1 till
        ListNode cur=head;
        while(middle-1!=0 && cur.next!=null){
         cur=cur.next;
         middle--;
        }
        if(cur.next==null){
            cur.next=null;
            return head;
        }
        cur.next=cur.next.next;
        return head;
    }
}
