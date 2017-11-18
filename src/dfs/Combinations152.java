package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/22/17.
 */
public class Combinations152 {

    public static void main(String[] arg){
        Combinations152 combinations152 = new Combinations152();
        combinations152.combine(1,1);
    }
    /*
 * @param n: Given the range of numbers
 * @param k: Given the numbers of combinations
 * @return: All the combinations of k numbers out of 1..n
 */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(n==0 || k==0){
            return res;
        }

        int[] nums = new int[n];
        for(int i = 1; i <=n; i++){
            nums[i-1] = i;
        }

        dfs(nums, 0, k,res, new ArrayList<Integer>());

        return res;
    }

    public void dfs(int[] nums,int start, int remain, List<List<Integer>> res, List<Integer> re){
        for(int i = start; i < nums.length; i++){
            if(remain == 1){
                re.add(nums[i]);
                res.add(new ArrayList<>(re));
                re.remove(re.size()-1);
            }else{
                re.add(nums[i]);
                dfs(nums, i+1, remain-1, res, re);
                re.remove(re.size()-1);
            }
        }
    }
}
