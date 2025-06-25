import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        int answer = 0;
        int count = n;
        for (int num : numbers){
            answer += num*count;
            count--;
        }

        System.out.println(answer);
    }


}
