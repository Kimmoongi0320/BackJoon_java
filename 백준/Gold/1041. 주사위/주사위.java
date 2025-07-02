import java.io.*;
import java.util.*;

public class Main {
    static int[][] surface2 = {{0,1},{0,4},{0,3},{0,2},{1,5},{1,2},{1,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
    static int[][] surface3 = {{0,3,4},{0,1,3},{1,3,5},{3,4,5},{0,2,4},{0,1,2},{1,2,5},{2,4,5}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] dice = new int[6];
        for (int i = 0; i < 6; i++){
            int num = Integer.parseInt(st.nextToken());
            dice[i] = num;
        }

        if (n == 1) {
            int max = Arrays.stream(dice).max().getAsInt();
            int total = Arrays.stream(dice).sum();
            System.out.println(total - max);
            return;
        }

        int sumSurface2 = Integer.MAX_VALUE;
        int sumSurface3 = Integer.MAX_VALUE;
        int sumSurface1 = Arrays.stream(dice).min().getAsInt();

        for (int[] surface: surface2){
            int sum = dice[surface[0]] + dice[surface[1]];
            if (sum < sumSurface2) sumSurface2 = sum;
        }

        for (int[] surface: surface3){
            int sum = dice[surface[0]] + dice[surface[1]] + dice[surface[2]];
            if (sum < sumSurface3) sumSurface3 = sum;
        }

        long answer = 0;

        answer += (long)sumSurface3 * 4;
        answer += (4 + (long)(n-2) * 8) * sumSurface2;
        answer += ((long) Math.pow(n-2,2)*5 + (long)(n-2)*4)*sumSurface1;

        System.out.print(answer);

    }


}

