package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 8/29/17.
 * Given n and k, return the k-th permutation sequence.

 Notice

 n will be between 1 and 9 inclusive.

 Have you met this question in a real interview? Yes
 Example
 For n = 3, all permutations are listed as follows:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 If k = 4, the fourth permutation is "231"
 */
public class PermutationSequence388 {

    /*
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k) {
        // write your code here
        if(n<2){
            return String.valueOf(n);
        }
        int[] nums = new int[n];
        for(int i = 0; i <n; i++){
            nums[i] = i+1;
        }

        // write your code here
        List<String> res = new ArrayList<>();
        permute(nums, new ArrayList<Integer>(), "", res);
        int i = 1;
        String resS = null;
        for(String ss: res){
            if(i==k){
                resS = ss;
                break;
            }else{
                i++;
            }
        }

        return resS;

    }

    public void permute(int[] nums, List<Integer> indexPicked, String s, List<String> res){

        for(int i = 0 ; i < nums.length; i++){
            if(indexPicked != null && !indexPicked.contains(i)){
                List<Integer> newL = new ArrayList<>(indexPicked);
                newL.add(i);
                if(newL.size() == nums.length){
                    res.add(((!s.equals(""))?(s+""):"")+nums[i]);
                }else{
                    permute(nums, newL, ((!s.equals(""))?(s+""):"")+nums[i], res);
                }
            }
        }
    }

    public void getPermutation(int n, int start, List<String> list, String s){
        for(int i = 1; i<=n; i++){


        }
    }
}
