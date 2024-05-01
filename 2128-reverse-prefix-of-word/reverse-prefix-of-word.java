class Solution {
    public String reversePrefix(String word, char ch) {
        int chIndex = word.indexOf(ch);
        
        if (chIndex == -1){
            return word;
        }
        
        String firstPart = word.substring(0, chIndex + 1);
        String lastPart = word.substring(chIndex + 1, word.length());
        
        return new StringBuilder(firstPart).reverse().toString() + lastPart;
    }
}