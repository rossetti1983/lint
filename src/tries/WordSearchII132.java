package tries;

import java.util.*;

/**
 * Created by zhizha on 10/28/17.
 */
public class WordSearchII132 {


    public static void main(String[] arg){
     WordSearchII132 wordSearchII132 = new WordSearchII132();
     char[][] board = new char[][]{{'a','a','a'},{'a','b','b'},{'a','b','b'},{'b','b','b'},{'b','b','b'},
             {'a','a','a'},{'b','b','b'},{'a','b','b'},{'a','a','b'},{'a','b','a'}};
     List<String> words = Arrays.asList("aabaaaabbb","c","d","e","f","i","zz","zzz","zzzzz","zzzzzz","zzzzzzzz","zzzzzzz","aaabbaabbbbbbbbaaabbbc","aaabbaabbbbbbbbaaabbbd","aaabbaabbbbbbbbaaabbbe");
     wordSearchII132.wordSearchII(board, words);
    }
    /*
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0){
            return res;
        }

        WordDictionary wordDictionary = new WordDictionary();
        for(String s: words){
            wordDictionary.addWord(s);
        }
        Set<String> resSet = new HashSet<>();
        Set<String> parentIndex = new HashSet<>();
        TrieNode root = wordDictionary.root;
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(root.children.containsKey(board[i][j])){
                    dfs(board, i, j, parentIndex, resSet, root.children.get(board[i][j]), new StringBuffer().append(board[i][j]));
                }
            }
        }

        for(String s:resSet){
            res.add(s);
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, Set<String> parentIndex, Set<String> resSet, TrieNode root, StringBuffer sb) {
        int m = board.length;
        int n = board[i].length;
        parentIndex.add(i+"-"+j);


        if(root.endNode){
            resSet.add(sb.toString());
        }

        if(i>=0 && i< board.length-1){
          if(!parentIndex.contains((i+1) + "-" + j)) {
              if(root.children.containsKey(board[i+1][j])) {
                  dfs(board, i + 1, j, parentIndex, resSet, root.children.get(board[i+1][j]), new StringBuffer(sb).append(board[i+1][j]));
              }
          }
        }

        if(i>0 && i<=board.length-1){
            if(!parentIndex.contains((i-1) + "-" + j)) {
                if(root.children.containsKey(board[i-1][j])) {
                    dfs(board, i - 1, j, parentIndex, resSet, root.children.get(board[i-1][j]), new StringBuffer(sb).append(board[i-1][j]));
                }
            }
        }

        if(j >= 0 && j < board[i].length-1){
            if(!parentIndex.contains((i) + "-" + (j+1))) {
                if(root.children.containsKey(board[i][j+1])) {
                    dfs(board, i, j + 1, parentIndex, resSet, root.children.get(board[i][j+1]), new StringBuffer(sb).append(board[i][j+1]));
                }
            }
        }

        if(j>0 && j <= board[i].length-1){
            if(!parentIndex.contains((i) + "-" + (j-1))) {
                if(root.children.containsKey(board[i][j-1])) {
                    dfs(board, i, j - 1, parentIndex, resSet, root.children.get(board[i][j-1]), new StringBuffer(sb).append(board[i][j-1]));
                }
            }
        }
        parentIndex.remove(i+"-"+j);
    }

    private static class TrieNode {

        Map<Character, TrieNode> children;
        boolean endNode = false;

        TrieNode(){
            children = new HashMap<>();
        }

    }

    private static class WordDictionary {

        TrieNode root;

        WordDictionary() {
            root = new TrieNode();
        }


        /*
         * @param word: Adds a word into the data structure.
         * @return: nothing
         */
        public void addWord(String word) {
            // write your code here
            TrieNode head = root;
            for (int i = 0; i < word.length(); i++) {
                if (head.children.containsKey(word.charAt(i))) {
                    head = head.children.get(word.charAt(i));
                } else {
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

        private boolean search(String word, TrieNode root) {
            if (root == null) {
                return false;
            }

            if (word == null || word.equals("")) {
                return root.endNode;
            }

            if (word.charAt(0) != '.') {
                if (root.children.containsKey(word.charAt(0))) {
                    return search(word.substring(1), root.children.get(word.charAt(0)));
                } else {
                    return false;
                }
            } else {
                for (Character c : root.children.keySet()) {
                    if (search(word.substring(1), root.children.get(c))) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

}
