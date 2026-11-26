import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
    static int l,r,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l  = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            char[][][] tower = new char[l+1][r+1][c+1];
            boolean[][][] visited = new boolean[l+1][r+1][c+1];

            int startL, startR, startC, endL, endR, endC;
            startL = startR = startC = endL = endR = endC = -1;

            for(int i = 1; i < l+1; i++){
                for(int j = 1; j < r+1; j++){
                    String s = br.readLine();
                    for(int k = 1; k < c+1; k++){
                        char cur =  s.charAt(k-1);
                        if(cur == 'S'){
                            startL = i;
                            startR = j;
                            startC = k;
                        }else if(cur == 'E'){
                            endL = i;
                            endR = j;
                            endC = k;
                        }
                        tower[i][j][k] = cur;
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{startL, startR,startC,0});
            visited[startL][startR][startC] = true;

            int answer = -1;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curL = cur[0];
                int curR = cur[1];
                int curC = cur[2];
                int dist = cur[3];

                if(curL == endL && curR == endR && curC == endC){
                    answer = dist;
                    break;
                }

                for(int[] move: moves){
                    int nl = curL+move[0];
                    int nr = curR+move[1];
                    int nc = curC+move[2];

                    if(inRange(nl, nr, nc) && !visited[nl][nr][nc] && tower[nl][nr][nc] != '#'){
                        visited[nl][nr][nc] = true;
                        queue.add(new int[]{nl, nr, nc, dist+1});
                    }

                }

            }
            if(answer == -1) System.out.println("Trapped!");
            else System.out.printf("Escaped in %d minute(s).\n", answer);


        }

    }
    static boolean inRange(int x, int y, int z){
        if(x < 1 || y < 1|| z < 1 || x > l || y > r || z > c) return false;
        return true;
    }


}