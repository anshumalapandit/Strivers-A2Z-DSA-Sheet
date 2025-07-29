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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd=new ListNode(-1);
        ListNode dummyEven=new ListNode(-1);
        ListNode d1=dummyOdd;
        ListNode d2=dummyEven;
        int idx=1;
        ListNode temp=head;
        while(temp!=null){
            // if it is odd node then add it to oddDummy list
            if(idx%2!=0){
                // means it is odd
                d1.next=temp;
                d1=d1.next;
                idx++;
            }else{
                // else it will be even
                d2.next=temp;
                d2=d2.next;
                idx++;
            }
            if(temp.next!=null){
                temp=temp.next;
            }else{
                // important step here is breaking stop point of loop
                break;
            }
        }
        // linking part
        d1.next=dummyEven.next;
        d2.next=null;
        return dummyOdd.next;
    }
}
