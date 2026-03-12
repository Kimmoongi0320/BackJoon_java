import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    static int r,c;
    static char[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        int[] startPos = null;
        int[] endPos = null;
        for(int i=0;i<r;i++){
            String line = br.readLine();
            for(int j=0;j<c;j++){
                char cur =  line.charAt(j);
                if(cur=='L'){
                    if(startPos==null){
                        startPos = new int[]{i,j};
                    }else{
                        endPos=new int[]{i,j};
                    }
                }
                board[i][j] = cur;
            }
        }

        int[][] meltTime =  new int[r][c];
        for(int[] row : meltTime) Arrays.fill(row,Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]!='X'){
                    meltTime[i][j]=0;
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] waterPos = queue.poll();
            int x = waterPos[0];
            int y = waterPos[1];

            for(int[] move : moves){
                int nx = x+move[0];
                int ny = y+move[1];
                if(!inBoard(nx,ny)) continue;
                if(meltTime[nx][ny] > meltTime[x][y]+1){
                    meltTime[nx][ny] = meltTime[x][y]+1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        boolean[][] visited = new boolean[r][c];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,startPos[0],startPos[1]});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];

            if(x == endPos[0] && y == endPos[1]){
                System.out.print(time);
                return;
            }

            if(visited[x][y]) continue;
            visited[x][y] = true;

            for(int[] move : moves){
                int nx = x+move[0];
                int ny = y+move[1];
                if(!inBoard(nx,ny) || visited[nx][ny]) continue;
                int cost = Integer.max(time,meltTime[nx][ny]);
                pq.add(new int[]{cost,nx,ny});
            }
        }
    }


    static boolean inBoard(int x,int y){
        return x>=0 && x<r && y>=0 && y<c;
    }
}
