import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int deleteNum = k -1;

        int[] sensor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = sensor[i + 1] - sensor[i];
        }

        int answer = 0;
        if (deleteNum >= n-1) {
            System.out.print(answer);
            return;
        } else {
            Arrays.sort(distance);
            for (int i = 0; i < n - 1 - deleteNum; i++) {
                answer += distance[i];
            }
        }

        System.out.print(answer);

    }
}
