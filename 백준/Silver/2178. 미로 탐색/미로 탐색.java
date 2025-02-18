import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int[][] board;
    static int[][] visited;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    static int m;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];
        int currentX = 0;
        int currentY = 0;
        visited[currentX][currentY] = 1;


        for(int i = 0; i<n;i++){
            String line = br.readLine();
            for (int j =  0; j < line.length();j++){
                if (line.charAt(j) == '1'){
                    board[i][j] = 1;
                }
            }
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(currentX,currentY));

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            for (int[]move: moves){
                int nextX = currentPoint.x + move[0];
                int nextY = currentPoint.y + move[1];

                if (nextX<0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (board[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY] != 0) continue;
                queue.add(new Point(nextX,nextY));
                visited[nextX][nextY] = visited[currentPoint.x][currentPoint.y] + 1;

            }
        }

        System.out.print(visited[n-1][m-1]);


    }



}
