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
        Stack<ListNode> stack = new Stack<>();
        
        ListNode current = head;
        
        while (current != null){
            stack.push(current);
            current = current.next;
        }
        
        int max = -1;
        ListNode prev = null;
        
        while(!stack.isEmpty()){
            ListNode popped = stack.pop();
            
            if (popped.val >= max){
                popped.next = prev;
                prev = popped;
            }
            
            max = Math.max(popped.val, max);
        }
        
        return prev;
    }
}