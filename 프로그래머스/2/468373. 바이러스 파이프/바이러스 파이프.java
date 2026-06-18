import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] visited;
    static List<List<Integer>> A = new ArrayList<>();
    static List<List<Integer>> B = new ArrayList<>();
    static List<List<Integer>> C = new ArrayList<>();
    public int solution(int n, int infection, int[][] edges, int k) {
        
        for(int i = 0; i < n+1; i++){
            A.add(new ArrayList<>());
            B.add(new ArrayList<>());
            C.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            
            if(type == 1){
                A.get(x).add(y);
                A.get(y).add(x);
            }else if(type == 2){
                B.get(x).add(y);
                B.get(y).add(x);
            }else{
                C.get(x).add(y);
                C.get(y).add(x);
            }
        }
        
        visited = new boolean[n+1];
        visited[infection] = true;
        for(int i =1 ; i <=3; i++){
            backtracking(1,i,k,n);
        }
        
        return answer;
    }
    
    public static void backtracking(int time, int type, int k, int n){
        if(time > k){
            int count = 0;
            for(boolean visit: visited){
                if(visit) count++;
            }
            
            answer = Integer.max(answer,count);
            return;
        }
        
        List<Integer> thisTimeVisited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(visited[i]){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<List<Integer>> selectedEdge = getEdge(type);
            for(int next: selectedEdge.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    thisTimeVisited.add(next);
                }
            }
        }
        
        for(int i = 1; i <=3 ; i++){
            backtracking(time+1, i, k, n);
        }
        
        for(int visit: thisTimeVisited){
            visited[visit] = false;
        }
    }
    
    public static List<List<Integer>> getEdge(int type){
        if(type == 1) return A;
        else if (type == 2) return B;
        else return C;
    }
}