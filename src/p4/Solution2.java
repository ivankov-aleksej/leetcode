package p4;

public class Solution2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;

        int i = 0, j = 0;
        int first = -1, second = -1;
        //Вам не нужно, чтобы сохранить все, можно сохранить только два номера
        for (int count = 0; count <= (m + n) / 2; count++) {
            first = second;
            if(i == m) {
                second = nums2[j++];
            } else if(j == n){
                second = nums1[i++];
            }else {
                if(nums1[i] < nums2[j]){
                    second = nums1[i++];
                } else {
                    second = nums2[j++];
                }
            }
        }

        if ((m + n) % 2 == 0) {
            return (first + second) / 2.0;
        } else {
            return second;
        }
    }

    public static void main(String[] args) {

        int[] a = {3, 5, 10, 11, 17};
        int[] b = {9, 13, 20, 21, 23, 27};
//        int [] a = {2,3,5,8};
//        int [] b = {10,12,14,16,18,20};

        System.out.println(findMedianSortedArrays(a, b));

    }
}
