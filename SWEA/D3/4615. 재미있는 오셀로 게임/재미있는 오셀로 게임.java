import java.util.*;
import java.io.*;


class Solution
{
    static int[][] board;
    static int n;
    static int[][] moves = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
			board = new int[n+1][n+1];
            board[n/2][n/2] = 2;
            board[n/2+1][n/2+1] = 2;
            board[n/2+1][n/2] = 1;
            board[n/2][n/2+1] = 1;
            
            for(int i = 0; i < m; i++){
            	st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                
                board[x][y] = color;
                
                for(int[] move: moves){
                	int nx = x + move[0];
                    int ny = y + move[1];
                    
                    if(inRange(nx,ny) && board[nx][ny] != 0 && board[nx][ny] != color){
                    	check(x,y,move);
                    }
                }
            }
            
            int b = 0;
            int w = 0;
            
            for(int i = 1; i < n+1; i++){
            	for(int j = 1; j < n+1; j++){
                	if(board[i][j] == 1) b++;
                    else if(board[i][j] == 2) w++;
                }
            }
            
            System.out.printf("#%d %d %d\n",test_case,b,w);
		}
	}
    static void check(int x, int y, int[] move){
    	int color = board[x][y];
        
        int nx = x + move[0];
        int ny = y + move[1];
        
        List<int[]> positions = new ArrayList<>();
        while(inRange(nx,ny) && board[nx][ny] != 0 && board[nx][ny] != color){
        	positions.add(new int[]{nx,ny});
            nx += move[0];
            ny +=move[1];
        }
        
        if(inRange(nx,ny) && board[nx][ny] == color){
        	for(int[] pos : positions){
            	board[pos[0]][pos[1]] = color;
            }
        }
    }
    static boolean inRange(int x, int y){
    	if(x < 1 || y < 1 || x > n || y > n) return false;
        return true;
    }
    
}