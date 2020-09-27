package p27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                if(index != i) {
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        return index++;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {0,1,2,2,3,0,4,2};
        System.out.println(solution.removeElement(num, 2));
        for (int i : num) {
            System.out.print(i);
        }

    }
}
