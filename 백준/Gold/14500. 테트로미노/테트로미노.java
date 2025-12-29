import java.util.*;
import java.io.*;

public class Main{

    static int answer = 0;
    static int[][] board;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N,M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                DFS(i,j,-1,-1,1,board[i][j]);
                checkT(i,j);
            }
        }

        System.out.println(answer);
    }

    static void DFS(int x, int y,int lastX, int lastY,int count, int sum){
        if(count==4){
            answer = Integer.max(answer,sum);
            return;
        }

        for(int[] move: moves){
            int nx = x+move[0];
            int ny = y+move[1];

            if(nx < 0 || nx > board.length-1 || ny < 0 || ny > board[0].length-1) continue;
            if (nx == lastX && ny == lastY) continue;

            DFS(nx,ny,x,y,count+1,sum+board[nx][ny]);
        }

    }

    static void checkT(int x, int y){
        // ㅗ : 중심 + 위 + 좌 + 우
        if(x > 0 && y > 0 && y < M-1)
            answer = Math.max(answer, board[x][y] + board[x-1][y] + board[x][y-1] + board[x][y+1]);
        // ㅜ : 중심 + 아래 + 좌 + 우
        if(x < N-1 && y > 0 && y < M-1)
            answer = Math.max(answer, board[x][y] + board[x+1][y] + board[x][y-1] + board[x][y+1]);
        // ㅏ : 중심 + 위 + 아래 + 우
        if(x > 0 && x < N-1 && y < M-1)
            answer = Math.max(answer, board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y+1]);
        // ㅓ : 중심 + 위 + 아래 + 좌
        if(x > 0 && x < N-1 && y > 0)
            answer = Math.max(answer, board[x][y] + board[x-1][y] + board[x+1][y] + board[x][y-1]);
    }
}