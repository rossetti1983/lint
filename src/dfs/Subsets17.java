package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/22/17.
 */
public class Subsets17 {

    public static void main(String[] arg){
        Subsets17 subsets17 = new Subsets17();
        subsets17.subsets(new int[]{1,2,3});
    }

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return res;
        }
        for(int i = 1; i <= nums.length; i++){
            subset(nums, 0, i, res, new ArrayList<>());
        }

        return res;
    }

    public void subset(int[] nums, int start, int remainK, List<List<Integer>> res, List<Integer> rr){
        if(remainK == 0){
            res.add(new ArrayList<>(rr));
        }
        for(int i = start; i< nums.length; i++){
                rr.add(nums[i]);
                subset(nums, i+1, remainK-1, res, rr);
                rr.remove(rr.size()-1);
        }
    }
}
