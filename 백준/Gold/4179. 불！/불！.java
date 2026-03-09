import java.util.*;
import java.io.*;

public class Main {
    static int r,c;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static boolean[][] visited;
    static int[][] fireTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        fireTime = new int[r][c];
        for(int i = 0 ; i < r; i++) Arrays.fill(fireTime[i],Integer.MAX_VALUE);

        int[] startPos = null;
        for(int i = 0 ; i < r; i++){
            String line = br.readLine();
            for(int j = 0 ; j < c; j++){
                char cur = line.charAt(j);
                if(cur == 'J') startPos = new int[]{i,j};
                else if(cur == 'F') fireTime[i][j] = 0;

                map[i][j] = cur;
            }
        }

        fillFire();

        int answer = -1;

        Queue<int[]> queue = new LinkedList<>();
        visited[startPos[0]][startPos[1]] = true;
        queue.add(new int[]{startPos[0],startPos[1],0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == 0 || cur[1] == 0 || cur[0] == r-1 || cur[1] == c-1){
                answer = cur[2] + 1;
                break;
            }

            for(int[] move: moves){
                int nx = cur[0] + move[0];
                int ny = cur[1] + move[1];
                int time = cur[2];

                if(!inMap(nx,ny)) continue;
                if(map[nx][ny] == '#' || visited[nx][ny]) continue;
                if(fireTime[nx][ny] <= time+1) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,time+1});
            }
        }

        if(answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }

    static void fillFire(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c; j++){
                if(map[i][j] == 'F') queue.add(new int[]{i,j});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] move : moves){
                int nx = cur[0] + move[0];
                int ny = cur[1] + move[1];

                if(!inMap(nx,ny)) continue;
                if(map[nx][ny] == '#' || fireTime[nx][ny] != Integer.MAX_VALUE) continue;
                fireTime[nx][ny] = fireTime[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nx,ny});
            }
        }
    }

    static boolean inMap(int x, int y){
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}