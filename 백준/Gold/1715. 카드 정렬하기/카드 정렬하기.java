import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(queue.size() > 1){
            int sum = queue.poll() + queue.poll();
            answer += sum;
            queue.add(sum);
        }

        System.out.print(answer );


    }
}

