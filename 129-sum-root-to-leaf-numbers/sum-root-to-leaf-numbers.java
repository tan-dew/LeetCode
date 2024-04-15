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
        
        return sum(root, "0");
    }
    
    public int sum(TreeNode root, String s){
        s += root.val;
        
        if (root.left == null && root.right != null){
            return sum(root.right, s);
        }
        
        if (root.right == null && root.left != null){
            return sum(root.left, s);
        }
        
        if (root.left != null && root.right != null){
            return sum(root.left, s) + sum(root.right, s);
        }
        
        return Integer.parseInt(s);
    }
}