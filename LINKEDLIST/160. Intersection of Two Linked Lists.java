/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int findSize(ListNode head){
        int size=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return size;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA=findSize(headA);
        int sizeB=findSize(headB);
        int size=Math.abs(sizeA-sizeB);
        ListNode temp1=headA;
        ListNode temp2=headB;
        if(sizeA>sizeB){
           while(size>0 && temp1!=null){
              temp1=temp1.next;
              size--;
           }
        }else{
             while(size>0 && temp2!=null){
              temp2=temp2.next;
              size--;
           }
        }
        if(temp1==temp2){
            return temp1;
        }
        // now move equally them
        while(temp1!=null && temp2!=null){
            if(temp1==temp2){
                // remember must check node bcoz intersecting node to ek hi hoga address bhi same hoga
                // values might be same of non intersecting node will leads to wrong result.
                // found intersecting point
                return temp1;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}
