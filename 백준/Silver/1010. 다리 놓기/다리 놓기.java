import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        
        for (int i =0; i < t; i++){
            long answer = 1;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n > m/2)  n = m - n;

            for (int j = m; j > m-n; j--){
                answer *= j;
            }
            for (int  j = n; j > 1; j--){
                answer /= j;
            }

            System.out.println(answer);
        }


    }
}