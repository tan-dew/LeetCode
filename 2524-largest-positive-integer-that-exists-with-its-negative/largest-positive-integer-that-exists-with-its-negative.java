class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums){
            set.add(num);
        }
        
        int max = -1;
        for(int num: nums){
            if (set.contains(num * -1)){
                max = Math.max(Math.abs(num), max);
            }
        }
        
        return max;
    }
}