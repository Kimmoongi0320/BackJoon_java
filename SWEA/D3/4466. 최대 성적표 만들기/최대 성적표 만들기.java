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
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[] scores = new int[n];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < n; i++){
            	scores[i] =  Integer.parseInt(st.nextToken());
            }
			Arrays.sort(scores);
            int answer =0;
            for(int i = 0; i < k; i++){
            	answer += scores[n-1-i];
            }
            System.out.printf("#%d %d\n",test_case,answer);
		}
	}
    

}