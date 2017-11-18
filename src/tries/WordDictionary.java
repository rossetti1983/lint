package tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 10/28/17.
 */
public class WordDictionary {

    TrieNode root;

    WordDictionary(){
        root = new TrieNode();
    }

    private static class TrieNode {

        Map<Character, TrieNode> children;
        boolean endNode = false;

        TrieNode(){
            children = new HashMap<>();
        }

    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        TrieNode head = root;
        for(int i = 0; i< word.length(); i++){
             if(head.children.containsKey(word.charAt(i))){
                head = head.children.get(word.charAt(i));
            }else{
                head.children.put(word.charAt(i), new TrieNode());
                head = head.children.get(word.charAt(i));
            }
        }
        head.endNode = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode head = root;
        return search(word, head);
    }

    private boolean search(String word, TrieNode root){
        if(root == null){
            return false;
        }

        if(word == null || word.equals("")){
            return root.endNode;
        }

        if(word.charAt(0) != '.'){
            if(root.children.containsKey(word.charAt(0))){
                return search(word.substring(1), root.children.get(word.charAt(0)));
            }else{
                return false;
            }
        }else{
            for(Character c : root.children.keySet()){
                if(search(word.substring(1), root.children.get(c))){
                    return true;
                }
            }
            return false;
        }
    }
}