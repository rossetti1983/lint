package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 11/5/17.
 */
public class NQueens33 {

    /*
    * @param n: The number of queens
    * @return: All distinct solutions
    */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(".");
        }

        dfs(n, 0, sb, res, new ArrayList<String>(), new ArrayList<String>(), new HashSet<Integer>());
        return res;

    }

    private void dfs(int n, int c, StringBuffer template, List<List<String>> res, List<String> tmp, List<String> tmpRes, Set<Integer> set){

        for(int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                if (checkValid(c, i, tmpRes)) {
                    String s = template.toString();
                    s = replace(s, i, 'Q');
                    tmp.add(s);
                    tmpRes.add(c + "," + i);
                    set.add(i);
                    if (c == n - 1) {
                        res.add(new ArrayList<>(tmp));
                    } else {
                        dfs(n, c + 1, template, res, tmp, tmpRes, set);
                    }
                    set.remove(i);
                    tmp.remove(tmp.size() - 1);
                    tmpRes.remove(tmpRes.size() - 1);
                }
            }
        }
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
