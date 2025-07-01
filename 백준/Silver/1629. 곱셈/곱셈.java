import java.io.*;
import java.util.*;

public class Main {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.print(calculate(a,b));
    }

    public static long calculate(long num , long exponent){
        if (exponent == 1){
            return num % c;
        }

        long temp = calculate(num, exponent/2);

        if (exponent % 2 ==1){
            return ((temp * temp % c) * num) % c;
        }

        return temp * temp % c;
    }
}

