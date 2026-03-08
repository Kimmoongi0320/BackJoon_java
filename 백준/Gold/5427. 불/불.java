import java.io.*;
import java.util.*;

public class Main {
    static int[][] fire;
    static char[][] board;
    static boolean[][] visited;
    static int w,h;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            h =  Integer.parseInt(st.nextToken());
            w =  Integer.parseInt(st.nextToken());

            fire = new int[w][h];
            board = new char[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                Arrays.fill(fire[i],Integer.MAX_VALUE);
            }

            int[] startPos = null;
            for(int i = 0; i < w; i++){
                String line = br.readLine();
                for(int j = 0; j < h; j++){
                    char cur =  line.charAt(j);
                    if(cur == '@') startPos = new int[]{i,j};
                    else if(cur == '*'){
                        fire[i][j] = 0;
                    }

                    board[i][j] = cur;
                }
            }
            fillFire();

            int answer = Integer.MAX_VALUE;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startPos[0],startPos[1],0});

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0],y = cur[1];
                int cost = cur[2];

                if(x == 0 || y == 0 || x == w-1 || y == h-1){
                    answer = cost+1;
                    break;
                }

                for(int[] move : moves){
                    int nx = x + move[0];
                    int ny = y + move[1];

                    if(!inBoard(nx,ny) || board[nx][ny] == '#') continue;
                    if(!visited[nx][ny] && fire[nx][ny] > cost+1){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny,cost+1});
                    }
                }
            }

            if(answer == Integer.MAX_VALUE){
                sb.append("IMPOSSIBLE").append("\n");
            }else{
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);


    }

    public static void fillFire(){

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(board[i][j] == '*'){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int curFireTime = fire[pos[0]][pos[1]];

            for(int[] move : moves){
                int nx = pos[0] + move[0];
                int ny = pos[1] + move[1];

                if(!inBoard(nx,ny) || board[nx][ny] == '#') continue;
                if(fire[nx][ny] == Integer.MAX_VALUE){
                    fire[nx][ny] = curFireTime + 1;
                    queue.add(new int[]{nx,ny});
                }

            }
        }
    }

    static boolean inBoard(int x, int y){
        return x >= 0 && x < w && y >= 0 && y < h;
    }
}