import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            List<int[]> scores = new ArrayList<>();

            for (int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int aScore = Integer.parseInt(st.nextToken());
                int bScore = Integer.parseInt(st.nextToken());

                scores.add(new int[]{aScore,bScore});
            }

            scores.sort((a,b)->Integer.compare(a[0],b[0]));


            int answer = 0;
            boolean pass =false;
            int lastIdx = 0;
            for (int j = 1;j < n; j++){
                // 이전 참가자가 탈락하지 않았을 경우
                if (!pass){
                    if (scores.get(j-1)[1] > scores.get(j)[1]){
                        lastIdx = j;
                        answer++;
                    }else{
                        pass = true;
                    }
                }
                // 이전 참가자가 탈락하여 이전 참가자의 등수는 고려하지 않는 경우
                else{
                    if (scores.get(lastIdx)[1] > scores.get(j)[1]){
                        pass = false;
                        lastIdx = j;
                        answer++;
                    }
                }
            }
            System.out.println(answer+1);
        }
    }
}
