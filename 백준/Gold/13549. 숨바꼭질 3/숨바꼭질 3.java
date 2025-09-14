import java.awt.*;
import java.io.*;
import java.util.*;

public class Main{
    static int[] board = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Arrays.fill(board,Integer.MAX_VALUE);
        board[n] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0});

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int count = cur[1];
            if (x<0 || x>100000) continue;



            if (2*x < 100001 && board[2*x] >  count){
                board[2*x] = count;
                q.add(new int[]{x*2,count});
            }

            if (x+1 < 100001 && board[x+1] > count + 1){
                board[x+1] = count + 1;
                q.add(new int[]{x+1,count+1});
            }

            if (x-1>= 0 && board[x-1] > count + 1){
                board[x-1] = count + 1;
                q.add(new int[]{x-1,count+1});
            }


        }

        System.out.println(board[m]);

    }

}
