import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static char[][] board;
    static int[][] waterTime;  // 물이 도착하는 시간
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        waterTime = new int[r][c];

        int[] start = null;
        Queue<int[]> waterQueue = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            Arrays.fill(waterTime[i], Integer.MAX_VALUE);
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'S') start = new int[]{i, j};
                if(board[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                    waterTime[i][j] = 0;
                }
            }
        }

        precomputeWater(waterQueue);

        int answer = bfs(start);
        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }

    static void precomputeWater(Queue<int[]> queue) {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for(int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(board[nx][ny] == 'X' || board[nx][ny] == 'D') continue;
                if(waterTime[nx][ny] != Integer.MAX_VALUE) continue;

                waterTime[nx][ny] = waterTime[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            for(int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(visited[nx][ny] || board[nx][ny] == 'X') continue;

                if(board[nx][ny] == 'D') return time + 1;

                // 고슴도치가 도착하는 시간(time+1)보다 물이 늦게 오거나 안 오면 이동 가능
                if(time + 1 < waterTime[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, time + 1});
                }
            }
        }
        return -1; 
    }
}