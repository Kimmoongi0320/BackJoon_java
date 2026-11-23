import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        int n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        printStar(0,0,n);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    static void printStar(int x,int y, int length){
        if(length == 3){
            for(int i = x; i < x+3; i++){
                for(int j = y; j < y+3; j++){
                    if(i == x+1 && j == y+1)continue;
                    board[i][j] = true;
                }
            }
            return;
        }

        int len = length/3;
        for(int i =0; i <3; i++){
            for(int j = 0; j <3; j++){
                if(i == 1 && j == 1) continue;
                printStar(x+i*len,y+j*len,len);
            }
        }

    }

}