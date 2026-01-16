import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // K >= N이면 차수 K를 가질 수 있는 정점이 없음
        if (k >= n) {
            System.out.print(0);
            return;
        }
        
        // K == 0이면 모든 정점이 고립될 수 있음 (간선 안 추가하면 됨)
        if (k == 0) {
            System.out.print(n);
            return;
        }

        // N * K가 짝수면 모든 N개 정점이 차수 K 가능
        // N * K가 홀수면 최대 N-1개 가능
        if ((n * k) % 2 == 0) {
            System.out.print(n);
        } else {
            System.out.print(n - 1);
        }
    }
}