import java.util.*;
import java.io.*;

public class Main {
    static class Shark{
        int x;
        int y;
        int speed;
        int direction;
        int size;

        public Shark(int x,int y,int speed, int direction, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }
    static Shark[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new Shark[R][C];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 이동방향
            int z = Integer.parseInt(st.nextToken()); // 크기

            board[r][c] = new Shark(r,c,s,d,z);
        }

        int answer = 0;
        for(int peoplePos = 0; peoplePos < C; peoplePos++){
            for(int i = 0; i < R; i++){
                if (board[i][peoplePos] != null){
                    answer += board[i][peoplePos].size;
                    board[i][peoplePos] = null;
                    break;
                }
            }

            Queue<Shark> queue = new LinkedList<>();
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(board[i][j] != null){
                        queue.add(board[i][j]);
                        board[i][j] = null;
                    }
                }
            }

            while(!queue.isEmpty()){
                // 1:위 2:아래 3:오른쪽 4:왼쪽
                Shark shark = queue.poll();
                moveShark(shark.x,shark.y,shark);
            }
        }

        System.out.print(answer);
    }

    public static void moveShark(int r, int c, Shark shark){
        int speed = shark.speed;
        int direction = shark.direction;

        int change;
        if(direction == 1 || direction == 4){
            change = -1;
        }else{
            change = 1;
        }
        while(speed > 0){
            if(direction == 1){ // 위로 올라가는 경우
                if (r == 0){
                    direction = 2;
                    change = 1;
                }
                r += change;
            }else if (direction == 2){ // 아래로 내려가는 경우
                if (r == board.length-1){
                    direction = 1;
                    change = -1;
                }
                r += change;
            }else if (direction == 3){// 오른쪽으로 가는 경우
                if(c == board[0].length-1){
                    direction = 4;
                    change = -1;
                }
                c += change;
            }else{
                if(c == 0){
                    direction = 3;
                    change = 1;
                }
                c += change;
            }
            speed--;

        }

        if(board[r][c] == null){
            board[r][c] = new Shark(r,c,shark.speed, direction, shark.size);
        }else{
            if(board[r][c].size < shark.size){
                board[r][c] = new Shark(r,c,shark.speed, direction, shark.size);
            }
        }
    }
}