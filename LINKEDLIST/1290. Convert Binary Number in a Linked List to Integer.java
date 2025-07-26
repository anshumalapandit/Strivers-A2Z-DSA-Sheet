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
    public int getDecimalValue(ListNode head) {
     int Bin=0;
     ListNode temp=head;
     while(temp!=null){
        int data=temp.val;
        Bin=Bin*2+data;
        temp=temp.next;
     }
     return Bin;
    }
}
