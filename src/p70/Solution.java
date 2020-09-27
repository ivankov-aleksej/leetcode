package p70;

public class Solution {
//    https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-70-climbing-stairs/
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        int result = 1;
        for (int i = 2; i <= n ; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(47));
    }

//        5 step
//        1+1+1+1+1
//        1+1+1+2
//        1+1+2+1
//        1+2+1+1
//        2+1+1+1
//        1+2+2
//        2+1+2
//        2+2+1
//
//        6
//        1+1+1+1+1+1
//        1+1+1+1+2
//        1+1+1+2+1
//        1+1+2+1+1
//        1+2+1+1+1
//        2+1+1+1+1
//        1+1+2+2
//        1+2+1+2
//        2+1+1+2
//        1+2+2+1
//        2+1+2+1
//        2+2+1+1
//        2+2+2
//
//        0 1
//        1 1
//        1 2
//        3 3
//        4 5
//        5 8
//        6 13
//        7 21
//        8 34
}
