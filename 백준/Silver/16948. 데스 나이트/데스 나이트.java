import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] moves = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st=  new StringTokenizer(br.readLine());
        int startX =  Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX =  Integer.parseInt(st.nextToken());
        int endY =  Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n+1][n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY,0});

        int answer = -1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(x == endX && y == endY) {
                answer = count;
                break;
            }

            for(int[] move:  moves){
                int nx = x + move[0];
                int ny = y + move[1];

                if(inRange(nx,ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny,count+1});
                }
            }

        }

        System.out.print(answer);

    }

    static boolean inRange(int x, int y){
        if(x < 0 || y < 0 || x>= n || y >= n) return false;
        return true;
    }



}