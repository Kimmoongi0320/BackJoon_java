import java.awt.*;
import  java.util.*;
import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] time = new int[]{start,end};

            times.add(time);
        }

        times.sort((a,b)->{
            if (a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[0],b[0]);
            }
        });

        int answer = 0;
        int end = 0;
        for (int[] time: times){
            if (time[0] >= end){
                answer++;
                end = time[1];
            }
        }

        System.out.print(answer);
    }


}
