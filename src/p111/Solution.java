package p111;

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
//    https://zxi.mytechroad.com/blog/tree/leetcode-111-minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        int l = (root.left!= null) ? minDepth(root.left): Integer.MAX_VALUE;
        int r = (root.right!= null) ? minDepth(root.right): Integer.MAX_VALUE;

        return Integer.min(l, r) + 1;
    }
}
