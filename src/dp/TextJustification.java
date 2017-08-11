package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhizha on 8/9/17.
 *
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' '
 when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words,
 the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {

    HashMap<String, Long> cache = new HashMap<>();
    HashMap<String, Long> badnessCache = new HashMap<>();


    public static void main(String[] arg){
        TextJustification textJustification = new TextJustification();
        String[] a ={"This","is","an", "example","of","text","justification."};
        textJustification.fullJustify(a, 16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        if(words == null || words.length == 0){
            return list;
        }
        if(maxWidth==0){
            return list;
        }

        fullJustify(words, maxWidth, 0, words.length - 1);
        int index = 0;
        int start = 0;
        while(index<words.length){
            long min = Long.MAX_VALUE;
            int minK = -1;
            for(int i = index ; i<= words.length-1; i++) {
                if (badnessCache.containsKey(index + "-" + i) && cache.containsKey(i + "-" + (words.length - 1))) {
                    if ((badnessCache.get(index + "-" + i) + cache.get(i + "-" + (words.length - 1))) < min) {
                        min = (badnessCache.get(index + "-" + i) + cache.get(i + "-" + (words.length - 1)));
                        minK = i;
                    }
                } else {
                    continue;
                }
            }
            index = minK;
            StringBuffer sb = new StringBuffer();
            for(int i = start; i< index ; i++){
                sb.append(words[i]);
                sb.append(" ");
            }
            list.add(sb.toString().trim());
            start = index;
        }
        return list;

    }

    private long fullJustify(String[] words, int maxWidth, int start, int end) {
        String line = "";
        if(cache.containsKey(start+"-"+end)){
            return cache.get(start+"-"+end);
        }
        if(start == end){
            String key = start+"-"+end;
            long min = badness(words, start, start, maxWidth);
            cache.put(key, min);
            return min;
        }
        long min = Long.MAX_VALUE;
        for(int i = start; i < end; i++){
            line = line + words[i] + " ";
            long textJ = fullJustify(words, maxWidth, i + 1, end);
            long badness = badness(words, start,  i+1 , maxWidth);
            long textJustification = textJ + badness;
            if(textJustification < min){
                min = textJustification;
            }
        }
        String key = start+"-"+end;
        cache.put(key, min);
        return min;
    }

    private long badness(String[] words, int startIndex, int endIndex, int maxWidth){
        if(badnessCache.containsKey(startIndex+"-"+endIndex)){
            return badnessCache.get(startIndex+"-"+endIndex);
        }
        String line = "";
        for(int i = startIndex ; i < endIndex; i++){
            line = line + words[i] + " ";
        }
        line = line.trim();
        if(maxWidth - line.length() < 0){
            badnessCache.put(startIndex+"-"+endIndex, (long) (maxWidth*maxWidth));
            return maxWidth*maxWidth;
        }else{
            badnessCache.put(startIndex+"-"+endIndex, (long) (maxWidth - line.length()) * (maxWidth - line.length()));
            return (maxWidth - line.length()) * (maxWidth - line.length());
        }

    }
}
