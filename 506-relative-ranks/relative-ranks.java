class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] copyScore = Arrays.copyOf(score, score.length);
        
        Arrays.sort(copyScore);
        reverse(copyScore);
        
        Map<Integer, String> placements = new HashMap<>();
        
        for (int i = 0; i < copyScore.length; i++){
            if (i == 0){
                placements.put(copyScore[i], "Gold Medal");
            }
            else if (i == 1){
                placements.put(copyScore[i], "Silver Medal");
            }
            else if (i == 2){
                placements.put(copyScore[i], "Bronze Medal");
            }
            else {
                placements.put(copyScore[i], String.valueOf(i + 1));
            }
        }
        
        String[] result = new String[score.length];
        
        for (int i = 0; i < score.length; i++){
            result[i] = placements.get(score[i]);
        }
        
        return result;
    }
    
    void reverse(int[] ara){
        int halfLen = ara.length / 2;
        
        for (int i = 0; i < halfLen; i++){
            int temp = ara[i];
            ara[i] = ara[ara.length - 1 - i];
            ara[ara.length - 1 - i] = temp;
        }
    }
}