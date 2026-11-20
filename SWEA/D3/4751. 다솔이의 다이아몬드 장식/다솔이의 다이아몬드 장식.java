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
            String word = br.readLine();
            int n = word.length();
			String first = "";
            
            for(int i = 0; i < n; i++){
            	first += "..#.";
            }
            first += ".";
            
            String second = "";
            for(int i = 0; i < n; i++){
            	second += ".#.#";
            }
            second += ".";
            
            String middle = "";
            for(int i = 0; i < n; i++){
            	String cur = String.valueOf(word.charAt(i));
                middle += "#.";
                middle += cur;
                middle += ".";
            }
            middle += "#";
            
            System.out.println(first);
            System.out.println(second);
            System.out.println(middle);
            System.out.println(second);
            System.out.println(first);
            

		}
	}
}