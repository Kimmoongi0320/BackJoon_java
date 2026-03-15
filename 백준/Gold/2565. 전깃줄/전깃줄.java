import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> connect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> pos = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            pos.add(new int[]{from,to});
        }

        pos.sort((a,b)->a[0]-b[0]);

        connect = new ArrayList<>();
        connect.add(pos.get(0)[1]);

        for(int i = 1; i <n; i++){
            int num = pos.get(i)[1];
            if(num > connect.get(connect.size()-1)){
                connect.add(num);
            }else{
                int insertPos = binarySearch(connect.size(),num);
                connect.set(insertPos,num);
            }

        }

        System.out.print(n-connect.size());
    }

    static int binarySearch(int end, int num){
        int start = 0;

        while(start < end){
            int mid = (start+end) /2;
            if(connect.get(mid) < num){
                start = mid +1;
            }else{
                end = mid;
            }
        }

        return end;
    }
}
