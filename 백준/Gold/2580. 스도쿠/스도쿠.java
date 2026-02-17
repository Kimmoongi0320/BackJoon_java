import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[9][9];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSudoku(0,0);
    }

    static boolean makeSudoku(int row,int col){
        if(col == 9){
            return makeSudoku(row+1,0);
        }

        if(row == 9){
            for(int i = 0; i < 9; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < 9; j++){
                    sb.append(board[i][j]).append(" ");
                }
                System.out.println(sb.toString());
            }
            return true;
        }

        if(board[row][col] == 0){
            for(int i = 1; i < 10; i++){
                if(canFill(row,col,i)){
                    board[row][col] = i;
                    if(makeSudoku(row, col + 1)) return true;
                }
            }
            board[row][col] = 0;
            return false;
        }

        return makeSudoku(row,col+1);

    }

    static boolean canFill(int row, int col,int num){

        for(int i = 0 ; i < 9; i++){
            if(board[row][i] == num) return false;
        }
        for(int i = 0 ; i < 9; i++){
            if(board[i][col] == num) return false;
        }

        int squareRow = (row / 3) * 3;
        int squareCol = (col / 3) * 3;

        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if (board[squareRow+i][squareCol+j] == num) return false;
            }
        }

        return true;
    }


}