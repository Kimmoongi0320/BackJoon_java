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
			StringTokenizer st = new StringTokenizer(br.readLine());
            int aUp = Integer.parseInt(st.nextToken());
            int aDown = Integer.parseInt(st.nextToken());
            int bUp = Integer.parseInt(st.nextToken());
            int bDown = Integer.parseInt(st.nextToken());
            
            if(aUp*bDown == bUp*aDown){
            	System.out.printf("#%d DRAW\n",test_case);
            }else if(aUp*bDown > bUp*aDown){
            	System.out.printf("#%d ALICE\n",test_case);
            }else System.out.printf("#%d BOB\n",test_case);
	
		}
	}
}