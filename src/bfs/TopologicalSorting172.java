package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<DirectedGraphNode> frontier = new ArrayList<>();
        for(DirectedGraphNode node : graph){
            if(!indegree.containsKey(node)){
                frontier.add(node);
            }
        }

        while(!frontier.isEmpty()){
            List<DirectedGraphNode> nextF = new ArrayList<>();
            for(DirectedGraphNode node : frontier){
                res.add(node);
                for(DirectedGraphNode subNode: node.neighbors){
                    indegree.put(subNode, indegree.get(subNode)-1);
                    if(indegree.get(subNode) == 0){
                        nextF.add(subNode);
                    }
                }
            }
            frontier = nextF;
        }

        return res;
    }

        private static class DirectedGraphNode {
            int label;
            ArrayList<DirectedGraphNode> neighbors;
            DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
        };
    }
