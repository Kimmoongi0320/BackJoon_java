import java.util.*;
import  java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degrees = new int[n+1];
        List<List<Integer>> sequence = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            sequence.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int nums = Integer.parseInt(st.nextToken());
            int first =  Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < nums-1; j++){
                int next = Integer.parseInt(st.nextToken());
                sequence.get(first).add(next);
                degrees[next]++;
                first = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n+1; i++){
            if(degrees[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int cur =  queue.poll();
            answer.add(cur);

            for(int next:sequence.get(cur)){
                degrees[next]--;

                if(degrees[next] == 0){
                    queue.add(next);
                }
            }
        }
        if(answer.size() < n){
            System.out.print(0);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int num:answer){
                sb.append(num).append("\n");
            }

            System.out.print(sb);
        }
    }


}
