package hashmap;

import java.util.*;

/**
 * Created by zhizha on 8/18/17.
 *
 * Given an array of strings, return all groups of strings that are anagrams.

 Notice

 All inputs will be in lower-case

 Have you met this question in a real interview? Yes
 Example
 Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

 Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].


 */
public class Anagrams171 {

    public static void main(String[] arg){
        String[] strs = new String[]{"","b",""};
        System.out.println(7%10);
        Anagrams171 anagrams171 = new Anagrams171();
        anagrams171.anagrams(strs);
    }

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0){
            return new ArrayList<String>();
        }
        HashMap<String,String> cache = new HashMap<>();

        int i = 0;
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String a = String.valueOf(c);
            if(!cache.containsKey(a)){
                cache.put(a, i+"");
            }else{
            cache.put(a, cache.get(a)+"-"+i);
            }
            i++;
        }

        Set<String> set = cache.keySet();
        List<String> res = new ArrayList<>();
        for(String c : set){
            String s = cache.get(c);
            String[] ss = s.split("-");
            if(ss.length>1) {
                for (int ii = 0; ii < ss.length; ii++) {
                    res.add(strs[Integer.valueOf(ss[ii])]);
                }
            }
        }

        return res;
    }
}
