package p13;

import java.util.*;

public class Solution3 {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        set.add('V');
        set.add('L');
        set.add('D');



        if(s == null || s.length() == 0) {
            throw new IllegalArgumentException("string is wrong");
        }

        List<String> list = splitString(map, set, s);

        list.forEach(System.out:: println);
        return 0;
    }

    private List<String> splitString (Map<Character, Integer> map, Set<Character> set, String s){
        List<String> list = new ArrayList<>();
        if(s.length() == 1) {
            list.add(s);
            return list;
        }
        int i = s.length() - 1, j = s.length() - 1;
        while (s.length() > 0) {
            if(s.length() == 1) {
                list.add(s);
                break;
            }
            Character ch1 = s.charAt(i - 1);
            Character ch2 = s.charAt(i);
            if(ch1.equals(ch2)) {
                if(set.contains(ch1) || (j - (i - 1) > 3)) {
                    throw new IllegalArgumentException("string is wrong");
                }
                i--;
            }
            if(map.get(ch1) < map.get(ch2)) {
                if(set.contains(ch1)) {
                    throw new IllegalArgumentException("string is wrong");
                }
                if(list.size() > 0) {
                    if(map.get(ch1) <= map.get(list.get(list.size()-1).charAt(0))) {
                        throw new IllegalArgumentException("string is wrong");
                    }
                }
            }
            if(map.get(ch1) > map.get(ch2)) {
                list.add(s.substring(i - 1));
                s = s.substring(0, i);
            }
        }
        return list;
    }
    // XXVIII
    // XXVIII
    // CDCD  DCCC

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        solution.romanToInt("XXX");
//        solution.romanToInt("LM");
//        solution.romanToInt("ID");
//        solution.romanToInt("MCMXCIV");
//        solution.romanToInt("MCMXCVII");
        solution.romanToInt("VIII");
//        solution.romanToInt("XXX");
//        solution.romanToInt("XXX");
    }
}
