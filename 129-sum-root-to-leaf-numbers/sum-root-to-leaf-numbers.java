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
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        return sum(root, new StringBuilder("0"));
    }
    
    public int sum(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        
        if (root.left == null && root.right != null){
            return sum(root.right, new StringBuilder(sb));
        }
        
        if (root.right == null && root.left != null){
            return sum(root.left, new StringBuilder(sb));
        }
        
        if (root.left != null && root.right != null){
            return sum(root.left, new StringBuilder(sb)) + sum(root.right, new StringBuilder(sb));
        }
        
        return Integer.parseInt(sb.toString());
    }
}