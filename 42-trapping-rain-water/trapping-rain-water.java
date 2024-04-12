class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        leftMax[0] = 0;
        
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        
        int[] rightMax = new int[height.length];
        rightMax[rightMax.length - 1] = 0;
        
        for(int i = rightMax.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        
        int trapped = 0;
        
        for (int i = 0; i < height.length; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            trapped += Math.max(water, 0);
        }
        
        return trapped;
    }
}