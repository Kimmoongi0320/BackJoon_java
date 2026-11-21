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
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if((d == 11 && h < 11) || (d == 11 && h == 11 && m < 11)){
            	System.out.printf("#%d -1\n",test_case);
                continue;
            }
            
            int total = 0;
            total += (d-11) * 24*60;
            total += (h-11) * 60;
            total += (m-11);
            
            System.out.printf("#%d %d\n",test_case,total);

		}
	}
}