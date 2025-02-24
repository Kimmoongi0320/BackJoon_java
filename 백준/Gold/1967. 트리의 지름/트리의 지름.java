import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int max = 0;
    static boolean visit[];
    static ArrayList<int []> tree[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        
        
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            tree[p].add(new int[]{c,w});
            tree[c].add(new int[]{p,w});
        }
        
        for(int i=1;i<tree.length;i++){
            visit = new boolean[N+1];
            dfs(i,0);
        }
        System.out.println(max);
    }
    
    static void dfs(int node, int distance){
        visit[node] = true;
        max = Math.max(distance,max);
        
        for(int[] t:tree[node]){
            if(!visit[t[0]]){
                dfs(t[0], distance+t[1]);
            }
        }
    }
}