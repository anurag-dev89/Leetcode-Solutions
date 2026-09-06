/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        //step 1 = Insert Copied node after evry original

        while(curr != null){
        Node copy = new Node(curr.val);
        copy.next = curr.next;
        curr.next = copy;
        curr = copy.next;
        }

        //step2 = copy random Pointers

        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //step3 = seprate original list and copied list

        curr = head;
        Node newHead = head.next;

        while(curr != null){
            Node newCurr = curr.next;
            curr.next = newCurr.next;
            if(newCurr.next != null){
                newCurr.next =newCurr.next.next;
            }
            curr=curr.next;
        }
        return newHead;     
    }
}