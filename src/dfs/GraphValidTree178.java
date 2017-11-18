package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/12/17.
 */
public class GraphValidTree178 {

    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    boolean[] visit ;
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        visit = new boolean[n];
        parent = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0 ; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length ; i++){
            if(adj[edges[i][0]] != null){
                adj[edges[i][0]].add(edges[i][1]);
            }else{
                List<Integer> a = new ArrayList<>();
                a.add(edges[i][1]);
                adj[edges[i][0]] = a;
            }

            if(adj[edges[i][1]] != null){
                adj[edges[i][1]].add(edges[i][0]);
            }else{
                List<Integer> a = new ArrayList<>();
                a.add(edges[i][0]);
                adj[edges[i][1]] = a;
            }
        }



        if(!visit[0]){
            visit[0] = true;
            if(!dfsVisit(0, adj)){
                return false;
            }
        }

        for(int i = 0 ; i < n; i++){
            if(!visit[i]){
                return false;
            }
        }

        return true;
    }

    private boolean dfsVisit(int i, List<Integer>[] adj) {
        if(adj[i].size() == 0){
            return false;
        }
        for(Integer v : adj[i]){
            if(parent[i] != v){
                if(visit[v]){
                    return false;
                }else{
                    parent[v] = i;
                    visit[v] = true;
                    dfsVisit(v, adj);
                }
            }
        }
        return true;
    }


}
