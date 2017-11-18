package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhizha on 8/18/17.
 */
public class LongestSubstringWithoutRepeatingCharacters384 {

    /**
     * @param s: a string
     * @return: an
     * Given a string, find the length of the longest substring without repeating characters.

Have you met this question in a real interview? Yes
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null || s.trim().length()==0){
            return 0;
        }

        int len = s.length();
        int pointer0 = 0;
        int pointer1 = 0;
        int longestLen = 0;
        HashMap<Character, Integer> cache = new HashMap<>();
        while(pointer1 < len){
            char c = s.charAt(pointer1);
            if(!cache.containsKey(c) || (cache.containsKey(c) && cache.get(c) < pointer0)){
                cache.put(c, pointer1);
            }else{
                pointer0 = cache.get(c)+1;
                cache.put(c,pointer1);
            }

            if((pointer1 - pointer0 + 1) > longestLen){
                longestLen = (pointer1 - pointer0 + 1);
            }
            pointer1++;
        }


        return longestLen;
    }
}
