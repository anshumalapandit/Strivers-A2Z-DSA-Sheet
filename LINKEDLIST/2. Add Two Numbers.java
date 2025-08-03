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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  p1=l1;
        ListNode p2=l2;
        ListNode dummy=new ListNode(-1);
        ListNode d=dummy;
        int carry=0;
        while(p1!=null || p2!=null){
            int val1=p1==null?0:p1.val;
            int val2=p2==null?0:p2.val;
            int newValue=val1+val2+carry;
            ListNode newNode=new ListNode(newValue%10);
            carry=newValue/10;
            d.next=newNode;
            d=d.next;
            if(p1!=null)
            p1=p1.next;
            if(p2!=null)
            p2=p2.next;
        }
        if(carry>0){
            d.next=new ListNode(carry);
        }
        return dummy.next;
    }
}
