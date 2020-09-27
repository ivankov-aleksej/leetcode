package p14;

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }

        int low = 0, high = strs[0].length() - 1;

        String result = "";
        while (low <= high) {
            int mid = (high + low) / 2;
            String pref = strs[0].substring(0, mid + 1);
            for (int i = 1; i < strs.length; i++) {
                if(!strs[i].startsWith(pref)) {
                    high = mid - 1;
                    break;
                }
                if(i == strs.length - 1){
                    low = mid + 1;
                    result = pref;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] strs = {"flower","flow","flight"};
//        String[] strs = new String[0];
//        String[] strs = {"f","flower"};
//        String[] strs = {"flower","f"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
