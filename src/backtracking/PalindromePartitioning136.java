package backtracking;

import dp.buttomUpDp.PalindromePartitioningII108;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 11/4/17.
 */
public class PalindromePartitioning136 {

    public static void main(String[] arg){
        PalindromePartitioning136 PalindromePartitioning136 = new PalindromePartitioning136();
        PalindromePartitioning136.partition("bb");
    }

    /*
    * @param s: A string
    * @return: A list of lists of string
    */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.equals("")){
            return res;
        }else{
            List<String> tmp = new ArrayList<>();
            findRes(s, res, tmp);
        }

        return res;
    }

    public void findRes(String s, List<List<String>> res, List<String> tmp){
        if(s==null || s.equals("")){
            res.add(new ArrayList<>(tmp));
            return;
        }
        int len = s.length();
        for(int i = 1; i <= len; i++){
            if(isPalindrome(s.substring(0,i))){
                tmp.add(s.substring(0,i));
                findRes(s.substring(i), res, tmp);
                tmp.remove(tmp.size()-1);
            }else{
                continue;
            }
        }
    }

    private boolean isPalindrome(String s){
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while(start<end){
            if(s.charAt(start++) == s.charAt(end--)){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }
}
