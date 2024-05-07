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
        Stack<ListNode> stack = new Stack<>();
        
        ListNode curr = head;
        
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        
        int carry = 0;
        while(!stack.isEmpty()){
            ListNode popped = stack.pop();
            int doubledWithCarry = (popped.val * 2) + carry;
            popped.val = doubledWithCarry % 10;
            carry = doubledWithCarry / 10;
        }
        
        if (carry > 0){
            head = new ListNode(carry, head);
        }
        
        return head;
    }
}