import java.util.*;
import java.io.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] degrees = new int[n+1];
            int[] visited = new int[n+1];
            List<List<Integer>> sequence = new ArrayList<>();
            for(int i = 0; i < n+1; i++) {
                sequence.add(new ArrayList<>());
            }

            for(int i = 0; i <m; i++){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                degrees[second]++;
                sequence.get(first).add(second);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 1; i < n+1; i++){
                if (degrees[i] == 0){
                    pq.add(i);
                }
            }

            StringBuilder sb =new StringBuilder();
            while(!pq.isEmpty()){
                int cur = pq.poll();
                sb.append(cur).append(" ");

                for(int next:sequence.get(cur)){
                    if(--degrees[next] == 0){
                        pq.add(next);
                    }
                }
            }

            System.out.println(sb);

    }
}