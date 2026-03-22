import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    static int r,c;
    static int[][] board;
    static List<Integer> machinePos = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<c;j++){
                int cur = Integer.parseInt(st.nextToken());
                board[i][j] = cur;

                if(cur == -1){
                    machinePos.add(i);
                }
            }
        }

        for(int i = 0; i < t; i++){
            diffuse();
            moveCircle();
            moveReverseCircle();
        }

        int answer = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] > 0) answer += board[i][j];
            }
        }

        System.out.print(answer);
    }

    static void diffuse(){
        int[][] diffuseCount = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] > 0){
                    diffuseCount[i][j] = board[i][j] /5;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int diffuseDust = diffuseCount[i][j];
                if(diffuseDust > 0){
                    int count = 0;
                    for(int[] move : moves){
                        int nx = i+move[0];
                        int ny = j+move[1];

                        if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                        if(board[nx][ny] == -1)continue;

                        board[nx][ny] += diffuseDust;
                        count++;
                    }
                    board[i][j] -= diffuseDust*count;
                }
            }
        }
    }
    static void moveCircle(){
        int top = machinePos.get(0);

        for(int i = top -1; i > 0; i--){
            board[i][0] = board[i-1][0];
        }
        for(int i = 0; i < c-1;i++){
            board[0][i] =  board[0][i+1];
        }
        for(int i = 0; i < top; i++){
            board[i][c-1] = board[i+1][c-1];
        }
        for(int i = c-1; i > 1; i--){
            board[top][i] =  board[top][i-1];
        }

        board[top][1] = 0;
    }

    static void moveReverseCircle(){
        int bottom = machinePos.get(1);
        for (int x = bottom + 1; x < r - 1; x++) {
            board[x][0] = board[x+1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            board[r-1][y] = board[r-1][y+1];
        }

        for (int x = r - 1; x > bottom; x--) {
            board[x][c-1] = board[x-1][c-1];
        }

        for (int y = c - 1; y > 1; y--) {
            board[bottom][y] = board[bottom][y-1];
        }

        board[bottom][1] = 0;

    }


}