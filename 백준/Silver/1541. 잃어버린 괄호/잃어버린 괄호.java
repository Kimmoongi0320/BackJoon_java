import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Queue<String> nums = new LinkedList<>();

        int lastIdx = -1;
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == '+' || line.charAt(i) == '-'){
                nums.add(line.substring(lastIdx+1,i));
                nums.add(line.substring(i,i+1));
                lastIdx = i;
            }
        }
        nums.add(line.substring(lastIdx+1));

        int answer = 0;
        boolean plus = true;

        while(!nums.isEmpty()){
            String num = nums.poll();
            if (num.equals("+")){
                continue;
            } else if (num.equals("-")) {
                plus = false;
            } else if (plus) {
                answer += Integer.parseInt(num);
            }else{
                answer -= Integer.parseInt(num);
            }

        }

        System.out.print(answer);
    }


}
