class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < num.length(); i++){
            int digit = num.charAt(i) - '0';
            
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > digit){
                deque.removeLast();
                k--;
            }
            
            deque.addLast(digit);
        }
        
        while(k > 0){
            deque.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!deque.isEmpty() && deque.peekFirst() == 0){
            deque.removeFirst();
        }
        
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst());
        }
        
        String result = sb.length() == 0
            ? "0"
            : sb.toString();
        
        return result;
    }
}