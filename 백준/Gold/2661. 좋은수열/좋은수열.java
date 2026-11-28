import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        sb = new StringBuilder();

        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int len){
        if(len == n){
            for(int i = 0; i < n; i++){
                sb.append(answer[i]);
            }
            return;
        }

        for(int i = 1; i <=3; i++){
            answer[len] = i;
            if(isGood(len+1)){
                dfs(len+1);
                if(sb.length() > 0) return;
            }
        }
    }
    static boolean isGood(int len){
        for(int middle = 1; middle*2 <= len; middle++){
            boolean same = true;
            for(int i= 0; i < middle; i++){
                if(answer[len-1-i] != answer[len-middle-1-i]){
                    same = false;
                    break;
                }
            }
            if(same) return false;
        }
        return true;
    }

}