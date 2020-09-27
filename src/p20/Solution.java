package p20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}','{');
        brackets.put(']','[');
        brackets.put(')','(');
        //()
        //5+)6-3(-8
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //if(brackets.containsKey(c) || brackets.containsValue(c)) {
            if (!brackets.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.empty() ? '?' : stack.pop();
                if (top != brackets.get(c)) {
                    return false;
                }
            }
            //}
        }
        return stack.empty();
    }
}
