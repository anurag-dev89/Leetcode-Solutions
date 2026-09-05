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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //create dummy befor head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //created 2 pointes at dummy 
        ListNode fast = dummy;
        ListNode slow = dummy;

        //move fast to the n+1 th position
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        //move both pointer till null
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        //remove Nth node
        slow.next = slow.next.next;

        //retuen head of list
        return dummy.next;
    }
}