package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhizha on 8/29/17.
 */
public class PermutationsII16 {

    public static void main(String[] arg){
        PermutationsII16 permutationsII16 = new PermutationsII16();
        permutationsII16.permuteUnique(new int[]{1,2,3});
    }

    HashSet<String> cache = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            res.add(new ArrayList<Integer>());
        }else{
            permute(nums, new ArrayList<Integer>(), "");
        }

        for(String s:cache){
            List<Integer> li = new ArrayList<>();
            String[] sa = s.split(",");
            for(String num:sa){
                li.add(Integer.valueOf(num));
            }
            res.add(li);
        }

        return res;
    }

    public void permute(int[] nums, List<Integer> indexPicked, String s){

        for(int i = 0 ; i < nums.length; i++){
            if(indexPicked != null && !indexPicked.contains(i)){
                List<Integer> newL = new ArrayList<>(indexPicked);
                newL.add(i);
                if(newL.size() == nums.length){
                    cache.add(((!s.equals(""))?(s+","):"")+nums[i]);
                }else{
                    permute(nums, newL, ((!s.equals(""))?(s+","):"")+nums[i]);
                }
            }
        }
    }
}
