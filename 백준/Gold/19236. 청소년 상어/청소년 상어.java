import java.util.*;
import java.io.*;

public class Main {
    // 방향: 0(↑), 1(↖), 2(←), 3(↙), 4(↓), 5(↘), 6(→), 7(↗)
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

    public static class Fish {
        int direction;
        int num;
        public Fish(int direction, int num) {
            this.direction = direction;
            this.num = num;
        }
    }

    static Fish[][] board = new Fish[4][4];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = new Fish(direction, num);
            }
        }

        int sharkDir = board[0][0].direction;
        int eaten = board[0][0].num;
        board[0][0] = null;

        dfs(0, 0, sharkDir, eaten);

        System.out.println(answer);
    }

    static Fish[][] copyBoard(Fish[][] original) {
        Fish[][] copy = new Fish[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (original[i][j] != null)
                    copy[i][j] = new Fish(original[i][j].direction, original[i][j].num);
        return copy;
    }

    static void dfs(int sx, int sy, int sd, int total) {
        answer = Math.max(answer, total);

        Fish[][] beforeFishMove = copyBoard(board);
        fishMove(sx, sy);

        for (int dist = 1; dist <= 3; dist++) {
            int nx = sx + dr[sd] * dist;
            int ny = sy + dc[sd] * dist;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
            if (board[nx][ny] == null) continue;

            Fish[][] backup = copyBoard(board);
            Fish eatenFish = board[nx][ny];
            board[nx][ny] = null;

            dfs(nx, ny, eatenFish.direction, total + eatenFish.num);

            board = backup;
        }

        board = beforeFishMove;
    }

    static void fishMove(int sharkX, int sharkY) {
        for (int fishNum = 1; fishNum <= 16; fishNum++) {
            boolean found = false;
            for (int i = 0; i < 4 && !found; i++) {
                for (int j = 0; j < 4 && !found; j++) {
                    if (board[i][j] != null && board[i][j].num == fishNum) {
                        found = true;
                        int dirNum = board[i][j].direction;

                        for (int d = 0; d < 8; d++) {
                            int nd = (dirNum + d) % 8;
                            int nx = i + dr[nd];
                            int ny = j + dc[nd];

                            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
                            if (nx == sharkX && ny == sharkY) continue;

                            board[i][j].direction = nd;

                            if (board[nx][ny] == null) {
                                board[nx][ny] = board[i][j];
                                board[i][j] = null;
                            } else {
                                Fish temp = board[nx][ny];
                                board[nx][ny] = board[i][j];
                                board[i][j] = temp;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}