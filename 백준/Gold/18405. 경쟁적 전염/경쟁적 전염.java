import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][n + 1];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                board[i][j] = cur;
                if (cur != 0) list.add(new int[]{cur, i, j, 0});
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        list.sort((a, b) -> a[0] - b[0]);
        Queue<int[]> queue = new ArrayDeque<>(list);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0], cx = cur[1], cy = cur[2], time = cur[3];
            if (time == s) break;

            for (int[] move : moves) {
                int nx = cx + move[0];
                int ny = cy + move[1];
                if (inRange(nx, ny) && board[nx][ny] == 0) {
                    board[nx][ny] = num;
                    queue.add(new int[]{num, nx, ny, time + 1});
                }
            }
        }

        System.out.print(board[x][y]);
    }

    static boolean inRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
}