package dfs;

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
public class LetterCombinationsofaPhoneNumber425DFSSolution {


    public static void main(String[] arg){
        LetterCombinationsofaPhoneNumber425DFSSolution letterCombinationsofaPhoneNumber425 = new LetterCombinationsofaPhoneNumber425DFSSolution();
        letterCombinationsofaPhoneNumber425.letterCombinations("22233344456");
    }

    String[] dic = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    /**
         * @param digits: A digital string
         * @return: all posible letter combinations
     **/
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        StringBuffer sb = new StringBuffer("");
        List<String> list = new ArrayList<>();
        letterCombinations(digits, sb, list);
        return list;

    }

    private void  letterCombinations(String digits, StringBuffer sb, List<String> list) {
        for(int i = 0; i < dic[digits.charAt(0) - '0'].length(); i++){
            sb.append(dic[digits.charAt(0) - '0'].charAt(i));
            if(digits.length() > 1) {
                letterCombinations(digits.substring(1), sb, list);
            }else{
                list.add(sb.toString());
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
