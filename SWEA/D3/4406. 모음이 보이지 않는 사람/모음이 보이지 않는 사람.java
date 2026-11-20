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
			StringBuilder sb= new StringBuilder();
            
            String s= br.readLine();
            for(int i = 0; i < s.length();i++){
            	char cur = s.charAt(i);
                if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') continue;
                sb.append(cur);
            }
            System.out.printf("#%d %s\n",test_case,sb.toString());

		}
	}
}