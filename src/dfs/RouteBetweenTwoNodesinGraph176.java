package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 11/6/17.
 */
public class RouteBetweenTwoNodesinGraph176 {

    private static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    ;


    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {

        if(s==t){
            return true;
        }

        List<DirectedGraphNode> frontier = new ArrayList<>();
        Set<DirectedGraphNode> visit = new HashSet<>();
        frontier.add(s);
        visit.add(s);

        while(!frontier.isEmpty()){
            List<DirectedGraphNode> next = new ArrayList<>();
            for(DirectedGraphNode node:frontier){
                for(DirectedGraphNode neighbor:node.neighbors){
                    if(!visit.contains(neighbor)) {
                        if (neighbor == t) {
                            return true;
                        } else {
                            visit.add(neighbor);
                            next.add(neighbor);
                        }
                    }
                }
            }

            frontier = next;
        }

        return false;
        // write your code here
    }

}
