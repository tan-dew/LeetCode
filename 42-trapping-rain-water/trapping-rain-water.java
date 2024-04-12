class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        
        int water = 0;
        
        while(left <= right){
            if (leftMax <= rightMax){
                water += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
            else {
                water += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        
        return water;
    }
}