import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> classes = new ArrayList<>();

        for (int i = 0 ; i < n; i++){
            StringTokenizer sst = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(sst.nextToken());
            int end = Integer.parseInt(sst.nextToken());
            classes.add(new int[]{start, end});
        }

        classes.sort((a,b)->{
            if (a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }else {
                return Integer.compare(a[0],b[0]);
            }
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        int answer = 1;
        endTimes.add(classes.get(0)[1]);
        for (int i = 1 ; i < n ; i ++){
            int[] currentClass = classes.get(i);
            if (currentClass[0] >= endTimes.peek()) {
                endTimes.poll();
                endTimes.add(currentClass[1]);
            } else {
                answer++;
                endTimes.add(currentClass[1]);
            }
        }

        System.out.print(answer);


    }
}
