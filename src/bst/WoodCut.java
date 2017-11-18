package bst;

import bfs.WordLadderII121;

/**
 * Created by zhizha on 11/14/17.
 */
public class WoodCut {

    public static void main(String[] arg){
        WoodCut woodCut = new WoodCut();
        woodCut.woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4);
    }

    public int woodCut(int[] L, int k) {
        // write your code here
        if(L==null || L.length==0){
            return 0;
        }
        if(k==1){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < L.length; i++){
                if(max<L[i]){
                    max = L[i];
                }

                if(min>L[i]){
                    min = L[i];
                }
            }
            return max;
        }
        long len = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < L.length; i++){
            if(max<L[i]){
                max = L[i];
            }

            if(min>L[i]){
                min = L[i];
            }
            len += L[i];
        }

        long maxLen = len/k;
        int count = 0 ;
        for(int i:L){
            count += i/max;
        }
        if(count==k){
            return (int)maxLen;
        }
        long res = findMax(L, k, len, 1, maxLen, -1);
        return (int)res;
    }

    private long findMax(int[] L, int k, long totalLen, long minLen, long maxLen, long res){
        if(minLen>maxLen){
            return res==-1?0:res;
        }

        long mid = (minLen + maxLen)/2;
        long count1 = 0 ;
        for(int i:L){
            count1 += i/mid;
        }

        if(count1 < k){
                return findMax(L, k, totalLen, minLen, mid-1, res);
        }else{
                if(res < mid){
                    res = mid ;
                }
                return findMax(L, k, totalLen, mid+1, maxLen, res);
        }

    }
}
