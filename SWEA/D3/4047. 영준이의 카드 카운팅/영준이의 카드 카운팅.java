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
			Map<String,Set<Integer>> cards = new HashMap<>();
            cards.put("S",new HashSet<>());
            cards.put("D",new HashSet<>());
            cards.put("H",new HashSet<>());
            cards.put("C",new HashSet<>());
            
            String s = br.readLine();
            int n = s.length() / 3;
            
            int idx = 0;
            
            boolean possible = true;

            for(int i = 0; i < n; i++){
            	String card = s.substring(idx,idx+3);
                String type = String.valueOf(card.charAt(0));
                int num = Integer.parseInt(card.substring(1,3));
                
                if(cards.get(type).contains(num)){
                	possible = false;
                    break;
                }
                cards.get(type).add(num); 
                idx += 3;
            }
            
            if(!possible){
            	System.out.printf("#%d ERROR\n",test_case);
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(String key : new String[]{"S", "D", "H", "C"}){
            	Set<Integer> c = cards.get(key);
                sb.append(13- c.size()).append(" ");
            }
            
            System.out.printf("#%d %s\n",test_case,sb.toString());

		}
	}
}