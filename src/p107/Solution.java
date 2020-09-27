package p107;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();
        getLevelOrderBottom(root, 0, array);
        Collections.reverse(array);
        return array;
    }

    private void getLevelOrderBottom(TreeNode root, int depth, List<List<Integer>> array) {
        if(root != null) {
            if(array.size() == depth){
                array.add(new ArrayList<>());
            }
            array.get(depth++).add(root.val);
            getLevelOrderBottom(root.left, depth, array);
            getLevelOrderBottom(root.right, depth, array);
        }
    }
}
