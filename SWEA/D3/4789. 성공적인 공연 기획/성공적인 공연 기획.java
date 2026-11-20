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
			String s = br.readLine();
            int total = Integer.parseInt(String.valueOf(s.charAt(0)));
            
            int answer = 0;
            for(int i = 1; i < s.length(); i++){
            	int need = i;
                int plus =  Integer.parseInt(String.valueOf(s.charAt(i)));
                if(total < need && plus > 0){
                	answer += (need-total);
                    total = need + plus;
                }else{
                	total += plus;
                }

            }
            
            System.out.printf("#%d %d\n",test_case,answer);

		}
	}
}