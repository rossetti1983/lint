package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/12/17.
 */
public class SplitString680 {

    public static void main(String[] arg){
        SplitString680 splitString680 = new SplitString680();
        splitString680.splitString("1234567");
    }
    /*
 * @param : a string to be split
 * @return: all possible split string array
 */
    public List<List<String>> splitString(String s) {

        // write your code here
        List<List<String>> re = new ArrayList();
        split(s, new ArrayList<String>(), re);
        return re;
    }

    public void split(String s, List<String> res, List<List<String>> re) {
        if (s == null || s.trim().equals("")) {
            re.add(res);
            return;
        } else if (s.trim().length() == 1) {
            res.add(s);
            re.add(res);
        } else {
            int ls = s.length();
            int rem = ls % 2;
            List<String> neL = new ArrayList(res);
            neL.add(s.substring(0, 1));
            String restStr = s.substring(1);
            split(restStr, neL, re);

            List<String> neL2 = new ArrayList(res);
            neL2.add(s.substring(0, 2));
            String restStr2 = s.substring(2);
            split(restStr2, neL2, re);
        }
    }
}
