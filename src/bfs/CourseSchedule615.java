package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhizha on 10/11/17.
 */
public class CourseSchedule615 {

    public static void main(String[] arg){
        CourseSchedule615 courseSchedule615 = new CourseSchedule615();
        int[][] a = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        courseSchedule615.canFinish(10, a);
    }
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if(numCourses==0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }
        int[] inDegree = new int[numCourses];

        List<Integer>[] tmp = new ArrayList[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> edgesFromI = null;
            if(tmp[prerequisites[i][1]] == null){
                edgesFromI = new ArrayList<>();
                tmp[prerequisites[i][1]] = edgesFromI;
            }
            tmp[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> frontier = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                frontier.offer(i);
            }
        }
        if(frontier.isEmpty()){
            return false;
        }


        while(!frontier.isEmpty()){
            int node = frontier.poll();
            boolean[] visit = new boolean[numCourses];
            visit[node] = true;
            List<Integer> verts = tmp[node];
            if(verts!=null) {
                for (Integer vert : verts) {
                    inDegree[vert]--;
                    if (visit[vert]) {
                        return false;
                    } else {
                        visit[vert] = true;
                    }
                    if (inDegree[vert] == 0) {
                        frontier.offer(vert);
                    }
                }
            }
        }

        return true;

    }
}
