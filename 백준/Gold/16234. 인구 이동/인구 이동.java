import java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        boolean changed = true;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalDays = 0;

        while(changed){
            int[][] visited = new int[n][n];
            changed = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] == 0){
                        Queue<int[]> queue = new LinkedList<>();
                        List<int[]> open = new LinkedList<>();
                        queue.offer(new int[]{i,j});
                        open.add(new int[]{i,j,board[i][j]});
                        visited[i][j] = 1;

                        while(!queue.isEmpty()){
                            int[] cur = queue.poll();

                            int curX = cur[0];
                            int curY = cur[1];
                            int curPeople = board[curX][curY];

                            for(int[] move: moves){
                                int nx = curX + move[0];
                                int ny = curY + move[1];

                                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                                int dif = Integer.max(curPeople, board[nx][ny]) - Integer.min(curPeople,board[nx][ny]);
                                if(visited[nx][ny] == 0 && dif >= l && dif <= r){
                                    changed = true;
                                    queue.add(new int[]{nx,ny});
                                    open.add(new int[]{nx,ny,board[nx][ny]});
                                    visited[nx][ny] = 1;
                                }

                            }
                        }

                        int totalPeople = 0;
                        for(int[] city: open){
                            totalPeople += city[2];
                        }
                        int peoplePerCity = totalPeople / open.size();
                        for(int[] city: open){
                            board[city[0]][city[1]] = peoplePerCity;
                        }

                    }
                }
            }
            if(changed) totalDays++;
        }

        System.out.println(totalDays);
    }
}