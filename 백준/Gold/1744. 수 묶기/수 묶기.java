import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }

        minus.sort((a,b)-> Integer.compare(a,b));
        plus.sort((a,b)->Integer.compare(b,a));

        long answer = 0;
        if (plus.size() %2 ==0){
            for (int i = 0; i < plus.size(); i += 2) {
                int num1 = plus.get(i);
                int num2 = plus.get(i + 1);
                // 만약 1이 있으면 그냥 더하는게 이득
                if (num1 == 1 || num2 == 1) {
                    answer += num1 + num2;
                } else {
                    answer += (long)num1 * num2;
                }
            }
        }else {
            for (int i = 0; i < plus.size() - 1; i += 2) {
                int num1 = plus.get(i);
                int num2 = plus.get(i + 1);
                // 만약 1이 있으면 그냥 더하는게 이득
                if (num1 == 1 || num2 == 1) {
                    answer += num1 + num2;
                } else {
                    answer += (long)num1 * num2;
                }
            }
            answer += plus.get(plus.size() - 1);
        }

        if (minus.size() % 2 == 0) {
            for (int i = 0; i < minus.size(); i += 2) {
                answer += (long)minus.get(i) * minus.get(i + 1);
            }
        } else {
            for (int i = 0; i < minus.size() - 1; i += 2) {
                answer += (long)minus.get(i) * minus.get(i + 1);
            }
            answer += minus.get(minus.size() - 1);
        }

        System.out.print(answer);


    }
}
