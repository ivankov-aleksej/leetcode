package p69;

public class Solution {
//    http://zxi.mytechroad.com/blog/math/leetcode-69-sqrtx/
//    Solution 3: Newton’s method
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            System.out.println(a);
            System.out.println(x);
            System.out.println(x/a);
            a = (a + x / a) / 2;
//            System.out.println(a);

        }
        return (int)a;
    }

    public int mySqrt2(int x) {
        int start = 1;
        int end = x / 2;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            System.out.println(mid);
            if(mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1 ;
            }
        }
        return end;

//        int l = 1;
//        int r = x;
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            System.out.println(m);
//            if (m > x / m) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
//        }
//        return r;
    }

    public static void main(String[] args) {

        int x = 999;
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(x*x));

    }
}
