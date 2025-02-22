import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int[][] board;
    static int n;
    static int m;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;
        int dividedIce = 1;
        while (dividedIce < 2){
            melt();
            dividedIce = divided();
            year += 1;
            if (dividedIce == -1){
                System.out.print(0);
                return;
            }
        }
        System.out.print(year);



    }
    public static void melt(){
        int[][] newBoard = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] != 0){
                    int ice = 0;
                    for (int[] move : moves){
                        int nextX = i + move[0];
                        int nextY = j + move[1];
                        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                        if (board[nextX][nextY] == 0) ice +=1;
                    }
                    if (board[i][j] - ice < 0 ) newBoard[i][j] =0;
                    else newBoard[i][j] = board[i][j] - ice;
                }
            }
        }
        board = newBoard;
    }

    public static int divided(){
        int count = 0;
        int[][] visited = new int[n][m];
        boolean changed = false;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] != 0 && visited[i][j] != 1){
                    changed = true;
                    count += 1;
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i,j));
                    visited[i][j] = 1;

                    while (!queue.isEmpty()){
                        Point current = queue.poll();
                        for (int[] move:moves){
                            int nextX = current.x + move[0];
                            int nextY = current.y + move[1];

                            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                            if (board[nextX][nextY] == 0 || visited[nextX][nextY] == 1 ) continue;
                            queue.add(new Point(nextX,nextY));
                            visited[nextX][nextY] = 1;
                        }
                    }
                }
            }
        }
        if (!changed) return -1;
        return count;
    }



}
