import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t ; i ++){
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            PriorityQueue<Long> queue = new PriorityQueue<>();

            for (int j = 0 ; j < k; j++){
                long num = Long.parseLong(st.nextToken());
                queue.add(num);
            }

            long answer = 0;

            while (queue.size() > 1){
                long cost = queue.poll() + queue.poll();
                answer += cost;
                queue.add(cost);
            }

            System.out.println(answer);

        }
    }
}