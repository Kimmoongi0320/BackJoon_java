import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0;j < m; j++){
                board[i][j] = line.charAt(j);
            }
        }

        answer = Integer.MAX_VALUE;
        for(int x = 0; x <= n-8; x++){
            for(int y = 0; y <= m-8; y++){
                countChange(x,y);
                if (answer == 0){
                    System.out.print(answer);
                    return;
                }
            }
        }

        System.out.print(answer);
    }

    static void countChange(int x, int y){
        char startColor = board[x][y];


        int count = 0;
        //시작 지점 그대로 할 경우
        for(int startX = x; startX < x+8; startX++){
            for(int startY = y; startY < y+8; startY++){
                if((startX+startY)%2 == 0){
                    if (board[startX][startY] != startColor){
                        count++;
                    }
                }else{
                    if (board[startX][startY] == startColor){
                        count++;
                    }
                }
            }
        }

        answer = Integer.min(answer,count);

        count = 0;
        //시작 지점 바꿀 경우
        for(int startX = x; startX < x+8; startX++){
            for(int startY = y; startY < y+8; startY++){
                if((startX+startY)%2 == 0){
                    if (board[startX][startY] == startColor){
                        count++;
                    }
                }else{
                    if (board[startX][startY] != startColor){
                        count++;
                    }
                }
            }
        }

        answer = Integer.min(answer,count);
    }
}