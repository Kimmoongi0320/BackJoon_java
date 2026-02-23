import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 9; i++){
            String line = br.readLine();
            for(int j = 0; j < 9; j++){
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        backTracking(0,0);

    }
    static boolean backTracking(int x, int y){
        if(x == 9){
            printBoard();
            return true;
        }

        if(y == 9){
            return backTracking(x+1,0);
        }

        if(board[x][y] == 0){
            for(int i = 1; i < 10; i++){
                if(canFill(x,y,i)){
                    board[x][y] = i;
                    if(backTracking(x, y+1)) return true;
                    board[x][y] = 0;
                }
            }
            return false;
        }

        return backTracking(x,y+1);
    }

    static void printBoard(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9; j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean canFill(int x, int y, int num){
        for(int i = 0; i < 9; i++){
            if(board[x][i] == num || board[i][y] == num) return false;
        }
        int startX = (x/3) * 3;
        int startY = (y/3) * 3;

        for(int i = startX; i < startX + 3; i++){
            for(int j = startY; j < startY + 3; j++){
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }




}