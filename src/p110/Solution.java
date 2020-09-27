package p110;
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

    private boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        findHeight(root);
        return balanced;
    }

    private int findHeight(TreeNode root){
        if(root ==  null || !this.balanced){
            return -1;
        }
        int l = findHeight(root.left);
        int r = findHeight(root.right);
        if(Math.abs(l - r) > 1){
            this.balanced = false;
            return -1;
        }
        return  Math.abs(l - r) + 1;
    }
}
