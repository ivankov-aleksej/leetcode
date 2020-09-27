package p113;

import java.util.ArrayList;
import java.util.List;

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
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum , new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> list){
        if(root != null) {
            sum -= root.val;
            list.add(root.val);
            if(sum == 0 && root.left == null && root.right == null){
                result.add(new ArrayList<>(list));
            } else {
                helper(root.left, sum, list);
                helper(root.right, sum, list);
            }
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);

        head.left = new TreeNode(4);
        head.right = new TreeNode(8);

        head.left.left = new TreeNode(11);
        head.right.left = new TreeNode(13);
        head.right.right = new TreeNode(4);

        head.left.left.left = new TreeNode(7);
        head.left.left.right = new TreeNode(2);
        head.right.right.left = new TreeNode(5);
        head.right.right.right = new TreeNode(1);

        Solution solution = new Solution();
        solution.pathSum(head, 22);
        System.out.println();

    }
}