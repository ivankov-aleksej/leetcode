package p108;

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
    public TreeNode sortedArrayToBST(int[] nums) {
       return addNode(nums, 0 , nums.length - 1);
    }

    private TreeNode addNode(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = addNode(nums, left, mid - 1);
        node.right = addNode(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0,1,2,3,4,5};
        TreeNode node1 = solution.sortedArrayToBST(nums);

        System.out.println();
    }
}