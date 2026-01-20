import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {
    static class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int p){
            if(p != parent[p]){
                parent[p] = find(parent[p]);
            }

            return parent[p];
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if(rootP==rootQ){
                return;
            }

            if(rank[rootP]>rank[rootQ]){
                parent[rootQ] = rootP;
            }else if(rank[rootP]<rank[rootQ]){
                parent[rootP] = rootQ;
            }else{
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        UnionFind uf = new UnionFind(n);

        for(int i=1;i<m+1;i++){
            st =  new StringTokenizer(br.readLine()," ");
            int p =  Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int rootP = uf.find(p);
            int rootQ = uf.find(q);

            if(rootP==rootQ){
                System.out.println(i);
                return;
            }
            uf.union(rootP, rootQ);
        }
        System.out.print(0);

    }

}

