import java.awt.*;
import  java.util.*;
import java.io.*;


// 백트래킹도 사용 할 수 있지만 500*500 배열로 DP 개념을 병행해야 하는 문제
public class Main {
    static int[][] board;
    static int[][] dp;
    static int n;
    static int m;
    static int answer = 0;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int[n][m];

        for (int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j<m ;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        DFS(0,0);
        System.out.print(dp[0][0]);


    }
    public static int DFS(int currentX, int currentY){
        // 만약 바로 다음 위치가 도착지인 경우 도달하는 방법은 1이므로 1 return
        if (currentX == n-1 && currentY == m-1){
            return 1;
        }
        // 만약 방문을 안한 경우
        if (dp[currentX][currentY] == -1){
            // 방문 처리
            dp[currentX][currentY] = 0;
            //상하좌우 방향으로 DFS 실행
            for (int[] move: moves){
                int nextX = currentX + move[0];
                int nextY = currentY + move[1];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (board[nextX][nextY] < board[currentX][currentY]) {
                    // 상하좌우 위치에서부터 도착지까지 가는 방법의 수를 현재 위치에 더해주는 방식
                    dp[currentX][currentY] += DFS(nextX,nextY);
                }
            }
        }
        return dp[currentX][currentY];
    }

}
