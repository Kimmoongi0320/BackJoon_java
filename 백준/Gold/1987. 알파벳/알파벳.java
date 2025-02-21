import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static char[][] board;
    static Set<Character> visited;
    static int answer = 1;
    static int r,c;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r;i++){
            String line = br.readLine();
            for (int j = 0 ; j < c;j++){
                board[i][j] = line.charAt(j);
            }
        }

        visited = new HashSet<>();
        DFS(0,0,1);
        System.out.print(answer);

    }

    public static void DFS(int currentX, int currentY,int count){
        visited.add(board[currentX][currentY]);
        if (count > answer) answer = count;

        for (int[] move : moves){
            int nextX = currentX + move[0];
            int nextY = currentY + move[1];

            if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
            if (!visited.contains(board[nextX][nextY])){
                DFS(nextX,nextY,count+1);
            }
        }
        visited.remove(board[currentX][currentY]);
    }



}
