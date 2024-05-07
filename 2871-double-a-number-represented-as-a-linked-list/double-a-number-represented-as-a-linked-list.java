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
        ListNode reversedHead = reverse(head);
        ListNode doubleHead = doubleNumber(reversedHead);
        
        return reverse(doubleHead);
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    ListNode doubleNumber(ListNode head){
        ListNode current = head;
        ListNode tail = current;
        
        int carry = 0;
        while(current != null){
            int doubleWithCarry = current.val * 2 + carry;
            current.val = doubleWithCarry % 10;
            carry = doubleWithCarry / 10;
            
            if (current.next == null){
                tail = current;
            }
            
            current = current.next;
        }
        
        if (carry > 0){
            tail.next = new ListNode(carry, null);
        }
        
        return head;
    }
}