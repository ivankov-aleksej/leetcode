package p66;

public class Solution {
    public int[] plusOne(int[] digits) {
        int num = 1;
        int head = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + num + head;
            num = sum % 10;
            head = sum / 10;
            digits[i] = num;
            num = 0;
        }

        if (head !=0) {
            int[] copy = new int[digits.length + 1];
            copy[0] = head;
            for(int i = digits.length; i > 0; i--) {
                copy[i] = digits[i - 1];
            }
            return copy;
        } else {
            return digits;
        }
    }
    public static void main(String[] args) {

        int nums[] = {1, 2, 3};
        Solution solution = new Solution();

        System.out.println(solution.plusOne(nums));
    }
}
