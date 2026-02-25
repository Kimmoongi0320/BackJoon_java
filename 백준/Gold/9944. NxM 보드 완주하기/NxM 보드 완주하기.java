import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int[][] moves = {{1,0},{0,1},{-1,0},{0,-1}};
    static int answer;
    static int blankCount;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        int caseNum = 1;

        while((input = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input," ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            board = new char[n][m];
            visited = new boolean[n][m];

            blankCount = 0;
            for(int i = 0; i < n; i++){
                String line = br.readLine();
                for(int j = 0; j < m; j++){
                    char ch = line.charAt(j);
                    if(ch == '.') blankCount++;
                    board[i][j] = ch;
                }
            }

            answer = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == '.' && !visited[i][j]){
                        visited[i][j] = true;
                        startMove(i,j,0,1);
                        visited[i][j] = false;
                    }
                }
            }
            if (answer == Integer.MAX_VALUE){
                answer = -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case ").append(caseNum).append(": ").append(answer);
            System.out.println(sb.toString());
            caseNum++;
        }
    }

    static void startMove(int x, int y, int moveCount, int fillCount){
        if (moveCount > answer) return;

        if(fillCount == blankCount){
            answer = moveCount;
            return;
        }

        for(int[] move: moves){
            int count = moveDirection(x,y,move);
            if(count > 0){
                int arriveX = x + move[0]*count;
                int arriveY = y + move[1]*count;
                startMove(arriveX, arriveY, moveCount+1, fillCount+count);
            }
            returnMove(x,y,move,count);
        }
    }

    static int moveDirection(int x, int y, int[] direction){
        int count = 0;
        while(true){
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if(nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length || visited[nextX][nextY] || board[nextX][nextY] == '*') return count;
            if(board[nextX][nextY] == '.'){
                visited[nextX][nextY] = true;
                count++;
                x = nextX;
                y = nextY;
            }
        }
    }

    static void returnMove(int x, int y, int[] direction, int count){
        for(int i = 0 ; i < count ; i++){
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            visited[nextX][nextY] = false;
            x = nextX;
            y = nextY;
        }
    }

}
