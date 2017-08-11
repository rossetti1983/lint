package array;

import java.util.HashMap;

/**
 * Created by zhizha on 8/7/17.
 */
public class JumpGame116 {
    HashMap<Integer, Boolean> cache = new HashMap();

    public static void main(String[] arg){
        int[] a = new int[]{4,6,9,5,9,3,0};
        JumpGame116 jumpGame116 = new JumpGame116();
        jumpGame116.canJump(a);
    }
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     *
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.
     */
    public boolean canJump(int[] A) {
        if(A==null && A.length == 0){
            return false;
        }
        int startIndex = 0;
        return canJump(A,0);
    }

    private boolean canJump(int[] a, int i) {
        if(i >= a.length - 1){
            return true;
        }
        int next = a[i];
        if(next == 0){
            return false;
        }
        boolean cc = false;
        for(int j = 1; j<=next; j++){
            boolean c = false;
            if(cache.containsKey(i+j)){
                c = cache.get(i+j);
            }else{
                c = canJump(a, i + j);
                cache.put(i + j, c);
            }
            if(c){
                cc = true;
            }
        }
        return cc;
    }
}
