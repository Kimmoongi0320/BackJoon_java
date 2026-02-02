import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines.add(new int[]{from, to});
        }

        lines.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> dp = new ArrayList<>();
        dp.add(lines.get(0)[1]);

        int[] pos = new int[n];  // 각 원소가 dp에서 들어간 위치
        pos[0] = 0;

        for (int i = 1; i < lines.size(); i++) {
            int num = lines.get(i)[1];
            int size = dp.size();

            if (dp.get(size - 1) < num) {
                pos[i] = size;
                dp.add(num);
            } else {
                int idx = binarySearch(dp, 0, size - 1, num);
                pos[i] = idx;
                dp.set(idx, num);
            }
        }

        // LIS에 포함되는 인덱스 찾기
        boolean[] inLIS = new boolean[n];
        int target = dp.size() - 1;
        for (int i = n - 1; i >= 0 && target >= 0; i--) {
            if (pos[i] == target) {
                inLIS[i] = true;
                target--;
            }
        }

        // LIS에 포함되지 않는 것 = 제거 대상
        StringBuilder sb = new StringBuilder();
        sb.append(n - dp.size()).append("\n");
        for (int i = 0; i < n; i++) {
            if (!inLIS[i]) {
                sb.append(lines.get(i)[0]).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static int binarySearch(List<Integer> dp, int start, int end, int num) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (dp.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}