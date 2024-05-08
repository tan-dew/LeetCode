class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int num: score){
            maxHeap.add(num);
        }
        
        Map<Integer, Integer> placements = new HashMap<>();
        
        for(int i = 0; i < score.length; i++){
            placements.put(score[i], i);
        }
        
        String[] result = new String[score.length];
        
        int place = 1;
        while(!maxHeap.isEmpty()){
            int curr = maxHeap.remove();
            int index = placements.get(curr);
            
            if (place == 1){
                result[index] = "Gold Medal";
            }
            else if (place == 2){
                result[index] = "Silver Medal";
            }
            else if (place == 3){
                result[index] = "Bronze Medal";
            }
            else {
                result[index] = String.valueOf(place);
            }
            
            place++;
        }
        
        return result;
    }
}