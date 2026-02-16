import java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{-1,0},{0,-1},{1,0},{0,1}}; // 0:북, 1:서, 2:남, 3:동 반시계 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] cleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine()," ");
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int direction =  Integer.parseInt(st.nextToken());

        if(direction==1){
            direction = 3;
        }else if(direction==3){
            direction = 1;
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean clean = true;

        while(clean){
            if(board[curX][curY]==0 && !cleaned[curX][curY]){
                cleaned[curX][curY] = true;
                answer++;
            }else{
                boolean checkClean = false;
                int directionForCheck = direction; // 4방향 체크를 위한 변수 일단 90도 회전

                for(int i = 0; i < 4; i++){
                    directionForCheck = (directionForCheck+1) %4;

                    int nextX = curX + moves[directionForCheck][0];
                    int nextY = curY + moves[directionForCheck][1];

                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                    if(board[nextX][nextY]==0 && !cleaned[nextX][nextY]){
                        curX = nextX;
                        curY = nextY;
                        checkClean = true;
                        direction = directionForCheck;
                        break;
                    }
                }

                if(!checkClean) {
                    int backX = curX - moves[direction][0];
                    int backY = curY - moves[direction][1];

                    if(backX < 0 || backX >= n || backY < 0 || backY >= m) continue;
                    if(board[backX][backY]==1){
                        clean = false;
                    }else{
                        curX = backX;
                        curY = backY;
                    }
                };

            }
        }

        System.out.print(answer);
    }


}