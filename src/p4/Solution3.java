package p4;

public class Solution3 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1==null?0:nums1.length;
        int n = nums2==null?0:nums2.length;
        int len=m+n;
        if(len%2==0)
            return (findKthNum(nums1,nums2,0,0,len/2) + findKthNum(nums1,nums2,0,0,len/2 + 1)) / 2.0;
        else
            return findKthNum(nums1,nums2,0,0,len/2+1);
    }

    public static int findKthNum(int[] nums1,int[] nums2,int i,int j,int k){
        int m=nums1.length;
        int n=nums2.length;
        if(i>=m) //nums1 пустой
            return nums2[j+k-1];
        if(j>=n) //nums2 пустой
            return nums1[i+k-1];
        if(k==1)
            return Math.min(nums1[i],nums2[j]);

        int index=k/2-1;
        int nums1Index=Math.min(m-1,i+index);
        int nums2Index=Math.min(n-1,j+index);
        if(nums1[nums1Index]<nums2[nums2Index])
            return findKthNum(nums1,nums2,nums1Index+1,j,k-(nums1Index-i+1));
        else
            return findKthNum(nums1,nums2,i,nums2Index+1,k-(nums2Index-j+1));
    }

    public static void main(String[] args) {

//        int[] a = {3};
//        int[] a = {1,2,3,4};
//        int[] b = {5,6,7,8,9,10,11,12,13};
//        int[] a = {3, 5, 10, 11, 17};
//        int[] b = {9, 13, 20, 21, 23, 27, 29, 32};
//        int[] b = {9, 13, 20, 21, 23, 27};
//        int[] b = {23,27};
//        int [] a = {2,3,5,8};
//        int [] b = {10,12,14,16,18,20};

        int[] a = {1,2,6,8,10,11};
        int[] b = {3,4,5,7,9};
        System.out.println(findMedianSortedArrays(a, b));
//        System.out.println(findMedianSortedArrays(a, null));

    }
}
