package p118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows ; i++) {
            if(i - 1 < 0) {
                result.add(Collections.singletonList(1));
            } else {
                List<Integer> last = result.get(result.size() - 1);
                List<Integer> temp = new ArrayList<>();
                temp.add(1);
                for (int j = 1; j < last.size(); j++) {
                    temp.add(last.get(j - 1) + last.get(j));
                }
                temp.add(1);
                result.add(temp);
            }
        }
        return result;
    }
}
