package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 11/5/17.
 */
public class NQueensII34 {
    /*
 * @param n: The number of queens.
 * @return: The total number of distinct solutions.
 */

    public int totalNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(n==0){
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(".");
        }

        return dfs(n, 0, sb, new ArrayList<String>(), new ArrayList<String>(), new HashSet<Integer>());
    }

    private int dfs(int n, int c, StringBuffer template, List<String> tmp, List<String> tmpRes, Set<Integer> set){
        int res = 0;
        for(int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                if (checkValid(c, i, tmpRes)) {
                    String s = template.toString();
                    s = replace(s, i, 'Q');
                    tmp.add(s);
                    tmpRes.add(c + "," + i);
                    set.add(i);
                    if (c == n - 1) {
                        res += 1;
                    } else {
                        res += dfs(n, c + 1, template, tmp, tmpRes, set);
                    }
                    set.remove(i);
                    tmp.remove(tmp.size() - 1);
                    tmpRes.remove(tmpRes.size() - 1);
                }
            }
        }

        return res;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private boolean checkValid(int x, int y, List<String> tmpRes) {
        for(String s : tmpRes){
            String[] pos =  s.split(",");
            int x0 = Integer.valueOf(pos[0]);
            int y0 = Integer.valueOf(pos[1]);
            if(x0 == x || y0 == y){
                return false;
            }else if(Math.abs(x0-x) == Math.abs(y0-y)){
                return false;
            }
        }
        return true;
    }
}
