import java.awt.*;
import  java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static int MAX = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[h][n][m];
        int[][][] visited = new int[h][n][m];

        int answer = 0;

        Queue<Integer[]> queue = new ArrayDeque<>();
        for (int i = 0 ; i < h ; i++){
            for (int j = 0 ; j < n; j++){
                st = new StringTokenizer(br.readLine()," ");
                for (int k = 0; k < m; k++){
                    int point = Integer.parseInt(st.nextToken());
                    if (point == 1){
                        queue.add(new Integer[]{i,j,k});
                        visited[i][j][k] = 1;
                    } else if (point == -1) {
                        visited[i][j][k] = MAX;
                    }
                    tomatoes[i][j][k] = point;
                }
            }
        }

        while (!queue.isEmpty()){
            Integer[] point = queue.poll();
            int currentH = point[0];
            int currentX = point[1];
            int currentY = point[2];

            for (int[] move : moves){
                int nextH = currentH + move[0];
                int nextX = currentX + move[1];
                int nextY = currentY + move[2];
                if (nextH < 0 || nextY < 0 || nextX < 0 || nextH >= h || nextX >= n || nextY >= m) continue;
                if (visited[nextH][nextX][nextY] != 0) continue;
                if (tomatoes[nextH][nextX][nextY] != 0) continue;

                visited[nextH][nextX][nextY] = visited[currentH][currentX][currentY] + 1;
                tomatoes[nextH][nextX][nextY] = 1;
                queue.add(new Integer[]{nextH,nextX,nextY});
            }

        }
        int max = 0;
        for (int i = 0 ; i < h ; i++){
            for (int j = 0 ; j < n; j++){
                for (int k = 0; k < m; k++){
                    int point = visited[i][j][k];
                    if (point == 0){
                        System.out.print(-1);
                        return;
                    } else if (point != MAX && point > max) {
                        max = point;
                    }
                }
            }
        }
        System.out.print(max-1);


    }



}
