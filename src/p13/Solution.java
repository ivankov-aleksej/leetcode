package p13;

import p2.ListNode;

import java.util.*;

public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        Set<Character> set = new HashSet<>();
        Map<Character, Set<Character>> rule = new HashMap<>();

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

        Set<Character> temp1 = new HashSet<>();
        temp1.add('V');
        temp1.add('X');
        rule.put('I',temp1);

        Set<Character> temp2 = new HashSet<>();
        temp2.add('C');
        temp2.add('L');
        rule.put('X',temp2);

        Set<Character> temp3 = new HashSet<>();
        temp3.add('D');
        temp3.add('M');
        rule.put('C',temp3);

        if(s == null || s.length() == 0) {
            throw new IllegalArgumentException("string is wrong");
        }

        List<String> list = splitString(map, set, rule,  s);

        list.forEach(System.out:: println);
        return 0;
    }

    private List<String> splitString (Map<Character, Integer> map, Set<Character> set2, Map<Character, Set<Character>> rule, String s){
        List<String> list = new ArrayList<>();
        if(s.length() == 1) {
            list.add(s);
            return list;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
//            if(i - j > 3) {
//                throw new IllegalArgumentException("string is wrong");
//            }
            if(i + 1 == s.length()){
                list.add(s.substring(j));
                break;
            }

            Character ch1 = s.charAt(i);
            Character ch2 = s.charAt(i + 1);

            if(map.get(ch1) < map.get(ch2)) {
                if(!rule.containsKey(ch1)) {
                    throw new IllegalArgumentException("string is wrong");
                } else {
                    Set<Character> set = rule.get(ch1);
                    if(!set.contains(ch2)) {
                        throw new IllegalArgumentException("string is wrong");
                    }
                    list.add(s.substring(i, i + 2));
                    j = i + 1;
                    i++;
                }
            } else if (map.get(ch1).equals(map.get(ch2))) {
                if(set2.contains(ch1)) {
                    throw new IllegalArgumentException("string is wrong");
                }
                if(j == i) {
                    list.add(s.substring(j, i + 1));
                    j = i + 1;
                }
            } else {
                if(rule.containsKey(ch2)) {
                    list.add(s.substring(j, i + 1));
                    j = i + 1;
                }
            }
        }
        return list;
    }
    // XXVIII
    // XXVIII
    // CDCD  DCCC

    public static void main(String[] args) {
        Solution solution = new Solution();
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
