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
			List<String> lists = new ArrayList<>();
            String word = br.readLine();

            
            int h = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int[] positions = new int[word.length()+1];
            for(int i = 0; i < h; i++){
            	int pos = Integer.parseInt(st.nextToken());
                positions[pos]++;
            }
            
            StringBuilder sb = new StringBuilder();
            
            int wordIdx = 0;
            for(int idx = 0; idx < word.length()+1; idx++){
            	int count = positions[idx];
                if(count == 0 && wordIdx < word.length()){
                	sb.append(word.charAt(wordIdx++));
                    continue;
                }
                String add = "";
                for(int i = 0; i < count; i++){
                	add += "-";
                }
                sb.append(add);
                if(wordIdx < word.length()) sb.append(word.charAt(wordIdx++));

            }

            
            System.out.printf("#%d %s\n",test_case,sb.toString());

		}
	}
}