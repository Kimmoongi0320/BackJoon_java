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
			int max = 0;
            int min = 10001;
            
            double total = 0;
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < 10; i++){
            	int num = Integer.parseInt(st.nextToken());
                total += num;
                max = Math.max(max,num);
                min = Math.min(min,num);
            }
            
            int answer = (int)Math.round((total-max-min)/8);
            System.out.printf("#%d %d\n",test_case,answer);

		}
	}
}