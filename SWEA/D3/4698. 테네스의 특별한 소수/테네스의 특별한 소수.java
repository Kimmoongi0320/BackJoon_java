import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());

		boolean[] primes = new boolean[1000001];
       	for(int i = 2; i < 1000001; i++){
        	if(isPrime(i)) primes[i] = true;
        }
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int answer = 0;
            
            for(int i = a; i <= b; i++){
            	if(primes[i]  && involve(i,d)) {
                	primes[i] = true;
                    answer++;
                }
            }
            
            System.out.printf("#%d %d\n",test_case,answer);

		}
	}
    static boolean involve(int num, int target){
    	while(num > 0){
        	if(num % 10 == target) return true;
            num /= 10;
        }
        return false;
    }
    
    static boolean isPrime(int num){
    	if(num == 1) return false;
        
        for(int i = 2; i * i <= num; i++){
        	if(num % i == 0) return false;
        }
        
        return true;
    }
}