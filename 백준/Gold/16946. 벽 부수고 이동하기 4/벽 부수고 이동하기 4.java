import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[][] dp;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new  int[n][m];
        dp = new int[n][m];
        int[][] check = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int checkArea = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0 && !visited[i][j]){
                    List<int[]> pos = new ArrayList<>();
                    Queue<int[]> queue = new LinkedList<>();

                    int[] firstPos =  new int[]{i,j};
                    visited[i][j] = true;
                    queue.add(firstPos);
                    pos.add(firstPos);

                    while(!queue.isEmpty()){

                        int[] cur =  queue.poll();

                        for(int[] move:moves){
                            int x = cur[0] + move[0];
                            int y = cur[1] + move[1];

                            if(x <0 || y < 0 || x >=n || y >=m) continue;
                            if(board[x][y]==0 && !visited[x][y]){
                                int[] nextPos =  new int[]{x,y};
                                visited[x][y] = true;
                                pos.add(nextPos);
                                queue.add(nextPos);
                            }
                        }
                    }
                    int totalCount = pos.size();
                    for(int[] position: pos){
                        dp[position[0]][position[1]] = totalCount;
                        check[position[0]][position[1]] = checkArea;
                    }
                    checkArea++;
                }
            }
        }

        int[][] answer = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0){
                    answer[i][j]=0;
                }else{
                    int canTotalMoveCount = 0;
                    boolean[] areaVisited = new boolean[checkArea];
                    for(int[] move:moves){
                        int x = i + move[0];
                        int y = j + move[1];

                        if(x <0 || y < 0 || x >=n || y >=m) continue;
                        if(!areaVisited[check[x][y]]){
                            canTotalMoveCount += dp[x][y];
                            areaVisited[check[x][y]] = true;
                        }
                    }
                    answer[i][j] = (canTotalMoveCount+1)%10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

}

