import java.util.*;
import java.io.*;

public class Main {
    static int[][] board = new int[10][10];
    static boolean[][] checked = new boolean[10][10];
    static int[] used = new int[6];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 10; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0,0,0);
        if(answer == Integer.MAX_VALUE){
            System.out.println("-1");
            return;
        }
        System.out.print(answer);

    }
    static void backTracking(int x, int y,int count){
        if(x == 10) {  // x가 10이 되면 모든 칸 처리 완료
            answer = Integer.min(answer, count);
            return;
        }
        
        if(answer <= count) return;

        if(y > 9){
            backTracking(x+1,0,count);
            return;
        }

        if(board[x][y] == 1 && !checked[x][y]){
            for(int size = 5; size > 0; size--){
                if(used[size] < 5 && checkLength(x,y,size)){
                    covered(x,y,size);
                    used[size]++;
                    backTracking(x,y+1,count+1);
                    used[size]--;
                    uncovered(x,y,size);
                }
            }
        }else{
            backTracking(x,y+1,count);
        }


    }

    static boolean checkLength(int x,int y, int size){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(i >= 10 || j >= 10) return false;
                if(board[i][j] == 0 || checked[i][j]) return false;
            }
        }

        return true;
    }
    static void covered(int x,int y, int size){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                checked[i][j] = true;
            }
        }
    }
    static void uncovered(int x,int y, int size){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                checked[i][j] = false;
            }
        }
    }



}