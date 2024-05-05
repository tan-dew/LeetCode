/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode dummyHead = new ListNode(0, node);
        ListNode prev = dummyHead;
        ListNode curr = node;
        
        while(curr.next != null){
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
    }
}