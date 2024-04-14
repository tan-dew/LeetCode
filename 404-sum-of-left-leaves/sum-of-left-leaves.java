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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        return dfs(root, root.left) + dfs(root, root.right);
    }
    
    public int dfs(TreeNode parent, TreeNode child){
        if(child == null){
            return 0;
        }
        
        if(child.left == null && child.right == null){
            return child == parent.left ? child.val : 0;
        }
        
        return dfs(child, child.left) + dfs(child, child.right);
    }
}