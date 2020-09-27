package p104;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return searchDepth(root);
    }

    private int searchDepth(TreeNode root){
        if(root.left != null && root.right != null){
            return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        if(root.left != null) {
            return maxDepth(root.left) + 1;
        }
        if(root.right != null) {
            return maxDepth(root.right) + 1;
        }
        return 1;
    }
}
