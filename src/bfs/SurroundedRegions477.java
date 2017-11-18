package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 11/12/17.
 */
public class SurroundedRegions477 {

    public static void main(String[] arg){
        SurroundedRegions477 surroundedRegions477 = new SurroundedRegions477();
        surroundedRegions477.surroundedRegions(new char[][]{{'O'}});
    }
    Set<String> visit = new HashSet<>();
    /*
    * @param board: board a 2D board containing 'X' and 'O'
    * @return: nothing
    */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        for(int i=0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(board[i][j] == 'O' && !visit.contains(i+","+j)){
                    bfs(board, i, j);
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        Set<String> visit0 = new HashSet<>();
        boolean surrounded = true;
        if(i == 0 || i == board.length-1 || j == 0 || j == board[i].length-1){
            surrounded = false;
        }

        Pointer source = new Pointer(i, j);
        List<Pointer> frontier = new ArrayList<>();
        visit0.add(i+","+j);
        frontier.add(source);
        while(!frontier.isEmpty()){
            List<Pointer> next = new ArrayList<>();
            for(Pointer node:frontier){
                int x = node.x;
                int y = node.y;
                if(x==0){
                    surrounded = false;
                    int nx = x+1;
                    if(nx<board.length && board[nx][y] == 'O' && !visit0.contains(nx+","+y)){
                        Pointer p = new Pointer(nx, y);
                        visit0.add(nx+","+y);
                        next.add(p);
                    }
                }
                if(x==board.length-1){
                    surrounded = false;
                    int nx = x-1;
                    if(nx>=0 && board[nx][y] == 'O' && !visit0.contains(nx+","+y)){
                        Pointer p = new Pointer(nx, y);
                        visit0.add(nx+","+y);
                        next.add(p);
                    }
                }

                if(x>0 && x<board.length-1){
                    int nx = x+1;
                    if(nx<board.length && nx<board.length && board[nx][y] == 'O' && !visit0.contains(nx+","+y)){
                        Pointer p = new Pointer(nx, y);
                        visit0.add(nx+","+y);
                        next.add(p);
                    }
                    int nx1 = x-1;
                    if(nx1>=0 && board[nx1][y] == 'O' && !visit0.contains(nx1+","+y)){
                        Pointer p = new Pointer(nx1, y);
                        visit0.add(nx1+","+y);
                        next.add(p);
                    }
                }
                if(y==0){
                    surrounded = false;
                    int ny = y+1;
                    if(ny < board[x].length && board[x][ny] == 'O' && !visit0.contains(x+","+ny)){
                        Pointer p = new Pointer(x, ny);
                        visit0.add(x+","+ny);
                        next.add(p);
                    }
                }
                if(y==board[0].length-1){
                    surrounded = false;
                    int ny = y-1;
                    if(ny>=0 && board[x][ny] == 'O' && !visit0.contains(x+","+ny)){
                        Pointer p = new Pointer(x, ny);
                        visit0.add(x+","+ny);
                        next.add(p);
                    }
                }

                if(y>0 && y<board[0].length-1){
                    int ny = y+1;
                    if(ny<board[x].length && ny < board[x].length && board[x][ny] == 'O' && !visit0.contains(x+","+ny)){
                        Pointer p = new Pointer(x, ny);
                        visit0.add(x+","+ny);
                        next.add(p);
                    }
                    int ny1 = y-1;
                    if(ny1 >=0 && board[x][ny1] == 'O' && !visit0.contains(x+","+ny1)){
                        Pointer p = new Pointer(x, ny1);
                        visit0.add(x+","+ny1);
                        next.add(p);
                    }
                }
            }
            frontier = next;
        }

        if(surrounded){
            for(Object s: visit0.toArray()){
                String ss = (String)s;
                String[] po = ss.split(",");
                board[Integer.valueOf(po[0])][Integer.valueOf(po[1])] = 'X';
            }
        }

        visit.addAll(visit0);

    }

    private class Pointer{
        int x,y;
        Pointer(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
