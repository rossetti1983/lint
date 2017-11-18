package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhizha on 8/30/17.
 * Given a string which contains only letters. Sort it by lower case first and upper case second.

 Notice

 It's NOT necessary to keep the original order of lower-case letters and upper case letters.

 Have you met this question in a real interview? Yes
 Example
 For "abAcD", a reasonable answer is "acbAD"
 */
public class SortLettersbyCase49 {

    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int left = 0;
        boolean leftFound = false;
        int right = chars.length -1;
        boolean rightFound = false;
        while(left<right){
            if(Character.isLowerCase(chars[left])){
                leftFound = true;
            }
            if(Character.isUpperCase(chars[right])){
                rightFound = true;
            }

            if(leftFound && rightFound){
                char tmp = chars[right];
                chars[right] = chars[left];
                chars[left] = tmp;
                leftFound = false;
                rightFound = false;
                left++;
                right--;
            }else if(leftFound){
                right--;
            }else if(rightFound){
                left++;
            }else{
                right--;
                left++;
            }
        }
    }

}
