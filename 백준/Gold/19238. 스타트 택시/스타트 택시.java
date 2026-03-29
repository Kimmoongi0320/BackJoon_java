import java.util.*;
import java.io.*;

public class Main {
    static int[][] moves = {{-1,0},{0,-1},{0,1},{1,0}};
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int count = 0;
    static int[][] passengers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1 ; j <= n; j++){
                int cur = Integer.parseInt(st.nextToken());
                board[i][j] = cur * -1;
            }
        }

        int startX, startY;
        st = new StringTokenizer(br.readLine()," ");
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        passengers = new int[m+1][2];

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int destinationX = Integer.parseInt(st.nextToken());
            int destinationY = Integer.parseInt(st.nextToken());

            board[x][y] = i;
            passengers[i] = new int[] {destinationX,destinationY};
        }

        while(count < m){

            visited = new boolean[n+1][n+1];

            int[] passengerPos = getPassenger(startX,startY,fuel);

            if(passengerPos[0] == -1){
                System.out.print(-1);
                return;
            }

            startX = passengerPos[0];
            startY = passengerPos[1];
            int passengerNum = passengerPos[2];
            fuel = passengerPos[3];

            board[startX][startY] = 0;

            visited = new boolean[n+1][n+1];

            int[] destinationPos = toDestination(startX,startY,fuel,passengerNum);

            if(destinationPos[0] == -1){
                System.out.print(-1);
                return;
            }

            int used = fuel - destinationPos[2];
            fuel = destinationPos[2] + (used * 2);

            startX = destinationPos[0];
            startY = destinationPos[1];

            count++;
        }

        System.out.print(fuel);
    }

    public static int[] getPassenger(int x, int y, int fuel){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});

        visited[x][y] = true;

        int minDist = Integer.MAX_VALUE;
        List<int[]> candidates = new ArrayList<>();

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(dist > minDist) break;

            if(board[cx][cy] >= 1){
                minDist = dist;
                candidates.add(new int[]{cx,cy,board[cx][cy]});
            }

            for(int[] move : moves){

                int nx = cx + move[0];
                int ny = cy + move[1];

                if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if(board[nx][ny] == -1) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                queue.add(new int[]{nx,ny,dist+1});
            }
        }

        if(candidates.isEmpty()) return new int[]{-1};

        candidates.sort((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int[] chosen = candidates.get(0);

        if(fuel < minDist) return new int[]{-1};

        return new int[]{chosen[0],chosen[1],chosen[2],fuel-minDist};
    }

    public static int[] toDestination(int x, int y, int fuel, int passengerNum){

        int[] destination = passengers[passengerNum];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,fuel});

        visited[x][y] = true;

        while(!queue.isEmpty()){

            int[] cur = queue.poll();

            if(cur[2] < 0) continue;

            if(cur[0] == destination[0] && cur[1] == destination[1]){
                return new int[]{cur[0],cur[1],cur[2]};
            }

            for(int[] move : moves){

                int nx = cur[0] + move[0];
                int ny = cur[1] + move[1];

                if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
                if(board[nx][ny] == -1) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                queue.add(new int[]{nx,ny,cur[2]-1});
            }
        }

        return new int[]{-1};
    }
}