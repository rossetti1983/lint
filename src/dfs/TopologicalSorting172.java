package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 10/11/17.
 */
public class TopologicalSorting172 {

    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
        public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if(graph == null || graph.size() == 0){
            return new ArrayList<DirectedGraphNode>();
        }
        ArrayList<DirectedGraphNode> res = new  ArrayList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(indegree.containsKey(neighbor)){
                    indegree.put(neighbor, indegree.get(neighbor)+1);
                }else{
                    indegree.put(neighbor, 1);
                }
            }
        }
        for(DirectedGraphNode node : graph){
            if(!indegree.containsKey(node)){
                dfs(res, indegree, node);
            }
        }
        return res;
    }

    private void dfs(ArrayList<DirectedGraphNode> res, Map<DirectedGraphNode, Integer> indegree, DirectedGraphNode node) {
        res.add(node);
        for(DirectedGraphNode neighbor : node.neighbors){
            indegree.put(neighbor, indegree.get(neighbor)-1);
            if(indegree.get(neighbor) == 0){
                dfs(res, indegree, neighbor);
            }
        }
    }
    private static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };

}



