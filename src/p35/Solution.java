package p35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        for(; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return i;
    }
}
