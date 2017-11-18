package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhizha on 11/6/17.
 */
public class KsumII {

    public static void main(String[] arg){
        KsumII ksumII = new KsumII();
        ksumII.kSumII(new int[]{-1,2,-3,4},2,-1);
    }

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(k==0 || A==null||A.length==0){
            return res;
        }
        Arrays.sort(A);
        dfs(A,0,k,target,res,new ArrayList<Integer>());

        return res;
    }

    private void dfs(int[] A, int index, int k, int remain, List<List<Integer>> res, List<Integer> tmp){
        if(index>=A.length){
            return;
        }

        if(k==1){
            if(A[index] == remain) {
                tmp.add(A[index]);
                res.add(new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size() - 1);
            }else if(A[index] > remain){
                return;
            }else{
                dfs(A, index+1, k, remain, res, tmp);
            }
        }else{
            if(A[index] >= remain){
                return;
            }else{
                dfs(A, index+1, k, remain, res, tmp);
                tmp.add(A[index]);
                remain = remain - A[index];
                dfs(A, index+1, k-1, remain, res, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
