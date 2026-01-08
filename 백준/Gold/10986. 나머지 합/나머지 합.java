import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] lastCount = new long[m]; //나머지가 i인 개수 저장
        lastCount[0] = 1;

        long answer = 0;

        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            sum += num;
            int last = (int)(sum % m);
            lastCount[last]++;
        }

        for(int i = 0; i < m; i++){
            if(lastCount[i] >= 2){
                answer += lastCount[i] * (lastCount[i] -1) / 2;
            }
        }

        System.out.println(answer);


    }
}