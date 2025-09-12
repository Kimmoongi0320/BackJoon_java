import java.awt.*;
import java.io.*;
import java.util.*;

public class Main{
    static int[][] board;
    static int answer = 0;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0,0);

        System.out.println(answer);
    }

    public static void backTracking(int count,int startX){
        if (count == 3){
            bfs();
        }else{
            for (int i = startX; i<board.length; i++){
                for (int j =0; j<board[0].length; j++){
                    if (board[i][j] == 0){
                        board[i][j] = 1;
                        backTracking(count+1,i);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    public static void bfs(){
        int[][] copyBoard = new int[board.length][board[0].length];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i<board.length; i++){
            for (int j =0; j<board[0].length; j++){
                copyBoard[i][j] = board[i][j];
                if (copyBoard[i][j] == 2){
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()){
            Point current = queue.poll();

            for (int[]move:moves){
                int x = current.x + move[0];
                int y = current.y + move[1];

                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                    if (copyBoard[x][y] == 0){
                        copyBoard[x][y] = 2;
                        queue.add(new Point(x, y));
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                if (copyBoard[i][j] == 0){
                    safe++;
                }
            }
        }

        answer = Integer.max(safe,answer);

    }
    }
