package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhizha on 11/4/17.
 */
public class FindtheMissingNumberII570 {

    public static void main(String[] arg){
        FindtheMissingNumberII570 findtheMissingNumberII570 = new FindtheMissingNumberII570();
        findtheMissingNumberII570.findMissing2(11,"111098765432");
    }
    /*
    * @param n: An integer
    * @param str: a string with number from 1-n in random order and miss one number
    * @return: An integer
    */
    public int findMissing2(int n, String str) {
        // write your code here
        if(str == null || str.equals("") || n < 1){
            return -1;
        }
        Set<Integer> set = new HashSet<Integer>();
        int res = findMissing(n, str, -1, set);
        return res;
    }

    private int findMissing(int n, String str, int missingNum, Set<Integer> set){
        if(str == null || str.equals("") ){

            return findMis(set, n);
        }

        if(str.charAt(0) == '0'){
            return -1;
        }
        Double len = Math.floor(Math.log(n)/Math.log(10))+1;
        for(int i = 1; i<= len.intValue(); i++){
            if(i<=str.length()) {

                int nn = Integer.valueOf(str.substring(0, i));
                if(nn>n || nn<1){
                    continue;
                }
                if (set.contains(nn)) {
                    continue;
                } else {
                    set.add(nn);
                    int res = findMissing(n, str.substring(i), missingNum, set);
                    if (res != -1) {
                        return res;
                    }
                    set.remove(nn);
                }
            }
        }

        return -1;

    }

    private int findMis(Set<Integer> set, int n){
        int count = 0;
        int miss = -1;
        Integer[] a = new Integer[set.size()];
        set.toArray(a);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(Integer i:a){
            if(i>max){
                max = i;
            }
            if(i<min){
                min = i;
            }
        }

        if(max>n){
            return -1;
        }
        if(min<1){
            return -1;
        }

        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                count++;
                miss = i;
            }
        }
        if(count==1){
            return miss;
        }else{
            return -1;
        }
    }
}
