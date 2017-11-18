package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhizha on 11/4/17.
 */
public class WordSearch123 {

    public static void main(String[] arg){
        WordSearch123 wordSearch123 = new WordSearch123();
        wordSearch123.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");
    }
    /*
    * @param board: A list of lists of character
    * @param word: A string
    * @return: A boolean
    */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        Set<String> cache = new HashSet<>();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(board, i, j, word, cache)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, Set<String> parents){
        if(word == null || word.equals("")){
            return true;
        }
        if(i<0 || i >= board.length){
            return false;
        }
        if(j<0 || j >= board[i].length){
            return false;
        }


            if(board[i][j] == word.charAt(0)) {
                parents.add(i+","+j);
                if (!parents.contains((i + 1) + "," + j)) {
                    if(find(board, i + 1, j, word.substring(1), parents)){
                        return true;
                    }
                }

                if (!parents.contains((i - 1) + "," + j)) {
                    if(find(board, i - 1, j, word.substring(1), parents)){
                        return true;
                    }
                }

                if (!parents.contains((i) + "," + (j + 1))) {
                    if(find(board, i, j+1, word.substring(1), parents)){
                        return true;
                    }
                }

                if (!parents.contains((i) + "," + (j - 1))) {
                    if(find(board, i, j-1, word.substring(1), parents)){
                        return true;
                    }
                }
                parents.remove(i+","+j);
            }else {
               return false;
            }

        return false;
    }
}
