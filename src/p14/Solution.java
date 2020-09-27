package p14;

import java.awt.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int indexMinString = 0;
        for (int i = 1; i < strs.length; i++) {
            if(strs[indexMinString].length() > strs[i].length()) {
                indexMinString = i;
            }
        }
        String[] copy = new String[strs.length-1];
        System.arraycopy(strs, 0, copy, 0, indexMinString);
        System.arraycopy(strs, indexMinString+1, copy, indexMinString, strs.length-indexMinString-1);

        int low = 0, high = strs[indexMinString].length() - 1;

        String result = "";
        while (low <= high) {
            int mid = (high + low) / 2;
            String pref = strs[indexMinString].substring(0, mid + 1);
            for (int i = 0; i < copy.length; i++) {
                if(!copy[i].startsWith(pref)) {
                    high = mid - 1;
                    break;
                }
                if(i == copy.length - 1){
                    low = mid + 1;
                    result = pref;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] strs = {"flower","flow","flight"};
        String[] strs = new String[0];
//        String[] strs = {"f","flower"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
