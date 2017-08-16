package dp;

import java.util.*;

/**
 * Created by zhizha on 8/14/17.
 *
 * Given a digit string excluded 01, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Cellphone

 Notice

 Although the above answer is in lexicographical order, your answer could be in any order you want.

 Have you met this question in a real interview? Yes
 Example
 Given "23"

 Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class LetterCombinationsofaPhoneNumber425 {


    public static void main(String[] arg){
        LetterCombinationsofaPhoneNumber425 letterCombinationsofaPhoneNumber425 = new LetterCombinationsofaPhoneNumber425();
        letterCombinationsofaPhoneNumber425.letterCombinations("22233344456");
    }

    Map<String, List<String>> cache = new HashMap<>();
    /**
         * @param digits: A digital string
         * @return: all posible letter combinations
     **/
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        // write your code here
        if(digits.length() == 1){
            if(digits.equals("2")){
                String[] two = {"a","b","c"};
                return Arrays.asList(two);
            }else if(digits.equals("3")){
                String[] three = {"d","e","f"};
                return Arrays.asList(three);
            }else if(digits.equals("4")){
                String[] four = {"g","h","i"};
                return Arrays.asList(four);
            }else if(digits.equals("5")){
                String[] five = {"j","k","l"};
                return Arrays.asList(five);
            }else if(digits.equals("6")){
                String[] six = {"m","n","o"};
                return Arrays.asList(six);
            }else if(digits.equals("7")){
                String[] seven = {"p","q","r","s"};
                return Arrays.asList(seven);
            }else if(digits.equals("8")){
                String[] eight = {"t","u","v"};
                return Arrays.asList(eight);
            }else if(digits.equals("9")){
                String[] night = {"w","x","y","z"};
                return Arrays.asList(night);
            }else{
                throw new RuntimeException();
            }
        }else{
            String sub = digits.substring(1);
            List<String> l = null;
            if(cache.containsKey(sub)) {
                l = cache.get(sub);
            }else{
                l = letterCombinations(sub);
                cache.put(sub,l);
            }
            String subs = digits.substring(0,1);
            List<String> list = null;
            if(cache.containsKey(subs)) {
                list = cache.get(subs);
            }else{
                list = letterCombinations(subs);
                cache.put(subs,list);
            }
            List<String> res = new ArrayList<>();
            for(String s : list){
                for(String ss : l){
                    res.add(s+ss);
                }
            }
            return  res;
        }
    }
}
