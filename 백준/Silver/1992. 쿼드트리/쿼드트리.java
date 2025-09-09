import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0 ; i < n ; i++){
            String line = br.readLine();
            for (int j = 0 ; j  <n ; j++){

                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        StringBuilder sb = new StringBuilder();

        divide(0,0,n,sb);

        System.out.println(sb);


    }

    static void divide(int x, int y, int size,StringBuilder sb){
        int start = board[x][y];

        for (int i = x; i < x+ size; i++){
            for (int j = y; j < y+size; j++){
                if (board[i][j] != start){
                    sb.append("(");
                    divide(x,y,size/2,sb);
                    divide(x,y+size/2,size/2,sb);
                    divide(x+size/2,y,size/2,sb);
                    divide(x+size/2,y+size/2,size/2,sb);
                    sb.append(")");
                    return;
                }
            }
        }

        if (start ==1){
            sb.append(1);
        } else {
            sb.append(0);
        }

    }
}
