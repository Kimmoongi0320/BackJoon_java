import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n+1; i++){
            nodes.add(new ArrayList<>());
        }
        int[]visited = new int[n+1];

        for (int i = 0; i < m; i++){
            st= new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.get(start).add(end);
            nodes.get(end).add(start);
        }

        int answer = 0;

        for (int i = 1; i < n+1; i++){
            if (visited[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()){
                    int current = queue.poll();
                    visited[current] = 1;
                    for (int node: nodes.get(current)){
                        if (visited[node]==0){
                            queue.add(node);
                            visited[node] = 1;
                        }
                    }
                }
                answer += 1;
            }
        }

        System.out.println(answer);

    }

}
