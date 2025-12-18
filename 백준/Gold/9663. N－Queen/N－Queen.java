import java.util.*;
import java.io.*;

public class Main{
    static int answer = 0;
    static int n;
    static int[] queens;  

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n];

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int col){
        if(col == n){
            answer++;
            return;
        }

        for(int row = 0; row < n; row++){
            boolean conflict = false;

            for(int prevCol = 0; prevCol < col; prevCol++){
                int prevRow = queens[prevCol];

                if(row == prevRow || Math.abs(row - prevRow) == Math.abs(col - prevCol)){
                    conflict = true;
                    break;
                }
            }

            if(!conflict){
                queens[col] = row;
                dfs(col + 1);
            }
        }
    }
}