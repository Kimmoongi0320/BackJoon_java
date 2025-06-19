import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[][] heights;
    static int n;
    static int[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        heights = new int[n][n];
        int maxHeight = 0;

        for (int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j =0 ; j <n; j++){
                int height = Integer.parseInt(st.nextToken());
                heights[i][j] = height;
                if (height > maxHeight) maxHeight = height;
            }
        }

        int maxArea = 1;
        for (int i = 1; i < maxHeight; i++){
            visited = new int[n][n];
            int result = 0;
            for (int j =0 ; j <n ; j++){
                for (int k  = 0; k < n; k++){
                    if (visited[j][k] == 0 && heights[j][k] > i){
                        dfs(j,k,i);
                        result += 1;
                    }
                }
            }
            if (maxArea < result) maxArea = result;
        }

        System.out.print(maxArea);
    }


    static void dfs(int x, int y,int currentRain){
        if (x<n && y < n && x >= 0 && y >=0 && visited[x][y] == 0 && heights[x][y] > currentRain){
            visited[x][y] = 1;
            for (int[]move : moves){
                dfs(x+move[0],y+move[1],currentRain);
            }
        }
    }

}
