import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine());


        long count = 0;
        long sum = 0;
        while(sum < number){
            count++;
            sum += count;
        }
        
        if (sum == number) {
            System.out.print(count);
            return;
        }
        System.out.print(count-1);


    }
}
