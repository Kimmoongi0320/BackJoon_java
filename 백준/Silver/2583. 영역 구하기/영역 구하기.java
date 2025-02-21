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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for (int j = a; j<c; j++){
                for (int t = b; t < d;t++){
                    board[n-t-1][m-j-1] = 1;
                    visited[n-t-1][m-j-1] = 1;
                }
            }
        }
        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < n; i ++){
            for (int j = 0 ; j < m; j++){
                if (board[i][j] == 0 && visited[i][j] == 0){
                    count += 1;
                    int extent = 1;

                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i,j));
                    visited[i][j] = 1;

                    while(!queue.isEmpty()){
                        Point current = queue.poll();
                        for (int[] move : moves){
                            int nextX = current.x + move[0];
                            int nextY = current.y + move[1];

                            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >=m) continue;
                            if (visited[nextX][nextY] == 1 || board[nextX][nextY] != 0) continue;

                            queue.add(new Point(nextX,nextY));
                            visited[nextX][nextY] =1;
                            extent+=1;
                        }
                    }
                    answer.add(extent);

                }
            }
        }

        Collections.sort(answer);

        System.out.println(count);
        for (int num : answer){
            System.out.print(num +" ");
        }

    }



}
