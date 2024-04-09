class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        int[] seen = new int[nums.length];
        List<Integer> ans = new LinkedList<>();
        
        int s = 0;
        int k = 0;
        for(int num: nums){
            if (num > 0){
                seen[s] = num;
                s++;
                k = 0;
            }
            else{
                k++;
                
                if (k <= s){
                    ans.add(seen[s - k]);
                }
                else {
                    ans.add(num);
                }
            }
        }
        
        return ans;
    }
}