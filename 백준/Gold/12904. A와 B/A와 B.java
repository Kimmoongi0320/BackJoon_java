import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int startLength = s.length();
        while(startLength < t.length()){
            int endLength = t.length();
            if (t.charAt(endLength-1) == 'A'){
                t = t.substring(0,endLength-1);
            } else if (t.charAt(endLength-1) == 'B') {
                StringBuilder sb = new StringBuilder(t.substring(0,endLength-1));
                t = sb.reverse().toString();
            }

            if (t.equals(s)) {
                System.out.print(1);
                return;
            }
        }
        System.out.print(0);
    }
}

