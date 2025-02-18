import java.awt.*;
import  java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] RGboard = new char[n][n];
        char[][] RGBboard = new char[n][n];
        int[][] visited = new int[n][n];

        for (int i = 0 ; i < n; i++){
            String line =  br.readLine();
            for (int j = 0; j<n;j++){
                char point = line.charAt(j);
                RGBboard[i][j] = point;
                if (point == 'G'){
                    RGboard[i][j] = 'R';
                }else RGboard[i][j] = line.charAt(j);
            }
        }
        int RGcount = 0;
        for (int i = 0 ; i < n; i++){
            for (int j = 0; j<n;j++){
                if (visited[i][j] == 1) continue;
                Queue<Point> queue = new ArrayDeque<>();
                char startChar = RGboard[i][j];
                visited[i][j] = 1;
                queue.add(new Point(i,j));

                while (!queue.isEmpty()){
                    Point current = queue.poll();
                    for (int[] move: moves){
                        int nextX = current.x + move[0];
                        int nextY = current.y + move[1];
                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                        if (visited[nextX][nextY] != 0) continue;
                        if (RGboard[nextX][nextY] != startChar) continue;

                        queue.add(new Point(nextX,nextY));
                        visited[nextX][nextY] = 1;
                    }
                }
                RGcount += 1;

            }
        }
        int RGBcount = 0;
        visited = new int[n][n];
        for (int i = 0 ; i < n; i++){
            for (int j = 0; j<n;j++){
                if (visited[i][j] == 1) continue;
                Queue<Point> queue = new ArrayDeque<>();
                char startChar = RGBboard[i][j];
                visited[i][j] = 1;
                queue.add(new Point(i,j));

                while (!queue.isEmpty()){
                    Point current = queue.poll();
                    for (int[] move: moves){
                        int nextX = current.x + move[0];
                        int nextY = current.y + move[1];
                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                        if (visited[nextX][nextY] != 0) continue;
                        if (RGBboard[nextX][nextY] != startChar) continue;

                        queue.add(new Point(nextX,nextY));
                        visited[nextX][nextY] = 1;
                    }
                }
                RGBcount += 1;

            }
        }
        System.out.print(RGBcount+" "+RGcount);
    }



}
