/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(slow.next==null){
                return false;
            }
            slow=slow.next;
            if(fast.next!=null && fast.next.next!=null)
            fast=fast.next.next;
            else return false;
            if(slow==fast){
                return true;
            }
        }
       // return slow==fast; un rechable statement
    }
}
