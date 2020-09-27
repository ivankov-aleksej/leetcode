package p4;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = getMerge(nums1, nums2);
        if(array.length == 1) {
            return array[0];
        } else {
            if(array.length % 2 == 0) {
                int index = array.length / 2;
                return (array[index] + array[--index]) / 2.0;
            } else {
                return array[array.length / 2];
            }
        }
    }

    private static int[] getMerge(int[] nums1, int[] nums2){
        if (nums1.length > 0 && nums2.length > 0) {
            int[] numsSum = new int[nums1.length + nums2.length];
            int nums1Index = 0;
            int nums2Index = 0;
            int numsSumIndex = 0;
            while (numsSumIndex < numsSum.length) {
                numsSum[numsSumIndex] = nums1[nums1Index] < nums2[nums2Index] ? nums1[nums1Index++] : nums2[nums2Index++];
                if (nums1Index == nums1.length) {
                    System.arraycopy(nums2, nums2Index, numsSum, ++numsSumIndex, nums2.length - nums2Index);
                    break;
                }
                if (nums2Index == nums2.length) {
                    System.arraycopy(nums1, nums1Index, numsSum, ++numsSumIndex, nums1.length - nums1Index);
                    break;
                }
                numsSumIndex++;
            }
            return numsSum;
        } else {
            if (nums1.length == 0) {
                return nums2;
            } else {
                return nums1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums2 = new int[0];
        int[] nums1 = {1};

        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
