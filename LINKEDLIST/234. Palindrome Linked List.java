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
    public ListNode reverse(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode Next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Next;
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // lets find mid Node
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
        }
        // u will found that slow is ur at mid point
        // lets divide the node into 2 parts
        ListNode head1=slow.next;
        slow.next=null; 
        ListNode head2=reverse(head1);
        // imp: Reversing second half is safer because:
// You don’t touch the start of the list.
// You don’t need extra pointer for tracking "prev of slow".
// It avoids edge cases in odd/even length lists.
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                return false;
            }else{
            head=head.next;
            head2=head2.next;
            }
        }
        return true;
    }
}
