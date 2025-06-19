import java.awt.*;
import  java.util.*;
import java.io.*;



public class Main {
    static int[][] moves = {{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int i = 0; i < times; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] visited = new int[n][n];
            //시작점
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            //도착점
            st = new StringTokenizer(br.readLine()," ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{startX,startY,0});
            visited[startX][startY] = 1;

            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int cost = current[2];
                if (currentX == endX && currentY == endY){
                    System.out.println(cost);
                    break;
                }else{
                    for(int[] move : moves){
                        int nextX = currentX+move[0];
                        int nextY = currentY+move[1];
                        if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && visited[nextX][nextY] != 1){
                            queue.add(new int[]{currentX+move[0],currentY+move[1],cost+1});
                            visited[nextX][nextY] = 1;
                        }
                    }
                }
            }
        }
    }
}
