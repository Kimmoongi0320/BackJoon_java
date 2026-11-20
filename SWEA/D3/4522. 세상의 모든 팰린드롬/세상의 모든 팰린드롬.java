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
            int n = s.length();
            if(n == 1) {
            	System.out.printf("#%d Exist\n",test_case);
                continue;
            }
            boolean possible = true;
            for(int i = 0; i < n/2; i++){
            	int otherIdx = n-1-i;
                if(s.charAt(i) == '?' || s.charAt(otherIdx) == '?') continue;
                else if(s.charAt(i) !=  s.charAt(otherIdx)){
                	possible = false;
                    break;
                }
            }
            if(possible) System.out.printf("#%d Exist\n",test_case);
            else System.out.printf("#%d Not exist\n",test_case);

		}
	}
}