package stack;

import java.util.Stack;

/**
 * Created by zhizha on 10/15/17.
 * "/home/", => "/home"

 "/a/./b/../../c/", => "/c"

 Challenge
 Did you consider the case where path = "/../"?

 In this case, you should return "/".

 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".

 In this case, you should ignore redundant slashes and return "/home/foo".


 */
public class SimplifyPath421 {


    public static void main(String[] arg){
        SimplifyPath421 simplifyPath421 = new SimplifyPath421();
        simplifyPath421.simplifyPath("/abc/...");
    }
    /*
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        if(path == null || path.trim().equals("")){
            return "/";
        }

        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        int len = paths.length;
        int i = 1;
        while(i < len){
            if(paths[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(paths[i].equals(".")){
            }else{
                if(paths[i] == null || paths[i].equals("")){
                }else {
                    stack.push(paths[i]);
                }
            }
            i++;

        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0,"/" + stack.pop());
        }

        return sb.toString().equals("")?"/":sb.toString();
    }
}
