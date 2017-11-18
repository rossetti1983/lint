package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhizha on 8/22/17.
 * Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

 Have you met this question in a real interview? Yes
 Example
 Given [1,2,4], return 1.
 */
public class PermutationIndex197 {


    public static void main(String[] arg) {
        PermutationIndex197 permutationIndex197 = new PermutationIndex197();
        permutationIndex197.permutationIndex(new int[]{3,5,4,1});
    }
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        int[] B = Arrays.copyOf(A, A.length);
        HashMap<Integer, Integer> cache = new HashMap<>();
        Arrays.sort(B);
        for(int i = 0; i< B.length; i++){
            if(!cache.containsKey(B[i])) {
                cache.put(B[i], i);
            }
        }
        int count = 0;
        List<Integer> seen = new ArrayList<>();
        seen.add(9);
        for(int i=0; i<A.length; i++){
            int k = A[i];
            int lessThanK = cache.get(k);
            for(Integer j : seen){
                if(k>j){
                    lessThanK--;
                }
            }
            seen.add(k);
            int l = A.length - i - 1;
            int sum = lessThanK;
            while(l>0){
                sum = sum * l--;
            }
            count = count + sum;
        }
        return count + 1;
    }
}
