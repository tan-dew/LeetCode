class Solution {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        
        boolean removed = false;
        for(int i = 0; i < number.length() - 1; i++){
            char ch = number.charAt(i);
            
            if (!removed && ch == digit && number.charAt(i + 1) > digit){
                removed = true;
            }
            else{
                sb.append(ch);
            }
        }
        
        sb.append(number.charAt(number.length() - 1));
        
        if (!removed){
            int lastIndexOfDigit = number.lastIndexOf(digit);
            
            StringBuilder sb2 = new StringBuilder();
            
            for(int i = 0; i < number.length(); i++){
                char ch = number.charAt(i);
                
                if (i != lastIndexOfDigit){
                    sb2.append(ch);
                }
            }
            
            return sb2.toString();
        }
        else {
            return sb.toString();
        }
    }
}