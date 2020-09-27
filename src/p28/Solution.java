package p28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null) {
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }

        int haystackLenght = haystack.length();
        int needleLenght = needle.length();

        int index = 0;
        for(int i = 0; i < haystackLenght; i++) {
            if(haystackLenght - i < needleLenght) {
                return -1;
            }
            if(haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                if(needleLenght == 1) {
                    return index;
                }
                for(int x = 1; x < needleLenght; x++) {
                    if(haystack.charAt(i + x) != needle.charAt(x)) {
                        break;
                    }
                    if(x == needleLenght - 1) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }
}
