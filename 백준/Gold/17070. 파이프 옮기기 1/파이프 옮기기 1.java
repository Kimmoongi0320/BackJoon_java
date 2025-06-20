import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int answer = 0;
    static int[][]board;
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," " );
            for (int j = 1; j < n+1; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,2,0);
        System.out.println(answer);

    }

    static void dfs(int x, int y,int dir){
        //0 가로 1 세로 2 대각
        if (x>n || y > n|| board[x][y] == 1){
            return;
        }
        //대각으로 들어왔는데 장애물이 있는 경우
        if (dir == 2){
            if (board[x-1][y] == 1 || board[x][y-1] == 1){
                return;
            }
        }
        if (x==n && y == n){
            answer++;
            return;
        }
        if (dir == 0) {
            dfs(x,y+1,0);
            dfs(x+1,y+1,2);
        } else if (dir == 1) {
            dfs(x+1,y,1);
            dfs(x+1,y+1,2);
        }else{
            dfs(x+1,y,1);
            dfs(x,y+1,0);
            dfs(x+1,y+1,2);
        }
    }
}
