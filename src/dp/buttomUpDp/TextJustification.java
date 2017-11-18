package dp.buttomUpDp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 9/3/17.
 */
public class TextJustification {

    public static void main(String[] arg){
        TextJustification textJustification = new TextJustification();
        String[] a ={"This", "is","Roy","abasdlaklnsd","asdasd","qe123"};
        textJustification.fullJustify(a, 18);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || words.length == 0 || maxWidth == 0 ||(words.length==1&&words[0].trim().equals(""))){
            List res =  new ArrayList<String>();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < maxWidth; i++){
                sb.append(" ");
            }
            res.add(sb.toString());
            return res;
        }

       int len  = words.length;
       int[][] dp = new int[len][len];

       for(int i = 0; i<len; i++){
           StringBuffer sb = new StringBuffer();
           for(int j = i; j < len; j++){
               sb.append(" " + words[j]);
               String cur = sb.toString().trim();
               if(maxWidth<cur.length()){
                   dp[i][j] = Integer.MAX_VALUE;
               }else{
                   dp[i][j] = Double.valueOf(Math.pow(maxWidth - cur.length(), 2)).intValue();
               }
           }
       }

       int[] cost = new int[len];
       int[] pointer = new int[len];

       for(int i = len - 1; i >= 0; i--){
           int min = Integer.MAX_VALUE;
           for(int j = len - 1 ; j >= i; j--){
               int tmpCost = (j==len-1)?dp[i][j]:dp[i][j] + cost[j+1];
               if(tmpCost < min){
                   min = dp[i][j];
                   pointer[i] = j;
                   cost[i] = min;
               }
           }
       }

       int index = 0 ;
       List<String> res = new ArrayList<>();
       while(index <= len - 1){
           StringBuffer sb = new StringBuffer();
           for(int i = index; i <= pointer[index]; i++){
               sb.append(i == index ? words[i]:(" "+words[i]));
           }
           int diff = maxWidth-sb.length();
           for(int i = 0; i<diff; i++){
               sb.append(" ");
           }
           res.add(sb.toString());
           index =pointer[index]+1;
       }
        return res;

    }
}
