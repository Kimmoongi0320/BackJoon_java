import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dpKeep = new int[n]; // 삭제 안 함
        int[] dpSkip = new int[n]; // 하나 삭제함

        dpKeep[0] = arr[0];
        dpSkip[0] = arr[0]; // 첫 원소에서 삭제는 의미 없음
        int answer = dpKeep[0];

        for (int i = 1; i < n; i++) {
            dpKeep[i] = Math.max(dpKeep[i - 1] + arr[i], arr[i]);
            dpSkip[i] = Math.max(dpSkip[i - 1] + arr[i], dpKeep[i - 1]);
            answer = Math.max(answer, Math.max(dpKeep[i], dpSkip[i]));
        }

        System.out.println(answer);
    }
}