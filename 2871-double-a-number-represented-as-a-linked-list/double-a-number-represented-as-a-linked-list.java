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
    public ListNode doubleIt(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        
        ListNode current = dummyHead;
        
        while (current.next != null){
            current.val = current.val * 2 % 10;
            
            if (current.next.val >= 5){
                current.val = current.val + 1;
            }
                        
            current = current.next;
        }
        
        current.val = current.val * 2 % 10;
        
        return dummyHead.val > 0
            ? dummyHead
            : dummyHead.next;
    }
}