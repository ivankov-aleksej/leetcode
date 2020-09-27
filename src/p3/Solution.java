package p3;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int a_pointer = 0;
        int b_pointer = 0;
        int index = 0;

        for (; b_pointer < s.length() ; b_pointer++) {
            index = s.indexOf(s.charAt(b_pointer), a_pointer);
            if(index != b_pointer) {
                max = Math.max(max, b_pointer - a_pointer);
                a_pointer = index + 1;
            }
        }
        return Math.max(max, b_pointer - a_pointer);


//        int a_pointer = 0;
//        int b_pointer = 0;
//        int max = 0;
//
//        Set<Character> set = new HashSet<>();
//        while (b_pointer < s.length()) {
//            Character character = s.charAt(b_pointer);
//            if(!set.contains(character)) {
//                set.add(character);
//                b_pointer++;
//                max = Math.max(b_pointer - a_pointer, max);
//            } else {
//                set.remove(s.charAt(a_pointer));
//                a_pointer++;
//            }
//        }
//        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("\"ab\" : " + (solution.lengthOfLongestSubstring("ab") == 2));
        System.out.println("\"abcabcbb\" : " + (solution.lengthOfLongestSubstring("abcabcbb") == 3));
        System.out.println("\"bbbbb\" : " + (solution.lengthOfLongestSubstring("bbbbb") == 1));
        System.out.println("\"pwwkew\" : " + (solution.lengthOfLongestSubstring("pwwkew") == 3));
        System.out.println("\"abcddefg\" : " + (solution.lengthOfLongestSubstring("abcddefg") == 4));
        System.out.println("\" \" : " + (solution.lengthOfLongestSubstring(" ") == 1));
        System.out.println("\"\" : " + (solution.lengthOfLongestSubstring("") == 0));
        System.out.println("\"dvdf\" : " + (solution.lengthOfLongestSubstring("dvdf") == 3));
        System.out.println("\"abcddefgh\" : " + (solution.lengthOfLongestSubstring("abcddefgh") == 5));
        System.out.println("\"abdefgdh\" : " + (solution.lengthOfLongestSubstring("abdefgdh") == 6));
        System.out.println("\"a文字列が非常に大きくなっても問題ありません\" : " + (solution.lengthOfLongestSubstring("文字列が非常に大きくなっても問題ありません") == 21));

    }
}
