import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        List<List<Integer>> relations = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            relations.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        int answer = -1;

        boolean[] checked = new boolean[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start,0});
        checked[start] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int person =  cur[0];
            int count = cur[1];

            if(person == end){
                answer = count;
                break;
            }

            for(int next : relations.get(person)){
                if(!checked[next]){
                    checked[next] = true;
                    queue.add(new int[]{next,count+1});
                }
            }
        }
        System.out.print(answer);



    }


}