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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(Math.abs(b-c) > 1){
            	System.out.printf("#%d impossible\n",test_case);
                continue;
            }
            if (b == 0 && c == 0) {
    if (a > 0 && d > 0) {
        System.out.printf("#%d impossible\n", test_case);
        continue;
    }

    StringBuilder sb = new StringBuilder();

    if (a > 0) {
        for (int i = 0; i <= a; i++) {
            sb.append('0');
        }
    } else {
        for (int i = 0; i <= d; i++) {
            sb.append('1');
        }
    }

    System.out.printf("#%d %s\n", test_case, sb.toString());
    continue;
}
            
            String start = b > c ? "0" : "1";
            String result = start;
            
            while(b > 0 || c>0){
            	if(start.equals("0")){
                	result += "1";
                    b--;
                    start = "1";
                }else{
                	result += "0";
                    c--;
                    start = "0";
                }
            }
            
            
            StringBuilder sb = new StringBuilder();
            
            boolean zero = false;
            boolean one = false;
            for(int i = 0; i < result.length(); i++){
            	char cur = result.charAt(i);
                if(cur == '0' && !zero){
                	for(int j = 0; j < a; j++){
                    	sb.append("0");
                    }
                    zero = true;
                }
                
                if(cur == '1' && !one){
                	for(int j = 0; j < d; j++){
                    	sb.append("1");
                    }
                    one = true;
                }
                sb.append(cur);
            }
            System.out.printf("#%d %s\n",test_case,sb.toString());

		}
	}
}