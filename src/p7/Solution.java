package p7;

public class Solution {
    public int reverse(int x) {

        long reverse = 0;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) reverse;
        }
    }

    // integer min -2147483648, integer max 2147483647
    public final int lowerThreshold = Integer.MIN_VALUE / 10;
    public final int upperThreshold = Integer.MAX_VALUE / 10;

    public int reverse2(int x) {
        int r = 0, reverse = 0;
        if (x == 0) return 0;
        while (x != 0) {
            if (reverse < lowerThreshold)
                return 0;
            if (reverse > upperThreshold)
                return 0;
            r = reverse * 10 + x % 10;
            if      ((x > 0) && (r < reverse))
                return 0;
            else if ((x < 0) && (r > reverse))
                return 0;
            reverse  = r;
            x       /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(-2147483647));
        System.out.println(solution.reverse(-47412));
//        System.out.println(solution.reverse2(2147483644));

    }
}
