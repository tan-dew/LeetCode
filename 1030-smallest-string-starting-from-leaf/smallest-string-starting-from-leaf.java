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
    
    List<String> strs = new ArrayList<>();
    
    public String smallestFromLeaf(TreeNode root) {
        if (root == null){
            return "";
        }
        
        dfs(root, new StringBuilder());
        
        return strs.get(0);
    }
    
    public void dfs(TreeNode root, StringBuilder sb){
        
        sb.append((char) ('a' + root.val));
        
        if (root.left == null && root.right == null){
            strs.add(sb.reverse().toString());
            
            if (strs.size() == 2){
                Collections.sort(strs);
                strs.remove(1);
            }
        }
        
        if (root.left != null){
            dfs(root.left, new StringBuilder(sb));
        }
        
        if (root.right != null){
            dfs(root.right, new StringBuilder(sb));
        }
    }
}