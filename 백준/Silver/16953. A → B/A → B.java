import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = 0;
        while (end >= start && end != start ){
            if (end%10 == 1){
                end = end/10;
                if (end < start){
                    System.out.print(-1);
                    return;
                }
                result+=1;
            }else if(end % 2 == 0){
                end /= 2;
                if (end < start){
                    System.out.print(-1);
                    return;
                }
                result +=1;
            }else{
                System.out.print(-1);
                return;
            }

        }

        System.out.print(result+1);
    }
}
