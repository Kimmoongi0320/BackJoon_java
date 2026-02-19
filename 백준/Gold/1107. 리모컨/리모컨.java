import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m == 0){
            int answer = Integer.min(Math.abs(n-100),String.valueOf(n).length());
            System.out.println(answer);
            return;
        }
        boolean[] broken = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < m; i++){
            broken[Integer.parseInt(st.nextToken())] = true;
        }

        int answer = Math.abs(n-100); // 초기값은 전분 +,- 버튼을 눌러서 이동하는 경우

        for(int i = 0; i < 999999; i++){
            String num = String.valueOf(i);
            boolean isBreak = false;

            for(int j = 0; j < num.length(); j++){
                if(broken[num.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak){
                int totalPushCount = Math.abs(i-n) + num.length();
                answer = Integer.min(answer, totalPushCount);
            }
        }

        System.out.println(answer);
    }
}