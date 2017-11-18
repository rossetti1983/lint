package dp.buttomUpDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhizha on 10/22/17.
 */
public class CombinationSum138 {

    public static void main(String[] arg){
        CombinationSum138 combinationSum138 = new CombinationSum138();
        combinationSum138.combinationSum(new int[]{8,7,4,3}, 11);
    }

    /*
    * @param candidates: A list of integers
    * @param target: An integer
    * @return: A list of lists of integers
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        int ri = 0;
        int tmp = -1;
        for(int i = 0; i < candidates.length; i++){
            if(tmp != candidates[i]){
                tmp = candidates[i];
                candidates[ri++] = candidates[i];
            }else{
                i++;
            }
        }

        candidates = Arrays.copyOfRange(candidates, 0, ri);
        
        dfs(res, candidates, 0, target, new ArrayList<Integer>());

        return res;

    }

    private void dfs(List<List<Integer>> res, int[] candidates, int startIndex, int remainingTarget, List<Integer> combination) {
          for(int i = startIndex; i < candidates.length; i++){
              if(candidates[i] > remainingTarget){
                  break;
              }else if(candidates[i] == remainingTarget){
                  combination.add(candidates[i]);
                  res.add(new ArrayList<>(combination));
                  combination.remove(combination.size()-1);
              }else{
                  combination.add(candidates[i]);
                  dfs(res, candidates, i, remainingTarget-candidates[i], combination);
                  combination.remove(combination.size()-1);
              }
          }
    }
}
