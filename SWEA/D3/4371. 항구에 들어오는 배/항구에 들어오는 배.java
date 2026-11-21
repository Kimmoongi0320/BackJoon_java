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
			int n = Integer.parseInt(br.readLine());
            Set<Integer> diffs = new HashSet<>();
            
            int start = Integer.parseInt(br.readLine());
            int answer = 0;
            for(int i = 0; i < n-1; i++){
            	int day = Integer.parseInt(br.readLine());
                
                boolean newBoat = true;
                for(int diff : diffs){
                	if((day-start) % diff == 0){
                    	newBoat = false;
                        break;
                    }
                }
                
                if(newBoat) {
                	answer++;
                    diffs.add(day-start);
                }
            }
            
            System.out.printf("#%d %d\n",test_case,answer);

		}
	}
}