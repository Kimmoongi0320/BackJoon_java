import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i = 0 ; i < n; i ++){
            long num = Integer.parseInt(st.nextToken());
            queue.add(num);
        }

        for (int i = 0 ; i < m; i++){
            long num1 = queue.poll();
            long num2 = queue.poll();

            long sum = num1 + num2;
            queue.add(sum);
            queue.add(sum);
        }

        long answer = 0;
        while (!queue.isEmpty()){
            answer += queue.poll();
        }

        System.out.println(answer);



    }
}