package p101;

public class Test {
    private static int count = 0;
    public static boolean root (TreeNode root) {
        boolean a = isSymmetric(root, root);
        System.out.println(count);
        return a;
    }
    private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        count++;
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t2.left, t1.right);
    }
}
