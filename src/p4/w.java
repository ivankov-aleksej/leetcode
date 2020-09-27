package p4;

public class w {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        if (len % 2 == 0) {
            return (findKthNum(nums1, nums2, 0, 0, len / 2) + findKthNum(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKthNum(nums1, nums2, 0, 0, len / 2 + 1);
        }
    }

    private static int findKthNum(int[] nums1, int[] nums2, int i, int j, int k) {
        int m = nums1.length;
        int n = nums2.length;

        if (i >= m) {
            return nums2[j + k - 1];
        }
        if (j >= n) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int index = k / 2 - 1;
        int indexNums1 = Math.min(m - 1, i + index);
        int indexNums2 = Math.min(n - 1, j + index);
        if (nums1[indexNums1] < nums2[indexNums2]) {
            return findKthNum(nums1, nums2, indexNums1 + 1, j, k - (indexNums1 - i + 1));
        } else {
            return findKthNum(nums1, nums2, i, indexNums2 + 1, k - (indexNums2 - j + 1));
        }
    }

    public static void main(String[] args) {
//        int[] a = {3};
        int[] a = {3, 5, 10, 11, 17};
        int[] b = {9, 13, 20, 21, 23, 27, 29, 32};
//        int[] b = {9, 13, 20, 21, 23, 27};
//        int[] b = {23,27};
//        int [] a = {2,3,5,8};
//        int [] b = {10,12,14,16,18,20};

        System.out.println(findMedianSortedArrays(a, b));
//        System.out.println(findMedianSortedArrays(a, null));

    }
}
