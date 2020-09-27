package p67;

public class Solution {
    public String addBinary(String a, String b) {

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;
            if(aIndex >= 0) {
//                sum += Character.getNumericValue(a.charAt(aIndex--));
                sum += a.charAt(aIndex--) - '0';
            }
            if(bIndex >= 0) {
//                sum += Character.getNumericValue(b.charAt(bIndex--));
                sum += b.charAt(bIndex--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int i = a.length() - 1, j = b.length() - 1, carry = 0;
//        while(i >= 0 || j >= 0){
//            int sum = carry;
//            if(i>=0) sum += a.charAt(i--) - '0';
//            if(j>=0) sum += b.charAt(j--) - '0';
//            sb.append(sum % 2);
//            carry = sum / 2;
//        }
//        if(carry > 0 ) sb.append(carry);
//        return sb.reverse().toString();
//    }


    public static void main(String[] args) {

        int nums[] = {1, 2, 3};
        Solution solution = new Solution();
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        System.out.println(solution.addBinary(a, b));

    }
}
