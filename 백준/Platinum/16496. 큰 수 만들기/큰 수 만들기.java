import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++){
            nums.add(st.nextToken());
        }

        nums.sort((a,b)->(a+b).compareTo(b+a));

        StringBuilder sb = new StringBuilder();

        for(int i = n-1; i >= 0; i--){
            sb.append(nums.get(i));
        }

        if(sb.charAt(0) == '0'){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }
    }
}