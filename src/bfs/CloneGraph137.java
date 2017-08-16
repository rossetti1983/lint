package bfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhizha on 8/13/17.
 */
public class CloneGraph137 {

    Map<UndirectedGraphNode, Integer> level = new HashMap<>();
    Map<Integer, UndirectedGraphNode> cloneMap = new HashMap<>();
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null || node.neighbors == null || node.neighbors.size() == 0){
            return node;
        }
        List<UndirectedGraphNode> frontier = new ArrayList<>();
        frontier.add(node);
        int lev = 1;
        level.put(node, 0);
        while(frontier != null && frontier.size() > 0){
            List<UndirectedGraphNode> newFrontier = new ArrayList<>();
            for(UndirectedGraphNode node0 : frontier){
                for(UndirectedGraphNode node1 : node0.neighbors){
                    if(!level.containsKey(node1)){
                        level.put(node1, lev);
                        newFrontier.add(node1);
                    }
                }
                cloneMap.put(node0.label, new UndirectedGraphNode(node0.label));
            }
            lev++;
            frontier = newFrontier;
        }

        frontier.add(node);
        lev = 1;
        level = new HashMap<>();
        level.put(node, 0);
        while(frontier != null && frontier.size() > 0){
            List<UndirectedGraphNode> newFrontier = new ArrayList<>();
            for(UndirectedGraphNode node0 : frontier){
                for(UndirectedGraphNode node1 : node0.neighbors){
                    if(!level.containsKey(node1)){
                        level.put(node1, lev);
                        newFrontier.add(node1);
                    }
                    if(cloneMap.get(node0.label).neighbors == null){
                        cloneMap.get(node0.label).neighbors = new ArrayList<UndirectedGraphNode>();
                    }
                    cloneMap.get(node0.label).neighbors.add(cloneMap.get(node1.label));
                }
            }
            lev++;
            frontier = newFrontier;
        }
        return cloneMap.get(node.label);
    }
}

class UndirectedGraphNode {
    int label;

    @Override
    public boolean equals(Object o) {
        UndirectedGraphNode that = (UndirectedGraphNode) o;
        return label == that.label;
    }

    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

};
