package p4;

public class Solution1 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1==null ? 0 : nums1.length;
        int n = nums2==null ? 0 : nums2.length;
        if(m == 0) {
            return findMedianSortedArrays(nums2);
        }
        if(n == 0) {
            return findMedianSortedArrays(nums1);
        }

        int [] nums = new int[m + n];

        int count = 0;
        for (int i = 0, j = 0; i < m || j < n;) {
            if(i == m){
                nums[count++] = nums2[j++];
            } else if (j == n) {
                nums[count++] = nums1[i++];
            } else {
                if (nums1[i] < nums2[j]) {
                    nums[count++] = nums1[i++];
                } else {
                    nums[count++] = nums2[j++];
                }
            }
        }

        return findMedianSortedArrays(nums);
    }

    public static double findMedianSortedArrays(int[] nums) {
        int len = nums.length;
        if(len%2 == 0){
            return (nums[len/2 -1] + nums[len/2]) / 2.0;
        } else {
            return nums[len/2];
        }
    }

    public static void main(String[] args) {

        int [] a = {3,5,10,11,17};
        int [] b = {9,13,20,21,23,27};
//        int [] a = {2,3,5,8};
//        int [] b = {10,12,14,16,18,20};

        System.out.println(findMedianSortedArrays(a, b));

    }
}
