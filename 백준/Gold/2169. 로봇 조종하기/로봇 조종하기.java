import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] best = new int[n + 1][m + 1];
        int[][] left = new int[n + 1][m + 1];
        int[][] right = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(best[i], Integer.MIN_VALUE / 2);
            Arrays.fill(left[i], Integer.MIN_VALUE / 2);
            Arrays.fill(right[i], Integer.MIN_VALUE / 2);
        }

        best[1][1] = board[1][1];
        for (int j = 2; j <= m; j++) {
            best[1][j] = best[1][j - 1] + board[1][j];
        }

        // 2행부터
        for (int i = 2; i <= n; i++) {
            // 왼→오: j=1부터 오른쪽으로
            left[i][1] = best[i - 1][1] + board[i][1];
            for (int j = 2; j <= m; j++) {
                left[i][j] = Math.max(best[i - 1][j], left[i][j - 1]) + board[i][j];
            }

            // 오→왼: j=m부터 왼쪽으로
            right[i][m] = best[i - 1][m] + board[i][m];
            for (int j = m - 1; j >= 1; j--) {
                right[i][j] = Math.max(best[i - 1][j], right[i][j + 1]) + board[i][j];
            }

            // 합치기
            for (int j = 1; j <= m; j++) {
                best[i][j] = Math.max(left[i][j], right[i][j]);
            }
        }

        System.out.println(best[n][m]);
    }
}