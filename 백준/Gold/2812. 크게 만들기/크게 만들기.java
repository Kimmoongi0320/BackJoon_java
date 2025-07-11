import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0 ; i< n ; i++){
            int current = (int)num.charAt(i) - '0';

            while(!stack.isEmpty() && count < k && stack.peek() < current) {
                stack.pop();
                count++;
            }
            stack.push(current);
        }

        while (count < k){
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < stack.size(); i++){
            sb.append(stack.get(i));
        }
        System.out.print(sb);

    }
}
