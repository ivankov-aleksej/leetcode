package p53;

//    https://snowan.gitbook.io/study-notes/leetcode/english-solution/53.maximum-sum-subarray-en#complexity-analysis
public class Solution {
    public int maxSubArray(int[] nums) {
        //Dynamic Programming
        // Kadane's algorithm  Time Complexity: O(n)  Space Complexity:  O(1)
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int sumMax = nums[0];

        for(int i = 1; i < nums.length; i++) {
            sum = Integer.max(sum + nums[i], nums[i]);
            sumMax = Integer.max(sumMax, sum);
        }
        return sumMax;
    }

    public int maxSubArray2(int[] nums) {
        //optimized prefix sum. Time Complexity: O(n)  Space Complexity:  O(1)
        int maxSum = nums[0];
        int sum = 0;
        int minSum = 0;
        for (int num : nums) {
            // prefix Sum
            sum += num;
            // update maxSum
            maxSum = Math.max(maxSum, sum - minSum);
            // update minSum
            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }

    public int maxSubArray3(int[] nums) {
        // Divide and Conquer. Time Complexity: O(nlogn)  Space Complexity:  O(1)
        return findMax(nums, 0, nums.length - 1);
    }

    public int findMax(int[] nums, int left, int right) {
        if(left > right) {
            return Integer.MIN_VALUE;
        }
        if(left == right) {
            return nums[left];
        }
        int mid = (left + right)/2;

        int leftMax = findMax(nums, left, mid - 1);
        int rightMax = findMax(nums, mid + 1, right);

        int sum = nums[mid];
        int sumMax = nums[mid];
        // left
        for(int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            sumMax = Integer.max(sumMax, sum);
        }

        sum = sumMax;

        for(int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            sumMax = Integer.max(sumMax, sum);
        }

        return Integer.max(Integer.max(leftMax, rightMax), sumMax );
    }

    public static void main(String[] args) {
//        int nums[] = {-2,1,-3,4,-1,2,1,-5,4,-3};
//        int nums[] = {4,-7,5,-2,8};
        int nums[] = {-2,1};
//        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
//        int nums[] = {-1,-5,4};
//        int nums[] = {2,1,3,4,1,2,1,5,4};
//        int nums[] = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
//        int nums[] = {-2,-1,-3,-4,-1,2,-1,-5,-4};
//        int nums[] = {-1,-3,-4,-6,-2,-9,-5,-4};
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray3(nums));
//        System.out.println(solution.maxSubArrayDividConquer(nums));
    }
}
