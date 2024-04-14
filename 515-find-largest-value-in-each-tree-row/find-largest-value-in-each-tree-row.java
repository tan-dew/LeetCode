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
        
        Queue<Pair> queue = new LinkedList<>();
        List<Integer> max = new ArrayList<>();

        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()){
            Pair popped = queue.remove();
            
            if (max.size() == popped.level){
                max.add(popped.node.val);
            }
            else {
                max.set(popped.level, Math.max(popped.node.val, max.get(popped.level)));
            }
            
            if (popped.node.left != null){
                queue.add(new Pair(popped.node.left, popped.level + 1));
            }
            
            if (popped.node.right != null){
                queue.add(new Pair(popped.node.right, popped.level + 1));
            }
        }
        
        return max;
    }
}

class Pair {
    TreeNode node;
    int level;
    
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}