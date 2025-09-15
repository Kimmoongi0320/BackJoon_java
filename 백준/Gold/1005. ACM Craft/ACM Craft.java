import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            //건물 개수
            int n = Integer.parseInt(st.nextToken());
            // 규칙 개수
            int k  = Integer.parseInt(st.nextToken());

            int[] cost = new int[n+1];
            //차수 관리
            int[] indegree = new int[n+1];

            st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j < n+1; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> rules = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                rules.add(new ArrayList<>());
            }
            int[] dp = new int[n+1];

            int start = 0;

            for (int j =0; j < k; j++){
                st = new StringTokenizer(br.readLine()," ");
                //이전 건물
                int before = Integer.parseInt(st.nextToken());
                //이후 건물
                int after = Integer.parseInt(st.nextToken());


                rules.get(before).add(after);
                indegree[after]++;
            }



            //최종 건물
            int end = Integer.parseInt(br.readLine());


            Queue<Integer> queue = new LinkedList<>();

            //차수가 0 인 경우
            for (int j = 1; j <= n; j++) {
                if (indegree[j] == 0) {
                    dp[j] = cost[j];
                    queue.add(j);
                }
            }

            while (!queue.isEmpty()){
                int current = queue.poll();
                for (int next : rules.get(current)){
                    dp[next] = Integer.max(dp[next],cost[next]+dp[current]);
                    if (--indegree[next] == 0){
                        queue.add(next);
                    }
                }
            }

            if (dp[end] == 0 && cost[end] > 0){
                System.out.println(cost[end]);
            }else{
                System.out.println(dp[end]);
            }

        }
    }
}
