import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] map,visited;
    static int answer = 0;
    static int distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new boolean[r][c];
        visited = new boolean[r][c];

        for(int i= 0; i < r; i++){
            String s = br.readLine();
            for(int j = 0; j < c; j++){
                char cur = s.charAt(j);
                if(cur == 'L') map[i][j] = true;
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j]){
                    visited = new boolean[r][c];
                    visited[i][j] = true;
                    distance = 0;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i,j,0});

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        int dist = cur[2];

                        distance = Math.max(distance, dist);

                        for(int[] move : moves){
                            int nx = x + move[0];
                            int ny = y + move[1];

                            if(inRange(nx,ny) && map[nx][ny] && !visited[nx][ny]){
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx,ny,dist+1});
                            }
                        }
                    }

                    answer = Math.max(answer, distance);
                }
            }
        }
        System.out.print(answer);

    }


    static boolean inRange(int x, int y){
        if(x < 0 || y < 0 || x >=r || y >= c) return false;
        return true;
    }

}