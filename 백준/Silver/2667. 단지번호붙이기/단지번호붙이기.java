import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int[][] board;
    static int[][] visited;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new int[n][n];

        for (int i = 0 ; i < n ; i ++){
            String line = br.readLine();
            for (int j = 0 ; j < n ; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }
        List<Integer> counts = new ArrayList<>();
        int danji = 0;

        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == 1 && visited[i][j] == 0){
                    danji += 1;
                    int count = 0;
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i,j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()){
                        Point current = queue.poll();
                        count += 1;
                        for (int[] move: moves){
                            int nextX = current.x + move[0];
                            int nextY = current.y + move[1];

                            if (nextX <0 || nextY < 0 || nextX >= n || nextY >=n) continue;
                            if (visited[nextX][nextY] == 1) continue;
                            if (board[nextX][nextY] != 1) continue;

                            queue.add(new Point(nextX,nextY));
                            visited[nextX][nextY] = 1;
                        }
                    }
                    counts.add(count);
                }
            }
        }
//        counts.sort(Comparator.naturalOrder());
        Collections.sort(counts);
        System.out.println(danji);

        for (int i : counts){
            System.out.println(i);
        }
    }



}
