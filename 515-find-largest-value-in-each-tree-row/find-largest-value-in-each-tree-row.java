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
        if (root == null){
            return new LinkedList<>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> max = new ArrayList<>();

        queue.add(root);
        
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            int currMax = Integer.MIN_VALUE;
            
            for (int i = 0; i < currentSize; i++){
                TreeNode node = queue.remove();
                currMax = Math.max(currMax, node.val);
                
                if (node.left != null){
                    queue.add(node.left);
                }
                
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            
            max.add(currMax);
        }
        
        return max;
    }
}
