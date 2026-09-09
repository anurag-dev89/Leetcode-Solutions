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

        // Dummy node helps us build the answer list easily
        ListNode dummy = new ListNode(0);

        // Tail always points to the last node of the answer list
        ListNode tail = dummy;

        // Stores carry from previous addition
        int carry = 0;

        // Traverse until both linked lists are finished
        while (l1 != null || l2 != null) {

            // Start sum with previous carry
            int sum = 0 + carry;

            // Add current digit from first list
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;      // Move to next node
            }

            // Add current digit from second list
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;      // Move to next node
            }

            // Store the one's place in the answer
            int digit = sum % 10;

            // Store the ten's place as carry
            carry = sum / 10;

            // Create a new node with the digit
            tail.next = new ListNode(digit);

            // Move tail to the newly created node
            tail = tail.next;

            // If carry is left
            if (carry != 0)
                tail.next = new ListNode(carry);
        }

        // Return the actual answer (skip dummy node)
        return dummy.next;
    }
}