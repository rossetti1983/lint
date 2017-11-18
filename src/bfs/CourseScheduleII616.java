package bfs;

import java.util.*;

/**
 * Created by zhizha on 11/6/17.
 */
public class CourseScheduleII616 {

    public static void main(String[] arg){
        CourseScheduleII616 courseScheduleII616 = new CourseScheduleII616();
        courseScheduleII616.findOrder(10,new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            adj[course] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        if(queue.isEmpty()){
            return new int[0];
        }
        HashSet<Integer> visit = new HashSet<>();
        int index = 0;

        Integer[] res = new Integer[numCourses];
        queue.toArray(res);
        index = queue.size();

        while(!queue.isEmpty() && visit.size() < numCourses) {
            int s = queue.poll();
            ArrayList<Integer> frontier = new ArrayList<>();
            frontier.add(s);
            visit.add(s);
            outer:
            while (!frontier.isEmpty()) {
                ArrayList<Integer> next = new ArrayList<>();
                for (Integer i : frontier) {
                    for (Integer v : adj[i]) {
                        if (!visit.contains(v)) {
                            visit.add(v);
                            next.add(v);
                            res[index++] = v;
                        }
                    }
                }
                frontier = next;
            }
        }

        int[] res0 = new int[numCourses];
        int ind = 0;
        for(Integer i : res){
            res0[ind++] = i;
        }

        return res0;
    }
}
