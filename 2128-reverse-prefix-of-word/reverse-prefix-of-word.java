class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        
        int len = word.length();
        boolean isReversed = false;
        
        for (int i = 0; i < len; i++){
            char current = word.charAt(i);
            sb.append(current);
            
            if (!isReversed && current == ch){
                sb.reverse();
                isReversed = true;
            }
        }
        
        return sb.toString();
    }
}