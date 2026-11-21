import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n+1][n+1];
            
            for(int i = 1; i <= n; i++){
            	board[i][1] = 1;
                board[i][i] = 1;
            }
            
            for(int i = 3; i <=n ; i++){
            	for(int j = 2 ; j < i; j++){
                	board[i][j] = board[i-1][j] + board[i-1][j-1];
                }
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append("\n");
            for(int i = 1; i <=n; i++){
            	for(int j = 1; j <= i; j++){
                	sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            
            System.out.print(sb.toString());

		}
	}
}