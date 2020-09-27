package p9;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            String s = "" + x;
            for (int i = 0, j = s.length() - 1; i < j; i++, j --) {
                if(s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        } else {
            String s = "" + x;
            String rev =  new StringBuilder(s).reverse().toString();
            return s.intern() == rev.intern();
        }
    }

    public boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }


        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome3(-121));
        System.out.println(solution.isPalindrome3(121));
        System.out.println(solution.isPalindrome3(1));
        System.out.println(solution.isPalindrome3(10));
        System.out.println(solution.isPalindrome3(11));
    }
}
