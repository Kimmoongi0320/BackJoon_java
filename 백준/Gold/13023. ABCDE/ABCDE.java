import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main{
    static List<List<Integer>> friend ;
    static int[] visited;
    static boolean success = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        friend = new ArrayList<>();
        for(int i=0;i<n;i++){
            friend.add(new ArrayList<>());
        }
        visited = new int[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");

            int  x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friend.get(x).add(y);
            friend.get(y).add(x);
        }

        for (int i=0;i<n;i++){
            if (success){
                System.out.println(1);
                return;
            }
            Arrays.fill(visited,0);
            visited[i]=1;
            backtracking(i,1);
        }

        System.out.println(0);


    }

    public static void backtracking(int cur,int count){
        if (count == 5){
            success = true;
            return;
        }

        for (int node: friend.get(cur)){
            if (success){
                return;
            }
            if (visited[node]==0){
                visited[node]=1;
                backtracking(node,count+1);
                visited[node]=0;
            }
        }
    }
}
