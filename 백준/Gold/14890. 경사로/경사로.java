import java.util.*;
import java.io.*;

public class Main {
    static int n, l;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 행 검사
        for (int i = 0; i < n; i++) {
            if (canPass(i, true)) answer++;
        }

        // 열 검사
        for (int j = 0; j < n; j++) {
            if (canPass(j, false)) answer++;
        }

        System.out.println(answer);
    }

    static boolean canPass(int idx, boolean isRow) {
        int[] line = new int[n];
        boolean[] used = new boolean[n]; // 경사로 설치 여부

        for (int i = 0; i < n; i++) {
            if (isRow) {
                line[i] = board[idx][i];
            } else {
                line[i] = board[i][idx];
            }
        }

        for (int i = 1; i < n; i++) {
            int diff = line[i] - line[i - 1];

            if (diff == 0) {
                continue;
            } else if (diff == 1) {
                // 올라가는 경사: 이전 위치부터 뒤로 L칸 확인
                for (int j = i - 1; j >= i - l; j--) {
                    if (j < 0 || line[j] != line[i - 1] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            } else if (diff == -1) {
                // 내려가는 경사: 현재 위치부터 앞으로 L칸 확인
                for (int j = i; j < i + l; j++) {
                    if (j >= n || line[j] != line[i] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            } else {
                // 높이 차이가 2 이상
                return false;
            }
        }

        return true;
    }
}