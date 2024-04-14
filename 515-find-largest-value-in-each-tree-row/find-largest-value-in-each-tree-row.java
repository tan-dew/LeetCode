/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        dfs(root, 0, max);
        
        return max;
    }
    
    public void dfs(TreeNode node, int level, List<Integer> max){
        if (node == null){
            return;
        }
        
        if(max.size() == level){
            max.add(node.val);
        }
        else{
            max.set(level, Math.max(max.get(level), node.val));
        }
        
        dfs(node.left, level + 1, max);
        dfs(node.right, level + 1, max);
    }
}
