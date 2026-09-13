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
       public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

         return helper(lists, 0, lists.length - 1);
        }

    // Merge lists from index left to right
    private ListNode helper(ListNode[] lists, int left, int right) {

        // Base case: only one list
        if (left == right)
            return lists[left];

        int mid = (left + right) / 2;

        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid + 1, right);

        return merge(l1, l2);
    }

    //merge 
    private ListNode merge(ListNode a , ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val <= b.val){
                curr.next = a;
                a = a.next;
            }else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if( a!= null){
            curr.next = a;
        }else{
            curr.next = b;
        }
        return dummy.next;
    }

}