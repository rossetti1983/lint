package hashmap;

import java.util.HashMap;

/**
 * Created by zhizha on 8/18/17.
 * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

 Notice

 If there is no such window in source that covers all characters in target, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

 Have you met this question in a real interview? Yes
 Clarification
 Should the characters in minimum window has the same order in target?

 Not necessary.
 Example
 For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
 */
public class MinimumWindowSubstring32 {

    public static void main(String[] arg){
        String s = "ADBBECODEBABC";
        String t = "ABBC";
        MinimumWindowSubstring32 minimumWindowSubstring32 = new MinimumWindowSubstring32();
        minimumWindowSubstring32.minWindow(s,t);
    }
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        HashMap<Character,Integer> cache = new HashMap<>();
        for(int i = 0; i < target.length(); i++){
            if(cache.containsKey(target.charAt(i))){
                cache.put(target.charAt(i), cache.get(target.charAt(i))+1);
            }else{
                cache.put(target.charAt(i), 1);
            }
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String minS = "";
        while(right < source.length()){
            char c = source.charAt(right++);
            if(cache.containsKey(c)){
                cache.put(c, cache.get(c) - 1);
                if(cache.get(c) >= 0){
                    count++;
                }

                while(count == target.length()){
                    if((right - left + 1) < min){
                        min = right - left + 1;
                        minS = source.substring(left, right);
                    }

                    if(cache.containsKey(source.charAt(left))){
                        cache.put(source.charAt(left), cache.get(source.charAt(left)) + 1);
                        if(cache.get(source.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left ++;
                }
            }

        }

        return minS;
    }
}
