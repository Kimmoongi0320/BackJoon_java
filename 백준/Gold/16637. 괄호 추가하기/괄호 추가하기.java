import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static List<Integer> numbers;
    static List<Character> operator;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        operator = new ArrayList<>();

        String line = br.readLine();
        for(int i = 0; i < n; i++){
            char cha = line.charAt(i);

            if(cha == '+' || cha == '-' ||  cha == '*'){
                operator.add(cha);
            }else{
                numbers.add(Integer.parseInt(String.valueOf(cha)));
            }
        }
        Dfs(numbers.get(0),0);
        System.out.print(answer);
    }
    public static void Dfs(int result, int idx){
        if(idx == operator.size()){
            answer = Integer.max(answer,result);
            return;
        }

        int sum = calculate(result,numbers.get(idx+1),operator.get(idx));
        Dfs(sum,idx+1);

        if(idx + 1 < operator.size()){
            int nextSum = calculate(numbers.get(idx+1),numbers.get(idx+2),operator.get(idx+1));

            Dfs(calculate(result,nextSum,operator.get(idx)),idx+2);
        }
    }

    public static int calculate(int x, int y, char operator){
        if(operator == '+') return x+y;
        else if(operator == '-') return x-y;
        else return x*y;
    }
}
