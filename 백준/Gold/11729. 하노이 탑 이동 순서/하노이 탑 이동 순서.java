import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n  = Integer.parseInt(br.readLine());

        sb.append((int)Math.pow(2,n)-1).append("\n");
        hanoi(n,1,3,2);

        System.out.print(sb);

    }

    static void hanoi(int num, int start, int to, int middle){
        if(num == 1){
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(num-1,start,middle,to);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(num-1,middle,to,start);
    }
}