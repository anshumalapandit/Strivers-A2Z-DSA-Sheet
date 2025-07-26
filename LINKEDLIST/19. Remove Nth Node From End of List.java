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
        if(head==null){
            return 0;
        }
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    public ListNode delete(ListNode head,int size,int k){
        int req=size-k; // 
        ListNode temp=head;
        if(req==0){
            // we have to delete head itself
         head=head.next;
         return head;
        }
        int i=1;
        while(i<req){
           temp=temp.next;
           i++;
        }
        // now i am just before what i want to delete
        if(temp.next.next!=null){
             temp.next=temp.next.next;
        }else{
            temp.next=null;
        }
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sizeLL=findSize(head);
        return delete(head,sizeLL,n);
    }
}
// optimised: /**
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    // if i have single node
    if(head.next==null){
        head=null;
        return head;
    }
     ListNode slow=head;
     ListNode fast=head;
     // lets move fast pointer to n step
     while(n!=0){
        fast=fast.next;
        n--;
     }
     //when n == length of list (i.e., you need to delete the head)
     if(fast==null){
        // u need to delete head itself 
        head=head.next;
        return head;
     }
     while(fast.next!=null){
        slow=slow.next;
        fast=fast.next;
     }
     // now u reached just before ur deleting node go delete it
     if(slow.next.next!=null){
        slow.next=slow.next.next;
     }else{
        slow.next=null;
     }
     return head;
    }
}
