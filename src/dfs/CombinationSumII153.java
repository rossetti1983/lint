package dfs;

import java.util.*;

/**
 * Created by zhizha on 10/12/17.
 */
public class CombinationSumII153 {

    HashSet<String> key = new HashSet<>();
    public static void main(String[] arg){
        CombinationSumII153 CombinationSumII153 = new CombinationSumII153();
        CombinationSumII153.combinationSum2(new int[]{10}, 10);
    }
    /*
 * @param num: Given the candidate numbers
 * @param target: Given the target number
 * @return: All the combinations that sum to target
 */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> re = new ArrayList<>();
        if(num == null){
            return re;
        }else{
            Arrays.sort(num);
            dfs(num, 0, target, target, re, "");
        }
        return re;
    }

    private void dfs(int[] num, int start, int rem, int tegart, List<List<Integer>> re, String s) {
        for(int i = start; i < num.length; i++){
            if (i == num.length - 1) {
                if (num[i] != rem) {
                    return;
                } else {
                    String s1=(s==null||s.equals("")) ? ""+ num[i] : s +","+num[i];
                    if(key.contains(s1)){
                        return;
                    }else {
                        key.add(s1);
                        String[] sa = s1.split(",");
                        List<Integer> res = new ArrayList<>();
                        for (String ss : sa) {
                            res.add(Integer.valueOf(ss));
                        }
                        re.add(res);
                        return;
                    }
                }
            } else {
                if(num[i] > rem){
                    return;
                }
                else if(num[i] == rem){
                    String s1=(s==null||s.equals("")) ? ""+ num[i] : s +","+num[i];
                    if(key.contains(s1)){
                        return;
                    }else {
                        key.add(s1);
                        String[] sa = s1.split(",");
                        List<Integer> res = new ArrayList<>();
                        for (String ss : sa) {
                            res.add(Integer.valueOf(ss));
                        }
                        re.add(res);
                    }
                    return;
                }else{
                    String s1=(s==null||s.equals("")) ? ""+ num[i] : s +","+num[i];
                    dfs(num, i + 1, rem - num[i], tegart, re, s1);
                }
            }
        }
    }
}
