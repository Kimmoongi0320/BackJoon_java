import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < m; j++){
                board[i][j] = (Integer.parseInt(st.nextToken())) * -1;
            }
        }

        int landNum = 1;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == -1){
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});

                    while(!queue.isEmpty()){
                        int[] cur =  queue.poll();
                        board[cur[0]][cur[1]] = landNum;

                        for(int[] move : moves){
                            int nx = cur[0] + move[0];
                            int ny = cur[1] + move[1];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if(board[nx][ny] == -1 && !visited[nx][ny]){
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx,ny});
                            }
                        }
                    }

                    landNum++;
                }
            }
        }

        int[][] edges = new int[7][7];
        for(int i = 0 ; i < 7; i++){
            Arrays.fill(edges[i],Integer.MAX_VALUE);
        }
        // 각 땅 사이 가장 가까운 거리 계산
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] != 0){
                    int curLandNum = board[i][j];

                    for(int k = 0; k < 4; k++){
                        int[] move = moves[k];

                        int nx = i + move[0];
                        int ny = j + move[1];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(board[nx][ny] == 0){
                            int[] checkResult = checkDirection(i,j,curLandNum,move);
                            if(checkResult[1] == 1) continue; // 거리가 1이면 무시
                            if(checkResult[0] != -1){
                                int lowValue = Integer.min(edges[curLandNum][checkResult[0]],checkResult[1]);
                                edges[curLandNum][checkResult[0]] = lowValue;
                                edges[checkResult[0]][curLandNum] = lowValue;
                            }
                        }
                    }
                }
            }
        }

        boolean[] visited = new boolean[landNum];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{1,0});

        int answer = 0 ;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            answer += cur[1];

            for(int i = 1; i < 7; i++){
                if(edges[cur[0]][i] != Integer.MAX_VALUE && !visited[i]){
                    pq.add(new int[]{i,edges[cur[0]][i]});
                }
            }
        }

        for (int i = 1; i < landNum; i++) {
            if (!visited[i]) {
                System.out.print(-1);
                return;
            }
        }
        System.out.println(answer);

    }

    static int[] checkDirection(int curX,int curY,int curLandNum,int[] direction){
        int count = 0;

        while(true){
            int nx = curX + direction[0];
            int ny = curY + direction[1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                return new int[]{-1,-1};
            }
            if(board[nx][ny] != 0){
                if(board[nx][ny] == curLandNum){
                    return new int[]{-1,-1};
                }else {
                    return new int[] {board[nx][ny],count};
                }
            }else{
                curX = nx;
                curY = ny;
                count++;
            }

        }
    }
}