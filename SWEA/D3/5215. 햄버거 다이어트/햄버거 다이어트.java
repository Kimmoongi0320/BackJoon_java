import java.util.*;
import java.io.*;


class Solution
{
    static int answer;
    static int[] scores,calories;
    static int n,l;
        
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());


		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            
            scores = new int[n];
            calories = new int[n];
            
            for(int i = 0; i < n; i++){
            	st = new StringTokenizer(br.readLine()," ");
                int score =  Integer.parseInt(st.nextToken());
                int calory =  Integer.parseInt(st.nextToken());
                
                scores[i] = score;
                calories[i] = calory;
            }
            
            answer = 0;
			dfs(0,0,0);
            
            System.out.printf("#%d %d\n",test_case,answer);
		}
	}
    
    static void dfs(int idx, int totalScore, int totalCalory){
    	if(idx == n){
        	answer= Math.max(answer, totalScore);
            return;
        }
        
        int score = scores[idx];
        int calory = calories[idx];
        
        if(totalCalory + calory <= l){
        	dfs(idx+1,totalScore+score, totalCalory + calory);
        }
        dfs(idx+1,totalScore,totalCalory);
        
    }
}