package p88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] copy = Arrays.copyOf(nums1, nums1.length);
        int a = 0, b = 0, i = 0;
        while (m > 0 || n > 0) {
            if(m > 0 && n > 0){
                if(copy[a] > nums2[b]) {
                    nums1[i++] = nums2[b++];
                    n--;
                } else {
                    nums1[i++] = copy[a++];
                    m--;
                }
            } else if(m > 0){
                nums1[i++] = copy[a++];
                m--;
            } else {
                nums1[i++] = nums2[b++];
                n--;
            }
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int pos1 = m - 1, pos2 = n - 1;
        while (pos1 >= 0 && pos2 >= 0){
            if(nums1[pos1] > nums2[pos2]){
                nums1[index--] = nums1[pos1--];
            } else {
                nums1[index--] = nums2[pos2--];
            }
        }
        if(pos2 >= 0){
            System.arraycopy(nums2, 0, nums1, 0, pos2 +1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,3,0,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        solution.merge2(nums1, m, nums2, n);
        System.out.println();
    }
}
