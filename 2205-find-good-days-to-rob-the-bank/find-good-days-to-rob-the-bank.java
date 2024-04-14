class Solution {
    // tc: O(N)
    // sc: O(N)
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (time == 0){
            List<Integer> goodDays = new ArrayList<>();
            
            for (int i = 0; i < security.length; i++){
                goodDays.add(i);
            }
            
            return goodDays;
        }
        
        Set<Integer> nonIncSet = new HashSet<>();
        
        int nonIncreasingCount = 0;
        for (int i = 0; i < security.length - 1; i++){
            if(security[i] >= security[i + 1]){
                nonIncreasingCount++;
            }
            else {
                nonIncreasingCount = 0;
            }
            
            if(nonIncreasingCount >= time){
                nonIncSet.add(i + 1);
            }
        }
        
        Set<Integer> nonDecSet = new HashSet<>();
        
        int nonDecreasingCount = 0;
        for (int i = security.length - 1; i > 0; i--){
            if (security[i - 1] <= security[i]){
                nonDecreasingCount++;
            }
            else {
                nonDecreasingCount = 0;
            }
            
            if (nonDecreasingCount >= time){
                nonDecSet.add(i - 1);
            }
        }
        
        List<Integer> goodDays = new LinkedList<>();
        
        for (Integer day: nonIncSet){
            if (nonDecSet.contains(day)){
                goodDays.add(day);
            }
        }
        
        return goodDays;
    }
}