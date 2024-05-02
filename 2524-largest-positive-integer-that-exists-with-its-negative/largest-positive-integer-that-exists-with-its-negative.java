class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        
        int max = -1;
        while(left < right){
            if (nums[left] == -nums[right]){
                return Math.abs(nums[left]);
            }
            
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                left++;
            }
            else {
                right--;
            }
        }
        
        return max;
    }
}