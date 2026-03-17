import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int[] startPos = null;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '0') startPos = new int[]{i, j};
            }
        }

        boolean[][][] visited = new boolean[n][m][64];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPos[0], startPos[1], 0, 0});
        visited[startPos[0]][startPos[1]][0] = true;

        int answer = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], keyState = cur[2], dist = cur[3];

            if (board[x][y] == '1') {
                answer = dist;
                break;
            }

            for (int[] move : moves) {
                int nx = x + move[0], ny = y + move[1];
                if (!inBoard(nx, ny)) continue;
                char c = board[nx][ny];
                if (c == '#') continue;

                int newKeyState = keyState;

                if (c >= 'a' && c <= 'f') {
                    newKeyState |= (1 << (c - 'a'));
                }

                if (c >= 'A' && c <= 'F') {
                    if ((keyState & (1 << (c - 'A'))) == 0) continue;
                }

                if (!visited[nx][ny][newKeyState]) {
                    visited[nx][ny][newKeyState] = true;
                    queue.add(new int[]{nx, ny, newKeyState, dist + 1});
                }
            }
        }

        System.out.print(answer);
    }

    public static boolean inBoard(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}