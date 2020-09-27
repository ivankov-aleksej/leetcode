package p38;

class Solution {
    public String countAndSay(int n) {
        String current = "1";

        for(int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int frequency = 1;
            char ch = current.charAt(0);

            for(int x = 1; x < current.length(); x++) {
                if(current.charAt(x) == ch) {
                    frequency ++;
                } else {
                    next.append(frequency).append(ch);
                    ch = current.charAt(x);
                    frequency = 1;
                }
            }
            current = next.append(frequency).append(ch).toString();
        }

        return current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final long then = System.nanoTime();
        solution.countAndSay2(74);
        final long millis = System.nanoTime() - then;
        System.out.println(millis);
    }

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2){
            return "11";
        }
        String prev = countAndSay(n-1);
        int i = 0;
        int len = prev.length();
        StringBuilder ans = new StringBuilder();
        while(i < len) {
            int j = 0;
            char cur = prev.charAt(i);
            //这里j必须从0开始， 计算当前有多少个字符和cur是一样的
            while(i + j < len && prev.charAt(i + j) == cur) {
                j++;
            }
            ans.append(j);
            ans.append(cur);
            i += j;
        }
        return ans.toString();

    }
}
