import java.util.*;
class Solution {
    static int n,m;
    static boolean[][] visited;
    static int answer = 0;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[] maps) {
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        n = maps.length;
        m = maps[0].length();
        
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0 ; j < maps[0].length(); j++){
                char cur = maps[i].charAt(j);
                if(cur == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if (cur == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }else if(cur == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        if(!canArrive(start,lever,maps)) return -1;
        visited = new boolean[maps.length][maps[0].length()];
        if(!canArrive(lever,exit,maps)) return -1;
        
        return answer;
    }
    static boolean canArrive(int[] from, int[] to, String[] maps){
        visited[from[0]][from[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{from[0],from[1],0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            
            if(x == to[0] && y == to[1]){
                answer += time;
                return true;
            }
            
            for(int[] move: moves){
                int nx = x + move[0];
                int ny = y + move[1];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,time+1});
                }
            }
        }
        
        return false;
    }
}