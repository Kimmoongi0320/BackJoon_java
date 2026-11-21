
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
			String num = br.readLine();
			while(num.length() > 1){
            	num = translate(num);
            }
            
            int result = Integer.parseInt(num);
            
            System.out.printf("#%d %d\n",test_case,result);
		}
	}
    static String translate(String num){
    	int total = 0;
        
        for(int i = 0; i < num.length(); i++){
        	total += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        
        return String.valueOf(total);
    }
}