package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/9/17.
 */
public class EditDistance119 {

    HashMap<String, Integer> cache = new HashMap<>();

    public static void main(String[] arg){
        EditDistance119 editDistance119 = new EditDistance119();
        System.out.println(editDistance119.minDistance("mart", "karma"));
    }

    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     *
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
     * (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if((word1==null || "".equals(word1) && (word2==null || "".equals(word2)))){
            return 0;
        }else if((word1==null || "".equals(word1)) && (word2!=null && !word2.equals(""))){
            return word2.length();
        }else if((word2==null || "".equals(word2)) && (word1!=null && !word1.equals(""))){
            return word1.length();
        }
        if(cache.containsKey(word1+"-"+word2)){
            return cache.get(word1+"-"+word2);
        }
        int w1 = word1.length();
        int w2 = word2.length();
        int min = Integer.MAX_VALUE;
        int cost = Integer.MAX_VALUE;
        if(word1.charAt(0)==word2.charAt(0)){
            cost = minDistance(word1.substring(1), word2.substring(1));
        }else {
            int costReplace = 1 + minDistance(word1.substring(1), word2.substring(1));
            int costInsert = 1 + minDistance(word1, word2.substring(1));
            int costDel = 1 + minDistance(word1.substring(1), word2);
            min = Math.min(costDel, Math.min(costReplace, costInsert));
        }
        cache.put(word1+"-"+word2, Math.min(min,cost));

        return Math.min(min,cost);
    }
}
