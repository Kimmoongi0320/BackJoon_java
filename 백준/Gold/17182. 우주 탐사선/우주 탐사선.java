import java.io.*;
import java.util.*;

public class Main {
    static int[][] paths;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        paths = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(paths[i],99999);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                paths[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int t = 0; t < n; t++){
                    paths[i][j] = Integer.min(paths[i][j],paths[i][t] + paths[t][j]);
                }
            }
        }

        visited = new boolean[n];
        visited[k] = true;


        backTracking(k,0,1);
        System.out.println(answer);
    }

    static void backTracking(int cur, int totalLength, int visitCount){
        if(totalLength > answer) return;
        if(visitCount == n){
            answer = totalLength;
            return;
        }

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                backTracking(i,totalLength+paths[cur][i],visitCount+1);
                visited[i] = false;
            }
        }

    }
}
