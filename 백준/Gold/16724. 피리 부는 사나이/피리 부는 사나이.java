import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] board;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0){
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y){

        visited[x][y] = 1;

        int[] command = direction(board[x][y]);
        int nx = x + command[0];
        int ny = y + command[1];
        if(visited[nx][ny] == 0){
            dfs(nx, ny);
        }else if (visited[nx][ny] == 1){
            answer++;
        }

        visited[x][y] = 2;


    }
    static int[] direction(char command){
        if(command == 'U') return move[0];
        else if(command == 'D') return move[1];
        else if(command == 'L') return move[2];
        else return move[3];
    }
}

