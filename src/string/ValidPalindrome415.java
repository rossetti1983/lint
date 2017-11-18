package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhizha on 8/29/17.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice

 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 Have you met this question in a real interview? Yes
 Example
 "A man, a plan, a canal: Panama" is a palindrome.

 "race a car" is not a palindrome.
 */
public class ValidPalindrome415 {

    public static void main(String[] arg){
        ValidPalindrome415 validPalindrome415 = new ValidPalindrome415();
        validPalindrome415.isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        HashSet<String> cache = new HashSet<>();

        // write your code here
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!((s.charAt(start) <= 90 && s.charAt(start) > 60)
                    || (s.charAt(start) <= 122 && s.charAt(start) >= 97) || (s.charAt(start) <= 57 && s.charAt(start) >= 48))){
                start++;
            }else{
                if(!((s.charAt(end) <= 90 && s.charAt(end) > 60)
                        || (s.charAt(end) <= 122 && s.charAt(end) >= 97)|| (s.charAt(end) <= 57 && s.charAt(end) >= 48))){
                    end--;
                }else{
                    if((s.charAt(start) == s.charAt(end)) || (s.charAt(start) == (s.charAt(end) - 32))
                            || ((s.charAt(start) - 32) == s.charAt(end))){
                        start++;
                        end--;
                    }else{
                        return false;
                    }
                }
            }

        }

        return true;

    }
}
