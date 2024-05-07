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
    public ListNode removeNodes(ListNode head) {
        ListNode revHead = reverse(head);
        
        int max = -1;
        ListNode prev = null;
        ListNode current = revHead;
        
        while(current != null){
            max = Math.max(max, current.val);
            
            if (current.val >= max){
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            else {
                current = current.next;
            }
        }
        
        return prev;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}